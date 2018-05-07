package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateEmbeddedObjectPositionResponse extends GenericJson {
    @Key
    private EmbeddedObjectPosition position;

    public EmbeddedObjectPosition getPosition() {
        return this.position;
    }

    public UpdateEmbeddedObjectPositionResponse setPosition(EmbeddedObjectPosition embeddedObjectPosition) {
        this.position = embeddedObjectPosition;
        return this;
    }

    public UpdateEmbeddedObjectPositionResponse set(String str, Object obj) {
        return (UpdateEmbeddedObjectPositionResponse) super.set(str, obj);
    }

    public UpdateEmbeddedObjectPositionResponse clone() {
        return (UpdateEmbeddedObjectPositionResponse) super.clone();
    }
}
