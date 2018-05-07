package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class MergeCellsRequest extends GenericJson {
    @Key
    private String mergeType;
    @Key
    private GridRange range;

    public String getMergeType() {
        return this.mergeType;
    }

    public MergeCellsRequest setMergeType(String str) {
        this.mergeType = str;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public MergeCellsRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public MergeCellsRequest set(String str, Object obj) {
        return (MergeCellsRequest) super.set(str, obj);
    }

    public MergeCellsRequest clone() {
        return (MergeCellsRequest) super.clone();
    }
}
