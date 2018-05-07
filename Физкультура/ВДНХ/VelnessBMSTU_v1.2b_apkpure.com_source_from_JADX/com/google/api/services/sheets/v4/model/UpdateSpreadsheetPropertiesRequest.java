package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateSpreadsheetPropertiesRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private SpreadsheetProperties properties;

    public String getFields() {
        return this.fields;
    }

    public UpdateSpreadsheetPropertiesRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public SpreadsheetProperties getProperties() {
        return this.properties;
    }

    public UpdateSpreadsheetPropertiesRequest setProperties(SpreadsheetProperties spreadsheetProperties) {
        this.properties = spreadsheetProperties;
        return this;
    }

    public UpdateSpreadsheetPropertiesRequest set(String str, Object obj) {
        return (UpdateSpreadsheetPropertiesRequest) super.set(str, obj);
    }

    public UpdateSpreadsheetPropertiesRequest clone() {
        return (UpdateSpreadsheetPropertiesRequest) super.clone();
    }
}
