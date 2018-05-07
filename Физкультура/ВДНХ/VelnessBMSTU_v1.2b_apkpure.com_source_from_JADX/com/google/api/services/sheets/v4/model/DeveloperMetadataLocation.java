package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeveloperMetadataLocation extends GenericJson {
    @Key
    private DimensionRange dimensionRange;
    @Key
    private String locationType;
    @Key
    private Integer sheetId;
    @Key
    private Boolean spreadsheet;

    public DimensionRange getDimensionRange() {
        return this.dimensionRange;
    }

    public DeveloperMetadataLocation setDimensionRange(DimensionRange dimensionRange) {
        this.dimensionRange = dimensionRange;
        return this;
    }

    public String getLocationType() {
        return this.locationType;
    }

    public DeveloperMetadataLocation setLocationType(String str) {
        this.locationType = str;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public DeveloperMetadataLocation setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public Boolean getSpreadsheet() {
        return this.spreadsheet;
    }

    public DeveloperMetadataLocation setSpreadsheet(Boolean bool) {
        this.spreadsheet = bool;
        return this;
    }

    public DeveloperMetadataLocation set(String str, Object obj) {
        return (DeveloperMetadataLocation) super.set(str, obj);
    }

    public DeveloperMetadataLocation clone() {
        return (DeveloperMetadataLocation) super.clone();
    }
}
