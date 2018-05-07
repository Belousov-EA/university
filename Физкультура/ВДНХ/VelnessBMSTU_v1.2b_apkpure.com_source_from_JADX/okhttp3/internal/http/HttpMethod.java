package okhttp3.internal.http;

import com.google.api.client.http.HttpMethods;

public final class HttpMethod {
    public static boolean invalidatesCache(String method) {
        return method.equals(HttpMethods.POST) || method.equals(HttpMethods.PATCH) || method.equals(HttpMethods.PUT) || method.equals(HttpMethods.DELETE) || method.equals("MOVE");
    }

    public static boolean requiresRequestBody(String method) {
        return method.equals(HttpMethods.POST) || method.equals(HttpMethods.PUT) || method.equals(HttpMethods.PATCH) || method.equals("PROPPATCH") || method.equals("REPORT");
    }

    public static boolean permitsRequestBody(String method) {
        if (requiresRequestBody(method) || method.equals(HttpMethods.OPTIONS) || method.equals(HttpMethods.DELETE) || method.equals("PROPFIND") || method.equals("MKCOL") || method.equals("LOCK")) {
            return true;
        }
        return false;
    }

    public static boolean redirectsWithBody(String method) {
        return method.equals("PROPFIND");
    }

    public static boolean redirectsToGet(String method) {
        return !method.equals("PROPFIND");
    }

    private HttpMethod() {
    }
}
