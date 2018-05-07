package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteDimensionRequest extends GenericJson {
    @Key
    private DimensionRange range;

    public DimensionRange getRange() {
        return this.range;
    }

    public DeleteDimensionRequest setRange(DimensionRange dimensionRange) {
        this.range = dimensionRange;
        return this;
    }

    public DeleteDimensionRequest set(String str, Object obj) {
        return (DeleteDimensionRequest) super.set(str, obj);
    }

    public DeleteDimensionRequest clone() {
        return (DeleteDimensionRequest) super.clone();
    }
}
