package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class ValueRange extends GenericJson {
    @Key
    private String majorDimension;
    @Key
    private String range;
    @Key
    private List<List<Object>> values;

    public String getMajorDimension() {
        return this.majorDimension;
    }

    public ValueRange setMajorDimension(String str) {
        this.majorDimension = str;
        return this;
    }

    public String getRange() {
        return this.range;
    }

    public ValueRange setRange(String str) {
        this.range = str;
        return this;
    }

    public List<List<Object>> getValues() {
        return this.values;
    }

    public ValueRange setValues(List<List<Object>> list) {
        this.values = list;
        return this;
    }

    public ValueRange set(String str, Object obj) {
        return (ValueRange) super.set(str, obj);
    }

    public ValueRange clone() {
        return (ValueRange) super.clone();
    }
}
