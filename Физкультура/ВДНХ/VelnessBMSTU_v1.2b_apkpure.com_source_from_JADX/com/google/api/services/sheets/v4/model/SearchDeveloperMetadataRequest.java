package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class SearchDeveloperMetadataRequest extends GenericJson {
    @Key
    private List<DataFilter> dataFilters;

    public List<DataFilter> getDataFilters() {
        return this.dataFilters;
    }

    public SearchDeveloperMetadataRequest setDataFilters(List<DataFilter> list) {
        this.dataFilters = list;
        return this;
    }

    public SearchDeveloperMetadataRequest set(String str, Object obj) {
        return (SearchDeveloperMetadataRequest) super.set(str, obj);
    }

    public SearchDeveloperMetadataRequest clone() {
        return (SearchDeveloperMetadataRequest) super.clone();
    }
}
