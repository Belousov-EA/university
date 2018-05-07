package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class UpdateDeveloperMetadataResponse extends GenericJson {
    @Key
    private List<DeveloperMetadata> developerMetadata;

    public List<DeveloperMetadata> getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public UpdateDeveloperMetadataResponse setDeveloperMetadata(List<DeveloperMetadata> list) {
        this.developerMetadata = list;
        return this;
    }

    public UpdateDeveloperMetadataResponse set(String str, Object obj) {
        return (UpdateDeveloperMetadataResponse) super.set(str, obj);
    }

    public UpdateDeveloperMetadataResponse clone() {
        return (UpdateDeveloperMetadataResponse) super.clone();
    }
}
