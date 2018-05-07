package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class InterpolationPoint extends GenericJson {
    @Key
    private Color color;
    @Key
    private String type;
    @Key
    private String value;

    public Color getColor() {
        return this.color;
    }

    public InterpolationPoint setColor(Color color) {
        this.color = color;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public InterpolationPoint setType(String str) {
        this.type = str;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public InterpolationPoint setValue(String str) {
        this.value = str;
        return this;
    }

    public InterpolationPoint set(String str, Object obj) {
        return (InterpolationPoint) super.set(str, obj);
    }

    public InterpolationPoint clone() {
        return (InterpolationPoint) super.clone();
    }
}
