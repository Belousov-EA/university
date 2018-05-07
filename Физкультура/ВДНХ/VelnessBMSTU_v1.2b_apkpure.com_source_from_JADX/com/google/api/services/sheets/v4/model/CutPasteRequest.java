package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CutPasteRequest extends GenericJson {
    @Key
    private GridCoordinate destination;
    @Key
    private String pasteType;
    @Key
    private GridRange source;

    public GridCoordinate getDestination() {
        return this.destination;
    }

    public CutPasteRequest setDestination(GridCoordinate gridCoordinate) {
        this.destination = gridCoordinate;
        return this;
    }

    public String getPasteType() {
        return this.pasteType;
    }

    public CutPasteRequest setPasteType(String str) {
        this.pasteType = str;
        return this;
    }

    public GridRange getSource() {
        return this.source;
    }

    public CutPasteRequest setSource(GridRange gridRange) {
        this.source = gridRange;
        return this;
    }

    public CutPasteRequest set(String str, Object obj) {
        return (CutPasteRequest) super.set(str, obj);
    }

    public CutPasteRequest clone() {
        return (CutPasteRequest) super.clone();
    }
}
