package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class InsertDimensionRequest extends GenericJson {
    @Key
    private Boolean inheritFromBefore;
    @Key
    private DimensionRange range;

    public Boolean getInheritFromBefore() {
        return this.inheritFromBefore;
    }

    public InsertDimensionRequest setInheritFromBefore(Boolean bool) {
        this.inheritFromBefore = bool;
        return this;
    }

    public DimensionRange getRange() {
        return this.range;
    }

    public InsertDimensionRequest setRange(DimensionRange dimensionRange) {
        this.range = dimensionRange;
        return this;
    }

    public InsertDimensionRequest set(String str, Object obj) {
        return (InsertDimensionRequest) super.set(str, obj);
    }

    public InsertDimensionRequest clone() {
        return (InsertDimensionRequest) super.clone();
    }
}
