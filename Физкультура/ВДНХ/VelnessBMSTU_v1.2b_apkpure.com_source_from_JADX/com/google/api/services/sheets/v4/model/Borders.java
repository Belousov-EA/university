package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Borders extends GenericJson {
    @Key
    private Border bottom;
    @Key
    private Border left;
    @Key
    private Border right;
    @Key
    private Border top;

    public Border getBottom() {
        return this.bottom;
    }

    public Borders setBottom(Border border) {
        this.bottom = border;
        return this;
    }

    public Border getLeft() {
        return this.left;
    }

    public Borders setLeft(Border border) {
        this.left = border;
        return this;
    }

    public Border getRight() {
        return this.right;
    }

    public Borders setRight(Border border) {
        this.right = border;
        return this;
    }

    public Border getTop() {
        return this.top;
    }

    public Borders setTop(Border border) {
        this.top = border;
        return this;
    }

    public Borders set(String str, Object obj) {
        return (Borders) super.set(str, obj);
    }

    public Borders clone() {
        return (Borders) super.clone();
    }
}
