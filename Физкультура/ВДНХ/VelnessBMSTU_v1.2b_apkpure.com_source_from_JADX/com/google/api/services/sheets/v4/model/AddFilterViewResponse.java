package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddFilterViewResponse extends GenericJson {
    @Key
    private FilterView filter;

    public FilterView getFilter() {
        return this.filter;
    }

    public AddFilterViewResponse setFilter(FilterView filterView) {
        this.filter = filterView;
        return this;
    }

    public AddFilterViewResponse set(String str, Object obj) {
        return (AddFilterViewResponse) super.set(str, obj);
    }

    public AddFilterViewResponse clone() {
        return (AddFilterViewResponse) super.clone();
    }
}
