package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

public final class BasicFilter extends GenericJson {
    @Key
    private Map<String, FilterCriteria> criteria;
    @Key
    private GridRange range;
    @Key
    private List<SortSpec> sortSpecs;

    static {
        Data.nullOf(FilterCriteria.class);
        Data.nullOf(SortSpec.class);
    }

    public Map<String, FilterCriteria> getCriteria() {
        return this.criteria;
    }

    public BasicFilter setCriteria(Map<String, FilterCriteria> map) {
        this.criteria = map;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public BasicFilter setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public List<SortSpec> getSortSpecs() {
        return this.sortSpecs;
    }

    public BasicFilter setSortSpecs(List<SortSpec> list) {
        this.sortSpecs = list;
        return this;
    }

    public BasicFilter set(String str, Object obj) {
        return (BasicFilter) super.set(str, obj);
    }

    public BasicFilter clone() {
        return (BasicFilter) super.clone();
    }
}
