package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteDeveloperMetadataRequest extends GenericJson {
    @Key
    private DataFilter dataFilter;

    public DataFilter getDataFilter() {
        return this.dataFilter;
    }

    public DeleteDeveloperMetadataRequest setDataFilter(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
        return this;
    }

    public DeleteDeveloperMetadataRequest set(String str, Object obj) {
        return (DeleteDeveloperMetadataRequest) super.set(str, obj);
    }

    public DeleteDeveloperMetadataRequest clone() {
        return (DeleteDeveloperMetadataRequest) super.clone();
    }
}
