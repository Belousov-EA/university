package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

final class NetHttpRequest extends LowLevelHttpRequest {
    private final HttpURLConnection connection;

    NetHttpRequest(HttpURLConnection connection) {
        this.connection = connection;
        connection.setInstanceFollowRedirects(false);
    }

    public void addHeader(String name, String value) {
        this.connection.addRequestProperty(name, value);
    }

    public void setTimeout(int connectTimeout, int readTimeout) {
        this.connection.setReadTimeout(readTimeout);
        this.connection.setConnectTimeout(connectTimeout);
    }

    public LowLevelHttpResponse execute() throws IOException {
        HttpURLConnection connection = this.connection;
        if (getStreamingContent() != null) {
            String contentType = getContentType();
            if (contentType != null) {
                addHeader(HttpHeaders.CONTENT_TYPE, contentType);
            }
            String contentEncoding = getContentEncoding();
            if (contentEncoding != null) {
                addHeader(HttpHeaders.CONTENT_ENCODING, contentEncoding);
            }
            long contentLength = getContentLength();
            if (contentLength >= 0) {
                addHeader(HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
            }
            String requestMethod = connection.getRequestMethod();
            if (HttpMethods.POST.equals(requestMethod) || HttpMethods.PUT.equals(requestMethod)) {
                connection.setDoOutput(true);
                if (contentLength < 0 || contentLength > 2147483647L) {
                    connection.setChunkedStreamingMode(0);
                } else {
                    connection.setFixedLengthStreamingMode((int) contentLength);
                }
                OutputStream out = connection.getOutputStream();
                boolean threw = true;
                try {
                    getStreamingContent().writeTo(out);
                    threw = false;
                } finally {
                    try {
                        out.close();
                    } catch (IOException exception) {
                        if (!threw) {
                            throw exception;
                        }
                    }
                }
            }
            Preconditions.checkArgument(contentLength == 0, "%s with non-zero content length is not supported", requestMethod);
        }
        boolean successfulConnection = false;
        try {
            connection.connect();
            NetHttpResponse response = new NetHttpResponse(connection);
            successfulConnection = true;
            return response;
        } finally {
            if (!successfulConnection) {
                connection.disconnect();
            }
        }
    }
}
