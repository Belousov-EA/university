package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DuplicateFilterViewResponse extends GenericJson {
    @Key
    private FilterView filter;

    public FilterView getFilter() {
        return this.filter;
    }

    public DuplicateFilterViewResponse setFilter(FilterView filterView) {
        this.filter = filterView;
        return this;
    }

    public DuplicateFilterViewResponse set(String str, Object obj) {
        return (DuplicateFilterViewResponse) super.set(str, obj);
    }

    public DuplicateFilterViewResponse clone() {
        return (DuplicateFilterViewResponse) super.clone();
    }
}
