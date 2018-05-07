package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Border extends GenericJson {
    @Key
    private Color color;
    @Key
    private String style;
    @Key
    private Integer width;

    public Color getColor() {
        return this.color;
    }

    public Border setColor(Color color) {
        this.color = color;
        return this;
    }

    public String getStyle() {
        return this.style;
    }

    public Border setStyle(String str) {
        this.style = str;
        return this;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Border setWidth(Integer num) {
        this.width = num;
        return this;
    }

    public Border set(String str, Object obj) {
        return (Border) super.set(str, obj);
    }

    public Border clone() {
        return (Border) super.clone();
    }
}
