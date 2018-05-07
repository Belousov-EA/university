package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.Builder;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

public class GoogleJsonResponseException extends HttpResponseException {
    private static final long serialVersionUID = 409811126989994864L;
    private final transient GoogleJsonError details;

    public GoogleJsonResponseException(Builder builder, GoogleJsonError details) {
        super(builder);
        this.details = details;
    }

    public final GoogleJsonError getDetails() {
        return this.details;
    }

    public static GoogleJsonResponseException from(JsonFactory jsonFactory, HttpResponse response) {
        Builder builder = new Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders());
        Preconditions.checkNotNull(jsonFactory);
        GoogleJsonError details = null;
        String detailString = null;
        try {
            StringBuilder message;
            if (response.isSuccessStatusCode() || !HttpMediaType.equalsIgnoreParameters(Json.MEDIA_TYPE, response.getContentType()) || response.getContent() == null) {
                detailString = response.parseAsString();
                message = HttpResponseException.computeMessageBuffer(response);
                if (!Strings.isNullOrEmpty(detailString)) {
                    message.append(StringUtils.LINE_SEPARATOR).append(detailString);
                    builder.setContent(detailString);
                }
                builder.setMessage(message.toString());
                return new GoogleJsonResponseException(builder, details);
            }
            JsonParser parser = null;
            try {
                parser = jsonFactory.createJsonParser(response.getContent());
                JsonToken currentToken = parser.getCurrentToken();
                if (currentToken == null) {
                    currentToken = parser.nextToken();
                }
                if (currentToken != null) {
                    parser.skipToKey("error");
                    if (parser.getCurrentToken() != JsonToken.END_OBJECT) {
                        details = (GoogleJsonError) parser.parseAndClose(GoogleJsonError.class);
                        detailString = details.toPrettyString();
                    }
                }
                if (parser == null) {
                    response.ignore();
                    message = HttpResponseException.computeMessageBuffer(response);
                    if (Strings.isNullOrEmpty(detailString)) {
                        message.append(StringUtils.LINE_SEPARATOR).append(detailString);
                        builder.setContent(detailString);
                    }
                    builder.setMessage(message.toString());
                    return new GoogleJsonResponseException(builder, details);
                }
                if (details == null) {
                    parser.close();
                }
                message = HttpResponseException.computeMessageBuffer(response);
                if (Strings.isNullOrEmpty(detailString)) {
                    message.append(StringUtils.LINE_SEPARATOR).append(detailString);
                    builder.setContent(detailString);
                }
                builder.setMessage(message.toString());
                return new GoogleJsonResponseException(builder, details);
            } catch (IOException exception) {
                exception.printStackTrace();
                if (parser == null) {
                    response.ignore();
                } else if (null == null) {
                    parser.close();
                }
            } catch (Throwable th) {
                if (parser == null) {
                    response.ignore();
                } else if (null == null) {
                    parser.close();
                }
            }
        } catch (IOException exception2) {
            exception2.printStackTrace();
        }
    }

    public static HttpResponse execute(JsonFactory jsonFactory, HttpRequest request) throws GoogleJsonResponseException, IOException {
        Preconditions.checkNotNull(jsonFactory);
        boolean originalThrowExceptionOnExecuteError = request.getThrowExceptionOnExecuteError();
        if (originalThrowExceptionOnExecuteError) {
            request.setThrowExceptionOnExecuteError(false);
        }
        HttpResponse response = request.execute();
        request.setThrowExceptionOnExecuteError(originalThrowExceptionOnExecuteError);
        if (!originalThrowExceptionOnExecuteError || response.isSuccessStatusCode()) {
            return response;
        }
        throw from(jsonFactory, response);
    }
}
