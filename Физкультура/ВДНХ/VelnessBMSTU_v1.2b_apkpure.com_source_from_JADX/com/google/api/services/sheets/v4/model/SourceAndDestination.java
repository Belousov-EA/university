package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SourceAndDestination extends GenericJson {
    @Key
    private String dimension;
    @Key
    private Integer fillLength;
    @Key
    private GridRange source;

    public String getDimension() {
        return this.dimension;
    }

    public SourceAndDestination setDimension(String str) {
        this.dimension = str;
        return this;
    }

    public Integer getFillLength() {
        return this.fillLength;
    }

    public SourceAndDestination setFillLength(Integer num) {
        this.fillLength = num;
        return this;
    }

    public GridRange getSource() {
        return this.source;
    }

    public SourceAndDestination setSource(GridRange gridRange) {
        this.source = gridRange;
        return this;
    }

    public SourceAndDestination set(String str, Object obj) {
        return (SourceAndDestination) super.set(str, obj);
    }

    public SourceAndDestination clone() {
        return (SourceAndDestination) super.clone();
    }
}
