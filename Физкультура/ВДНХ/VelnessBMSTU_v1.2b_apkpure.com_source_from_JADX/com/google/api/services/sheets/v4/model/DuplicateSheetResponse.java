package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DuplicateSheetResponse extends GenericJson {
    @Key
    private SheetProperties properties;

    public SheetProperties getProperties() {
        return this.properties;
    }

    public DuplicateSheetResponse setProperties(SheetProperties sheetProperties) {
        this.properties = sheetProperties;
        return this;
    }

    public DuplicateSheetResponse set(String str, Object obj) {
        return (DuplicateSheetResponse) super.set(str, obj);
    }

    public DuplicateSheetResponse clone() {
        return (DuplicateSheetResponse) super.clone();
    }
}
