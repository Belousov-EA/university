package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class EmbeddedObjectPosition extends GenericJson {
    @Key
    private Boolean newSheet;
    @Key
    private OverlayPosition overlayPosition;
    @Key
    private Integer sheetId;

    public Boolean getNewSheet() {
        return this.newSheet;
    }

    public EmbeddedObjectPosition setNewSheet(Boolean bool) {
        this.newSheet = bool;
        return this;
    }

    public OverlayPosition getOverlayPosition() {
        return this.overlayPosition;
    }

    public EmbeddedObjectPosition setOverlayPosition(OverlayPosition overlayPosition) {
        this.overlayPosition = overlayPosition;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public EmbeddedObjectPosition setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public EmbeddedObjectPosition set(String str, Object obj) {
        return (EmbeddedObjectPosition) super.set(str, obj);
    }

    public EmbeddedObjectPosition clone() {
        return (EmbeddedObjectPosition) super.clone();
    }
}
