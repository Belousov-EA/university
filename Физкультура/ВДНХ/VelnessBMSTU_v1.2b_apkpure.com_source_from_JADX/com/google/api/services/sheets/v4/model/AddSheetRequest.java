package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddSheetRequest extends GenericJson {
    @Key
    private SheetProperties properties;

    public SheetProperties getProperties() {
        return this.properties;
    }

    public AddSheetRequest setProperties(SheetProperties sheetProperties) {
        this.properties = sheetProperties;
        return this;
    }

    public AddSheetRequest set(String str, Object obj) {
        return (AddSheetRequest) super.set(str, obj);
    }

    public AddSheetRequest clone() {
        return (AddSheetRequest) super.clone();
    }
}
