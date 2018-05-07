package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeveloperMetadata extends GenericJson {
    @Key
    private DeveloperMetadataLocation location;
    @Key
    private Integer metadataId;
    @Key
    private String metadataKey;
    @Key
    private String metadataValue;
    @Key
    private String visibility;

    public DeveloperMetadataLocation getLocation() {
        return this.location;
    }

    public DeveloperMetadata setLocation(DeveloperMetadataLocation developerMetadataLocation) {
        this.location = developerMetadataLocation;
        return this;
    }

    public Integer getMetadataId() {
        return this.metadataId;
    }

    public DeveloperMetadata setMetadataId(Integer num) {
        this.metadataId = num;
        return this;
    }

    public String getMetadataKey() {
        return this.metadataKey;
    }

    public DeveloperMetadata setMetadataKey(String str) {
        this.metadataKey = str;
        return this;
    }

    public String getMetadataValue() {
        return this.metadataValue;
    }

    public DeveloperMetadata setMetadataValue(String str) {
        this.metadataValue = str;
        return this;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public DeveloperMetadata setVisibility(String str) {
        this.visibility = str;
        return this;
    }

    public DeveloperMetadata set(String str, Object obj) {
        return (DeveloperMetadata) super.set(str, obj);
    }

    public DeveloperMetadata clone() {
        return (DeveloperMetadata) super.clone();
    }
}
