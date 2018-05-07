package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ErrorValue extends GenericJson {
    @Key
    private String message;
    @Key
    private String type;

    public String getMessage() {
        return this.message;
    }

    public ErrorValue setMessage(String str) {
        this.message = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public ErrorValue setType(String str) {
        this.type = str;
        return this;
    }

    public ErrorValue set(String str, Object obj) {
        return (ErrorValue) super.set(str, obj);
    }

    public ErrorValue clone() {
        return (ErrorValue) super.clone();
    }
}
