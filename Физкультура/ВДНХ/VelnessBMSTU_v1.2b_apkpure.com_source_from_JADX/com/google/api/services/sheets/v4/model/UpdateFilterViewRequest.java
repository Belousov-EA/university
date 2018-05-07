package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateFilterViewRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private FilterView filter;

    public String getFields() {
        return this.fields;
    }

    public UpdateFilterViewRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public FilterView getFilter() {
        return this.filter;
    }

    public UpdateFilterViewRequest setFilter(FilterView filterView) {
        this.filter = filterView;
        return this;
    }

    public UpdateFilterViewRequest set(String str, Object obj) {
        return (UpdateFilterViewRequest) super.set(str, obj);
    }

    public UpdateFilterViewRequest clone() {
        return (UpdateFilterViewRequest) super.clone();
    }
}
