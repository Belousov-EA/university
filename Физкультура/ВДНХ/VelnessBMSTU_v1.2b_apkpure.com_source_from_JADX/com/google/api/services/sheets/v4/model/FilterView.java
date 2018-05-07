package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

public final class FilterView extends GenericJson {
    @Key
    private Map<String, FilterCriteria> criteria;
    @Key
    private Integer filterViewId;
    @Key
    private String namedRangeId;
    @Key
    private GridRange range;
    @Key
    private List<SortSpec> sortSpecs;
    @Key
    private String title;

    static {
        Data.nullOf(FilterCriteria.class);
        Data.nullOf(SortSpec.class);
    }

    public Map<String, FilterCriteria> getCriteria() {
        return this.criteria;
    }

    public FilterView setCriteria(Map<String, FilterCriteria> map) {
        this.criteria = map;
        return this;
    }

    public Integer getFilterViewId() {
        return this.filterViewId;
    }

    public FilterView setFilterViewId(Integer num) {
        this.filterViewId = num;
        return this;
    }

    public String getNamedRangeId() {
        return this.namedRangeId;
    }

    public FilterView setNamedRangeId(String str) {
        this.namedRangeId = str;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public FilterView setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public List<SortSpec> getSortSpecs() {
        return this.sortSpecs;
    }

    public FilterView setSortSpecs(List<SortSpec> list) {
        this.sortSpecs = list;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public FilterView setTitle(String str) {
        this.title = str;
        return this;
    }

    public FilterView set(String str, Object obj) {
        return (FilterView) super.set(str, obj);
    }

    public FilterView clone() {
        return (FilterView) super.clone();
    }
}
