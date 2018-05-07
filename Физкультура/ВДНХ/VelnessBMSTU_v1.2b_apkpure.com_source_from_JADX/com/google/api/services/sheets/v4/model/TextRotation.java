package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class TextRotation extends GenericJson {
    @Key
    private Integer angle;
    @Key
    private Boolean vertical;

    public Integer getAngle() {
        return this.angle;
    }

    public TextRotation setAngle(Integer num) {
        this.angle = num;
        return this;
    }

    public Boolean getVertical() {
        return this.vertical;
    }

    public TextRotation setVertical(Boolean bool) {
        this.vertical = bool;
        return this;
    }

    public TextRotation set(String str, Object obj) {
        return (TextRotation) super.set(str, obj);
    }

    public TextRotation clone() {
        return (TextRotation) super.clone();
    }
}
