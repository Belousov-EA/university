package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateEmbeddedObjectPositionRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private EmbeddedObjectPosition newPosition;
    @Key
    private Integer objectId;

    public String getFields() {
        return this.fields;
    }

    public UpdateEmbeddedObjectPositionRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public EmbeddedObjectPosition getNewPosition() {
        return this.newPosition;
    }

    public UpdateEmbeddedObjectPositionRequest setNewPosition(EmbeddedObjectPosition embeddedObjectPosition) {
        this.newPosition = embeddedObjectPosition;
        return this;
    }

    public Integer getObjectId() {
        return this.objectId;
    }

    public UpdateEmbeddedObjectPositionRequest setObjectId(Integer num) {
        this.objectId = num;
        return this;
    }

    public UpdateEmbeddedObjectPositionRequest set(String str, Object obj) {
        return (UpdateEmbeddedObjectPositionRequest) super.set(str, obj);
    }

    public UpdateEmbeddedObjectPositionRequest clone() {
        return (UpdateEmbeddedObjectPositionRequest) super.clone();
    }
}
