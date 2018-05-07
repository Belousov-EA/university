package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DimensionRange extends GenericJson {
    @Key
    private String dimension;
    @Key
    private Integer endIndex;
    @Key
    private Integer sheetId;
    @Key
    private Integer startIndex;

    public String getDimension() {
        return this.dimension;
    }

    public DimensionRange setDimension(String str) {
        this.dimension = str;
        return this;
    }

    public Integer getEndIndex() {
        return this.endIndex;
    }

    public DimensionRange setEndIndex(Integer num) {
        this.endIndex = num;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public DimensionRange setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public DimensionRange setStartIndex(Integer num) {
        this.startIndex = num;
        return this;
    }

    public DimensionRange set(String str, Object obj) {
        return (DimensionRange) super.set(str, obj);
    }

    public DimensionRange clone() {
        return (DimensionRange) super.clone();
    }
}
