package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class InsertRangeRequest extends GenericJson {
    @Key
    private GridRange range;
    @Key
    private String shiftDimension;

    public GridRange getRange() {
        return this.range;
    }

    public InsertRangeRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public String getShiftDimension() {
        return this.shiftDimension;
    }

    public InsertRangeRequest setShiftDimension(String str) {
        this.shiftDimension = str;
        return this;
    }

    public InsertRangeRequest set(String str, Object obj) {
        return (InsertRangeRequest) super.set(str, obj);
    }

    public InsertRangeRequest clone() {
        return (InsertRangeRequest) super.clone();
    }
}
