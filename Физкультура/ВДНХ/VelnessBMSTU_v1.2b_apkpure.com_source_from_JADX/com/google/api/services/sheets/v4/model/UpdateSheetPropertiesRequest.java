package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateSheetPropertiesRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private SheetProperties properties;

    public String getFields() {
        return this.fields;
    }

    public UpdateSheetPropertiesRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public SheetProperties getProperties() {
        return this.properties;
    }

    public UpdateSheetPropertiesRequest setProperties(SheetProperties sheetProperties) {
        this.properties = sheetProperties;
        return this;
    }

    public UpdateSheetPropertiesRequest set(String str, Object obj) {
        return (UpdateSheetPropertiesRequest) super.set(str, obj);
    }

    public UpdateSheetPropertiesRequest clone() {
        return (UpdateSheetPropertiesRequest) super.clone();
    }
}
