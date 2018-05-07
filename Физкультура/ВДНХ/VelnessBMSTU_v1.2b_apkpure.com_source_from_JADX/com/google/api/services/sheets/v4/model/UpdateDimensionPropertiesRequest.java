package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateDimensionPropertiesRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private DimensionProperties properties;
    @Key
    private DimensionRange range;

    public String getFields() {
        return this.fields;
    }

    public UpdateDimensionPropertiesRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public DimensionProperties getProperties() {
        return this.properties;
    }

    public UpdateDimensionPropertiesRequest setProperties(DimensionProperties dimensionProperties) {
        this.properties = dimensionProperties;
        return this;
    }

    public DimensionRange getRange() {
        return this.range;
    }

    public UpdateDimensionPropertiesRequest setRange(DimensionRange dimensionRange) {
        this.range = dimensionRange;
        return this;
    }

    public UpdateDimensionPropertiesRequest set(String str, Object obj) {
        return (UpdateDimensionPropertiesRequest) super.set(str, obj);
    }

    public UpdateDimensionPropertiesRequest clone() {
        return (UpdateDimensionPropertiesRequest) super.clone();
    }
}
