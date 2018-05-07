package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PasteDataRequest extends GenericJson {
    @Key
    private GridCoordinate coordinate;
    @Key
    private String data;
    @Key
    private String delimiter;
    @Key
    private Boolean html;
    @Key
    private String type;

    public GridCoordinate getCoordinate() {
        return this.coordinate;
    }

    public PasteDataRequest setCoordinate(GridCoordinate gridCoordinate) {
        this.coordinate = gridCoordinate;
        return this;
    }

    public String getData() {
        return this.data;
    }

    public PasteDataRequest setData(String str) {
        this.data = str;
        return this;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public PasteDataRequest setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public Boolean getHtml() {
        return this.html;
    }

    public PasteDataRequest setHtml(Boolean bool) {
        this.html = bool;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public PasteDataRequest setType(String str) {
        this.type = str;
        return this;
    }

    public PasteDataRequest set(String str, Object obj) {
        return (PasteDataRequest) super.set(str, obj);
    }

    public PasteDataRequest clone() {
        return (PasteDataRequest) super.clone();
    }
}
