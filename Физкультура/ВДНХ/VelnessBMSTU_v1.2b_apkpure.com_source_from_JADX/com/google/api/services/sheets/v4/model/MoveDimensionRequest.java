package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class MoveDimensionRequest extends GenericJson {
    @Key
    private Integer destinationIndex;
    @Key
    private DimensionRange source;

    public Integer getDestinationIndex() {
        return this.destinationIndex;
    }

    public MoveDimensionRequest setDestinationIndex(Integer num) {
        this.destinationIndex = num;
        return this;
    }

    public DimensionRange getSource() {
        return this.source;
    }

    public MoveDimensionRequest setSource(DimensionRange dimensionRange) {
        this.source = dimensionRange;
        return this;
    }

    public MoveDimensionRequest set(String str, Object obj) {
        return (MoveDimensionRequest) super.set(str, obj);
    }

    public MoveDimensionRequest clone() {
        return (MoveDimensionRequest) super.clone();
    }
}
