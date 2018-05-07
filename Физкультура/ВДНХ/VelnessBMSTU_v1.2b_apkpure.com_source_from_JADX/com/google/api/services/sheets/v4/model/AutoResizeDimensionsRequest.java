package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AutoResizeDimensionsRequest extends GenericJson {
    @Key
    private DimensionRange dimensions;

    public DimensionRange getDimensions() {
        return this.dimensions;
    }

    public AutoResizeDimensionsRequest setDimensions(DimensionRange dimensionRange) {
        this.dimensions = dimensionRange;
        return this;
    }

    public AutoResizeDimensionsRequest set(String str, Object obj) {
        return (AutoResizeDimensionsRequest) super.set(str, obj);
    }

    public AutoResizeDimensionsRequest clone() {
        return (AutoResizeDimensionsRequest) super.clone();
    }
}
