package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class TextPosition extends GenericJson {
    @Key
    private String horizontalAlignment;

    public String getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public TextPosition setHorizontalAlignment(String str) {
        this.horizontalAlignment = str;
        return this;
    }

    public TextPosition set(String str, Object obj) {
        return (TextPosition) super.set(str, obj);
    }

    public TextPosition clone() {
        return (TextPosition) super.clone();
    }
}
