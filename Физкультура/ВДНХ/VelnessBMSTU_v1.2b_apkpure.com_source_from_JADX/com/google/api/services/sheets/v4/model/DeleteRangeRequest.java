package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteRangeRequest extends GenericJson {
    @Key
    private GridRange range;
    @Key
    private String shiftDimension;

    public GridRange getRange() {
        return this.range;
    }

    public DeleteRangeRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public String getShiftDimension() {
        return this.shiftDimension;
    }

    public DeleteRangeRequest setShiftDimension(String str) {
        this.shiftDimension = str;
        return this;
    }

    public DeleteRangeRequest set(String str, Object obj) {
        return (DeleteRangeRequest) super.set(str, obj);
    }

    public DeleteRangeRequest clone() {
        return (DeleteRangeRequest) super.clone();
    }
}
