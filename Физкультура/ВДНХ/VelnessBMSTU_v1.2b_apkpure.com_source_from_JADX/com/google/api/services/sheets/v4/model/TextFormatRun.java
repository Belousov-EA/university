package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class TextFormatRun extends GenericJson {
    @Key
    private TextFormat format;
    @Key
    private Integer startIndex;

    public TextFormat getFormat() {
        return this.format;
    }

    public TextFormatRun setFormat(TextFormat textFormat) {
        this.format = textFormat;
        return this;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public TextFormatRun setStartIndex(Integer num) {
        this.startIndex = num;
        return this;
    }

    public TextFormatRun set(String str, Object obj) {
        return (TextFormatRun) super.set(str, obj);
    }

    public TextFormatRun clone() {
        return (TextFormatRun) super.clone();
    }
}
