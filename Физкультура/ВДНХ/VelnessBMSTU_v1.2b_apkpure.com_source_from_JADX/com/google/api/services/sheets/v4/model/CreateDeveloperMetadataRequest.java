package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CreateDeveloperMetadataRequest extends GenericJson {
    @Key
    private DeveloperMetadata developerMetadata;

    public DeveloperMetadata getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public CreateDeveloperMetadataRequest setDeveloperMetadata(DeveloperMetadata developerMetadata) {
        this.developerMetadata = developerMetadata;
        return this;
    }

    public CreateDeveloperMetadataRequest set(String str, Object obj) {
        return (CreateDeveloperMetadataRequest) super.set(str, obj);
    }

    public CreateDeveloperMetadataRequest clone() {
        return (CreateDeveloperMetadataRequest) super.clone();
    }
}
