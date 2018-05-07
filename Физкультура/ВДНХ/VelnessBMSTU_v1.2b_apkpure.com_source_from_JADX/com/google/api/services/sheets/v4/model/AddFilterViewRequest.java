package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddFilterViewRequest extends GenericJson {
    @Key
    private FilterView filter;

    public FilterView getFilter() {
        return this.filter;
    }

    public AddFilterViewRequest setFilter(FilterView filterView) {
        this.filter = filterView;
        return this;
    }

    public AddFilterViewRequest set(String str, Object obj) {
        return (AddFilterViewRequest) super.set(str, obj);
    }

    public AddFilterViewRequest clone() {
        return (AddFilterViewRequest) super.clone();
    }
}
