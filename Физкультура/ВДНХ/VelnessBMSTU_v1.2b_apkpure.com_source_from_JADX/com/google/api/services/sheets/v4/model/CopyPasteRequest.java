package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CopyPasteRequest extends GenericJson {
    @Key
    private GridRange destination;
    @Key
    private String pasteOrientation;
    @Key
    private String pasteType;
    @Key
    private GridRange source;

    public GridRange getDestination() {
        return this.destination;
    }

    public CopyPasteRequest setDestination(GridRange gridRange) {
        this.destination = gridRange;
        return this;
    }

    public String getPasteOrientation() {
        return this.pasteOrientation;
    }

    public CopyPasteRequest setPasteOrientation(String str) {
        this.pasteOrientation = str;
        return this;
    }

    public String getPasteType() {
        return this.pasteType;
    }

    public CopyPasteRequest setPasteType(String str) {
        this.pasteType = str;
        return this;
    }

    public GridRange getSource() {
        return this.source;
    }

    public CopyPasteRequest setSource(GridRange gridRange) {
        this.source = gridRange;
        return this;
    }

    public CopyPasteRequest set(String str, Object obj) {
        return (CopyPasteRequest) super.set(str, obj);
    }

    public CopyPasteRequest clone() {
        return (CopyPasteRequest) super.clone();
    }
}
