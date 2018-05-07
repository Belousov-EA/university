package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DataFilter extends GenericJson {
    @Key
    private String a1Range;
    @Key
    private DeveloperMetadataLookup developerMetadataLookup;
    @Key
    private GridRange gridRange;

    public String getA1Range() {
        return this.a1Range;
    }

    public DataFilter setA1Range(String str) {
        this.a1Range = str;
        return this;
    }

    public DeveloperMetadataLookup getDeveloperMetadataLookup() {
        return this.developerMetadataLookup;
    }

    public DataFilter setDeveloperMetadataLookup(DeveloperMetadataLookup developerMetadataLookup) {
        this.developerMetadataLookup = developerMetadataLookup;
        return this;
    }

    public GridRange getGridRange() {
        return this.gridRange;
    }

    public DataFilter setGridRange(GridRange gridRange) {
        this.gridRange = gridRange;
        return this;
    }

    public DataFilter set(String str, Object obj) {
        return (DataFilter) super.set(str, obj);
    }

    public DataFilter clone() {
        return (DataFilter) super.clone();
    }
}
