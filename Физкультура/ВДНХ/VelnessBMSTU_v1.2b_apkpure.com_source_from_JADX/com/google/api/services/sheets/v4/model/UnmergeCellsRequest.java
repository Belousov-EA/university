package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UnmergeCellsRequest extends GenericJson {
    @Key
    private GridRange range;

    public GridRange getRange() {
        return this.range;
    }

    public UnmergeCellsRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public UnmergeCellsRequest set(String str, Object obj) {
        return (UnmergeCellsRequest) super.set(str, obj);
    }

    public UnmergeCellsRequest clone() {
        return (UnmergeCellsRequest) super.clone();
    }
}
