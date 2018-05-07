package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeveloperMetadataLookup extends GenericJson {
    @Key
    private String locationMatchingStrategy;
    @Key
    private String locationType;
    @Key
    private Integer metadataId;
    @Key
    private String metadataKey;
    @Key
    private DeveloperMetadataLocation metadataLocation;
    @Key
    private String metadataValue;
    @Key
    private String visibility;

    public String getLocationMatchingStrategy() {
        return this.locationMatchingStrategy;
    }

    public DeveloperMetadataLookup setLocationMatchingStrategy(String str) {
        this.locationMatchingStrategy = str;
        return this;
    }

    public String getLocationType() {
        return this.locationType;
    }

    public DeveloperMetadataLookup setLocationType(String str) {
        this.locationType = str;
        return this;
    }

    public Integer getMetadataId() {
        return this.metadataId;
    }

    public DeveloperMetadataLookup setMetadataId(Integer num) {
        this.metadataId = num;
        return this;
    }

    public String getMetadataKey() {
        return this.metadataKey;
    }

    public DeveloperMetadataLookup setMetadataKey(String str) {
        this.metadataKey = str;
        return this;
    }

    public DeveloperMetadataLocation getMetadataLocation() {
        return this.metadataLocation;
    }

    public DeveloperMetadataLookup setMetadataLocation(DeveloperMetadataLocation developerMetadataLocation) {
        this.metadataLocation = developerMetadataLocation;
        return this;
    }

    public String getMetadataValue() {
        return this.metadataValue;
    }

    public DeveloperMetadataLookup setMetadataValue(String str) {
        this.metadataValue = str;
        return this;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public DeveloperMetadataLookup setVisibility(String str) {
        this.visibility = str;
        return this;
    }

    public DeveloperMetadataLookup set(String str, Object obj) {
        return (DeveloperMetadataLookup) super.set(str, obj);
    }

    public DeveloperMetadataLookup clone() {
        return (DeveloperMetadataLookup) super.clone();
    }
}
