package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class RandomizeRangeRequest extends GenericJson {
    @Key
    private GridRange range;

    public GridRange getRange() {
        return this.range;
    }

    public RandomizeRangeRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public RandomizeRangeRequest set(String str, Object obj) {
        return (RandomizeRangeRequest) super.set(str, obj);
    }

    public RandomizeRangeRequest clone() {
        return (RandomizeRangeRequest) super.clone();
    }
}
