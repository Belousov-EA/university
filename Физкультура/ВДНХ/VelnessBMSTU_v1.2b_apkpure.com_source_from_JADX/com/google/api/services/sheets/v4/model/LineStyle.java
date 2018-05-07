package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LineStyle extends GenericJson {
    @Key
    private String type;
    @Key
    private Integer width;

    public String getType() {
        return this.type;
    }

    public LineStyle setType(String str) {
        this.type = str;
        return this;
    }

    public Integer getWidth() {
        return this.width;
    }

    public LineStyle setWidth(Integer num) {
        this.width = num;
        return this;
    }

    public LineStyle set(String str, Object obj) {
        return (LineStyle) super.set(str, obj);
    }

    public LineStyle clone() {
        return (LineStyle) super.clone();
    }
}
