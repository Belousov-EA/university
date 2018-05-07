package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteEmbeddedObjectRequest extends GenericJson {
    @Key
    private Integer objectId;

    public Integer getObjectId() {
        return this.objectId;
    }

    public DeleteEmbeddedObjectRequest setObjectId(Integer num) {
        this.objectId = num;
        return this;
    }

    public DeleteEmbeddedObjectRequest set(String str, Object obj) {
        return (DeleteEmbeddedObjectRequest) super.set(str, obj);
    }

    public DeleteEmbeddedObjectRequest clone() {
        return (DeleteEmbeddedObjectRequest) super.clone();
    }
}
