package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class UpdateDeveloperMetadataRequest extends GenericJson {
    @Key
    private List<DataFilter> dataFilters;
    @Key
    private DeveloperMetadata developerMetadata;
    @Key
    private String fields;

    public List<DataFilter> getDataFilters() {
        return this.dataFilters;
    }

    public UpdateDeveloperMetadataRequest setDataFilters(List<DataFilter> list) {
        this.dataFilters = list;
        return this;
    }

    public DeveloperMetadata getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public UpdateDeveloperMetadataRequest setDeveloperMetadata(DeveloperMetadata developerMetadata) {
        this.developerMetadata = developerMetadata;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public UpdateDeveloperMetadataRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public UpdateDeveloperMetadataRequest set(String str, Object obj) {
        return (UpdateDeveloperMetadataRequest) super.set(str, obj);
    }

    public UpdateDeveloperMetadataRequest clone() {
        return (UpdateDeveloperMetadataRequest) super.clone();
    }
}
