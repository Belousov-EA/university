package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AutoFillRequest extends GenericJson {
    @Key
    private GridRange range;
    @Key
    private SourceAndDestination sourceAndDestination;
    @Key
    private Boolean useAlternateSeries;

    public GridRange getRange() {
        return this.range;
    }

    public AutoFillRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public SourceAndDestination getSourceAndDestination() {
        return this.sourceAndDestination;
    }

    public AutoFillRequest setSourceAndDestination(SourceAndDestination sourceAndDestination) {
        this.sourceAndDestination = sourceAndDestination;
        return this;
    }

    public Boolean getUseAlternateSeries() {
        return this.useAlternateSeries;
    }

    public AutoFillRequest setUseAlternateSeries(Boolean bool) {
        this.useAlternateSeries = bool;
        return this;
    }

    public AutoFillRequest set(String str, Object obj) {
        return (AutoFillRequest) super.set(str, obj);
    }

    public AutoFillRequest clone() {
        return (AutoFillRequest) super.clone();
    }
}
