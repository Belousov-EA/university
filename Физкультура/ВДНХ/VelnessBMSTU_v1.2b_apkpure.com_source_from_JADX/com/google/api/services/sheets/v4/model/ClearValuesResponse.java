package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ClearValuesResponse extends GenericJson {
    @Key
    private String clearedRange;
    @Key
    private String spreadsheetId;

    public String getClearedRange() {
        return this.clearedRange;
    }

    public ClearValuesResponse setClearedRange(String str) {
        this.clearedRange = str;
        return this;
    }

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public ClearValuesResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public ClearValuesResponse set(String str, Object obj) {
        return (ClearValuesResponse) super.set(str, obj);
    }

    public ClearValuesResponse clone() {
        return (ClearValuesResponse) super.clone();
    }
}
