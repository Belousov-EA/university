package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SortSpec extends GenericJson {
    @Key
    private Integer dimensionIndex;
    @Key
    private String sortOrder;

    public Integer getDimensionIndex() {
        return this.dimensionIndex;
    }

    public SortSpec setDimensionIndex(Integer num) {
        this.dimensionIndex = num;
        return this;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public SortSpec setSortOrder(String str) {
        this.sortOrder = str;
        return this;
    }

    public SortSpec set(String str, Object obj) {
        return (SortSpec) super.set(str, obj);
    }

    public SortSpec clone() {
        return (SortSpec) super.clone();
    }
}
