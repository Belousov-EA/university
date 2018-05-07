package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddSheetResponse extends GenericJson {
    @Key
    private SheetProperties properties;

    public SheetProperties getProperties() {
        return this.properties;
    }

    public AddSheetResponse setProperties(SheetProperties sheetProperties) {
        this.properties = sheetProperties;
        return this;
    }

    public AddSheetResponse set(String str, Object obj) {
        return (AddSheetResponse) super.set(str, obj);
    }

    public AddSheetResponse clone() {
        return (AddSheetResponse) super.clone();
    }
}
