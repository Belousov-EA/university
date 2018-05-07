package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class MatchedDeveloperMetadata extends GenericJson {
    @Key
    private List<DataFilter> dataFilters;
    @Key
    private DeveloperMetadata developerMetadata;

    public List<DataFilter> getDataFilters() {
        return this.dataFilters;
    }

    public MatchedDeveloperMetadata setDataFilters(List<DataFilter> list) {
        this.dataFilters = list;
        return this;
    }

    public DeveloperMetadata getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public MatchedDeveloperMetadata setDeveloperMetadata(DeveloperMetadata developerMetadata) {
        this.developerMetadata = developerMetadata;
        return this;
    }

    public MatchedDeveloperMetadata set(String str, Object obj) {
        return (MatchedDeveloperMetadata) super.set(str, obj);
    }

    public MatchedDeveloperMetadata clone() {
        return (MatchedDeveloperMetadata) super.clone();
    }
}
