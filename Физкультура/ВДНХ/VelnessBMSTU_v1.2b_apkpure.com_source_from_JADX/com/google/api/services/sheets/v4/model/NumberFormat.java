package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class NumberFormat extends GenericJson {
    @Key
    private String pattern;
    @Key
    private String type;

    public String getPattern() {
        return this.pattern;
    }

    public NumberFormat setPattern(String str) {
        this.pattern = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public NumberFormat setType(String str) {
        this.type = str;
        return this;
    }

    public NumberFormat set(String str, Object obj) {
        return (NumberFormat) super.set(str, obj);
    }

    public NumberFormat clone() {
        return (NumberFormat) super.clone();
    }
}
