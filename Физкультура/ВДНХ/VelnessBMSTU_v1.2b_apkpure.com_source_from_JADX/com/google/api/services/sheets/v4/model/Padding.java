package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Padding extends GenericJson {
    @Key
    private Integer bottom;
    @Key
    private Integer left;
    @Key
    private Integer right;
    @Key
    private Integer top;

    public Integer getBottom() {
        return this.bottom;
    }

    public Padding setBottom(Integer num) {
        this.bottom = num;
        return this;
    }

    public Integer getLeft() {
        return this.left;
    }

    public Padding setLeft(Integer num) {
        this.left = num;
        return this;
    }

    public Integer getRight() {
        return this.right;
    }

    public Padding setRight(Integer num) {
        this.right = num;
        return this;
    }

    public Integer getTop() {
        return this.top;
    }

    public Padding setTop(Integer num) {
        this.top = num;
        return this;
    }

    public Padding set(String str, Object obj) {
        return (Padding) super.set(str, obj);
    }

    public Padding clone() {
        return (Padding) super.clone();
    }
}
