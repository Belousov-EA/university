package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CreateDeveloperMetadataResponse extends GenericJson {
    @Key
    private DeveloperMetadata developerMetadata;

    public DeveloperMetadata getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public CreateDeveloperMetadataResponse setDeveloperMetadata(DeveloperMetadata developerMetadata) {
        this.developerMetadata = developerMetadata;
        return this;
    }

    public CreateDeveloperMetadataResponse set(String str, Object obj) {
        return (CreateDeveloperMetadataResponse) super.set(str, obj);
    }

    public CreateDeveloperMetadataResponse clone() {
        return (CreateDeveloperMetadataResponse) super.clone();
    }
}
