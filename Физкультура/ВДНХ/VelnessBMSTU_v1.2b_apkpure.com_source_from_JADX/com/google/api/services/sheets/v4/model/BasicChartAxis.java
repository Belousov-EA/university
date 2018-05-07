package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class BasicChartAxis extends GenericJson {
    @Key
    private TextFormat format;
    @Key
    private String position;
    @Key
    private String title;
    @Key
    private TextPosition titleTextPosition;

    public TextFormat getFormat() {
        return this.format;
    }

    public BasicChartAxis setFormat(TextFormat textFormat) {
        this.format = textFormat;
        return this;
    }

    public String getPosition() {
        return this.position;
    }

    public BasicChartAxis setPosition(String str) {
        this.position = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public BasicChartAxis setTitle(String str) {
        this.title = str;
        return this;
    }

    public TextPosition getTitleTextPosition() {
        return this.titleTextPosition;
    }

    public BasicChartAxis setTitleTextPosition(TextPosition textPosition) {
        this.titleTextPosition = textPosition;
        return this;
    }

    public BasicChartAxis set(String str, Object obj) {
        return (BasicChartAxis) super.set(str, obj);
    }

    public BasicChartAxis clone() {
        return (BasicChartAxis) super.clone();
    }
}
