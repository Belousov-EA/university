package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class DeleteDeveloperMetadataResponse extends GenericJson {
    @Key
    private List<DeveloperMetadata> deletedDeveloperMetadata;

    public List<DeveloperMetadata> getDeletedDeveloperMetadata() {
        return this.deletedDeveloperMetadata;
    }

    public DeleteDeveloperMetadataResponse setDeletedDeveloperMetadata(List<DeveloperMetadata> list) {
        this.deletedDeveloperMetadata = list;
        return this;
    }

    public DeleteDeveloperMetadataResponse set(String str, Object obj) {
        return (DeleteDeveloperMetadataResponse) super.set(str, obj);
    }

    public DeleteDeveloperMetadataResponse clone() {
        return (DeleteDeveloperMetadataResponse) super.clone();
    }
}
