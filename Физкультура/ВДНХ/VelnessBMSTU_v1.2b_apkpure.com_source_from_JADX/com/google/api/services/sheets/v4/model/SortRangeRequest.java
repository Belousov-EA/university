package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class SortRangeRequest extends GenericJson {
    @Key
    private GridRange range;
    @Key
    private List<SortSpec> sortSpecs;

    static {
        Data.nullOf(SortSpec.class);
    }

    public GridRange getRange() {
        return this.range;
    }

    public SortRangeRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public List<SortSpec> getSortSpecs() {
        return this.sortSpecs;
    }

    public SortRangeRequest setSortSpecs(List<SortSpec> list) {
        this.sortSpecs = list;
        return this;
    }

    public SortRangeRequest set(String str, Object obj) {
        return (SortRangeRequest) super.set(str, obj);
    }

    public SortRangeRequest clone() {
        return (SortRangeRequest) super.clone();
    }
}
