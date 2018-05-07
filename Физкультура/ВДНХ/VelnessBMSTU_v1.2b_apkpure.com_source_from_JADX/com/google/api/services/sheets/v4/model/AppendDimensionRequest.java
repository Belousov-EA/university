package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AppendDimensionRequest extends GenericJson {
    @Key
    private String dimension;
    @Key
    private Integer length;
    @Key
    private Integer sheetId;

    public String getDimension() {
        return this.dimension;
    }

    public AppendDimensionRequest setDimension(String str) {
        this.dimension = str;
        return this;
    }

    public Integer getLength() {
        return this.length;
    }

    public AppendDimensionRequest setLength(Integer num) {
        this.length = num;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public AppendDimensionRequest setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public AppendDimensionRequest set(String str, Object obj) {
        return (AppendDimensionRequest) super.set(str, obj);
    }

    public AppendDimensionRequest clone() {
        return (AppendDimensionRequest) super.clone();
    }
}
