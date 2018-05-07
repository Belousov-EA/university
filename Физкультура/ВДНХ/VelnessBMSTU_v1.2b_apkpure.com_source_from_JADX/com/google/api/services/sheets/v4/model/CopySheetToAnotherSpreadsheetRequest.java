package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CopySheetToAnotherSpreadsheetRequest extends GenericJson {
    @Key
    private String destinationSpreadsheetId;

    public String getDestinationSpreadsheetId() {
        return this.destinationSpreadsheetId;
    }

    public CopySheetToAnotherSpreadsheetRequest setDestinationSpreadsheetId(String str) {
        this.destinationSpreadsheetId = str;
        return this;
    }

    public CopySheetToAnotherSpreadsheetRequest set(String str, Object obj) {
        return (CopySheetToAnotherSpreadsheetRequest) super.set(str, obj);
    }

    public CopySheetToAnotherSpreadsheetRequest clone() {
        return (CopySheetToAnotherSpreadsheetRequest) super.clone();
    }
}
