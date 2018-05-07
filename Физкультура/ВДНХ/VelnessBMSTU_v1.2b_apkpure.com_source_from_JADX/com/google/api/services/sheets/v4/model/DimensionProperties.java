package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class DimensionProperties extends GenericJson {
    @Key
    private List<DeveloperMetadata> developerMetadata;
    @Key
    private Boolean hiddenByFilter;
    @Key
    private Boolean hiddenByUser;
    @Key
    private Integer pixelSize;

    static {
        Data.nullOf(DeveloperMetadata.class);
    }

    public List<DeveloperMetadata> getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public DimensionProperties setDeveloperMetadata(List<DeveloperMetadata> list) {
        this.developerMetadata = list;
        return this;
    }

    public Boolean getHiddenByFilter() {
        return this.hiddenByFilter;
    }

    public DimensionProperties setHiddenByFilter(Boolean bool) {
        this.hiddenByFilter = bool;
        return this;
    }

    public Boolean getHiddenByUser() {
        return this.hiddenByUser;
    }

    public DimensionProperties setHiddenByUser(Boolean bool) {
        this.hiddenByUser = bool;
        return this;
    }

    public Integer getPixelSize() {
        return this.pixelSize;
    }

    public DimensionProperties setPixelSize(Integer num) {
        this.pixelSize = num;
        return this;
    }

    public DimensionProperties set(String str, Object obj) {
        return (DimensionProperties) super.set(str, obj);
    }

    public DimensionProperties clone() {
        return (DimensionProperties) super.clone();
    }
}
