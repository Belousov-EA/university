package okhttp3.internal.cache;

import com.google.api.client.http.HttpStatusCodes;
import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.StatusLine;

public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    public static class Factory {
        private int ageSeconds = -1;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long nowMillis, Request request, Response cacheResponse) {
            this.nowMillis = nowMillis;
            this.request = request;
            this.cacheResponse = cacheResponse;
            if (cacheResponse != null) {
                this.sentRequestMillis = cacheResponse.sentRequestAtMillis();
                this.receivedResponseMillis = cacheResponse.receivedResponseAtMillis();
                Headers headers = cacheResponse.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String fieldName = headers.name(i);
                    String value = headers.value(i);
                    if (HttpHeaders.DATE.equalsIgnoreCase(fieldName)) {
                        this.servedDate = HttpDate.parse(value);
                        this.servedDateString = value;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(fieldName)) {
                        this.expires = HttpDate.parse(value);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(fieldName)) {
                        this.lastModified = HttpDate.parse(value);
                        this.lastModifiedString = value;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(fieldName)) {
                        this.etag = value;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(fieldName)) {
                        this.ageSeconds = okhttp3.internal.http.HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        public CacheStrategy get() {
            CacheStrategy candidate = getCandidate();
            if (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) {
                return candidate;
            }
            return new CacheStrategy(null, null);
        }

        private CacheStrategy getCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl requestCaching = this.request.cacheControl();
            if (requestCaching.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            long ageMillis = cacheResponseAge();
            long freshMillis = computeFreshnessLifetime();
            if (requestCaching.maxAgeSeconds() != -1) {
                freshMillis = Math.min(freshMillis, TimeUnit.SECONDS.toMillis((long) requestCaching.maxAgeSeconds()));
            }
            long minFreshMillis = 0;
            if (requestCaching.minFreshSeconds() != -1) {
                minFreshMillis = TimeUnit.SECONDS.toMillis((long) requestCaching.minFreshSeconds());
            }
            long maxStaleMillis = 0;
            CacheControl responseCaching = this.cacheResponse.cacheControl();
            if (!(responseCaching.mustRevalidate() || requestCaching.maxStaleSeconds() == -1)) {
                maxStaleMillis = TimeUnit.SECONDS.toMillis((long) requestCaching.maxStaleSeconds());
            }
            if (responseCaching.noCache() || ageMillis + minFreshMillis >= freshMillis + maxStaleMillis) {
                String conditionName;
                String conditionValue;
                if (this.etag != null) {
                    conditionName = HttpHeaders.IF_NONE_MATCH;
                    conditionValue = this.etag;
                } else if (this.lastModified != null) {
                    conditionName = HttpHeaders.IF_MODIFIED_SINCE;
                    conditionValue = this.lastModifiedString;
                } else if (this.servedDate == null) {
                    return new CacheStrategy(this.request, null);
                } else {
                    conditionName = HttpHeaders.IF_MODIFIED_SINCE;
                    conditionValue = this.servedDateString;
                }
                Builder conditionalRequestHeaders = this.request.headers().newBuilder();
                Internal.instance.addLenient(conditionalRequestHeaders, conditionName, conditionValue);
                return new CacheStrategy(this.request.newBuilder().headers(conditionalRequestHeaders.build()).build(), this.cacheResponse);
            }
            Response.Builder builder = this.cacheResponse.newBuilder();
            if (ageMillis + minFreshMillis >= freshMillis) {
                builder.addHeader(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
            }
            if (ageMillis > 86400000 && isFreshnessLifetimeHeuristic()) {
                builder.addHeader(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new CacheStrategy(null, builder.build());
        }

        private long computeFreshnessLifetime() {
            CacheControl responseCaching = this.cacheResponse.cacheControl();
            if (responseCaching.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) responseCaching.maxAgeSeconds());
            }
            long servedMillis;
            long delta;
            if (this.expires != null) {
                if (this.servedDate != null) {
                    servedMillis = this.servedDate.getTime();
                } else {
                    servedMillis = this.receivedResponseMillis;
                }
                delta = this.expires.getTime() - servedMillis;
                if (delta <= 0) {
                    delta = 0;
                }
                return delta;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0;
            } else {
                if (this.servedDate != null) {
                    servedMillis = this.servedDate.getTime();
                } else {
                    servedMillis = this.sentRequestMillis;
                }
                delta = servedMillis - this.lastModified.getTime();
                if (delta > 0) {
                    return delta / 10;
                }
                return 0;
            }
        }

        private long cacheResponseAge() {
            long receivedAge;
            long apparentReceivedAge = 0;
            if (this.servedDate != null) {
                apparentReceivedAge = Math.max(0, this.receivedResponseMillis - this.servedDate.getTime());
            }
            if (this.ageSeconds != -1) {
                receivedAge = Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis((long) this.ageSeconds));
            } else {
                receivedAge = apparentReceivedAge;
            }
            return (receivedAge + (this.receivedResponseMillis - this.sentRequestMillis)) + (this.nowMillis - this.receivedResponseMillis);
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        private static boolean hasConditions(Request request) {
            return (request.header(HttpHeaders.IF_MODIFIED_SINCE) == null && request.header(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }

    CacheStrategy(Request networkRequest, Response cacheResponse) {
        this.networkRequest = networkRequest;
        this.cacheResponse = cacheResponse;
    }

    public static boolean isCacheable(Response response, Request request) {
        switch (response.code()) {
            case 200:
            case 203:
            case HttpStatusCodes.STATUS_CODE_NO_CONTENT /*204*/:
            case HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES /*300*/:
            case HttpStatusCodes.STATUS_CODE_MOVED_PERMANENTLY /*301*/:
            case StatusLine.HTTP_PERM_REDIRECT /*308*/:
            case HttpStatusCodes.STATUS_CODE_NOT_FOUND /*404*/:
            case HttpStatusCodes.STATUS_CODE_METHOD_NOT_ALLOWED /*405*/:
            case 410:
            case 414:
            case 501:
                break;
            case HttpStatusCodes.STATUS_CODE_FOUND /*302*/:
            case 307:
                if (response.header(HttpHeaders.EXPIRES) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            default:
                return false;
        }
        return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
    }
}
