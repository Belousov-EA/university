package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AppendValuesResponse extends GenericJson {
    @Key
    private String spreadsheetId;
    @Key
    private String tableRange;
    @Key
    private UpdateValuesResponse updates;

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public AppendValuesResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public String getTableRange() {
        return this.tableRange;
    }

    public AppendValuesResponse setTableRange(String str) {
        this.tableRange = str;
        return this;
    }

    public UpdateValuesResponse getUpdates() {
        return this.updates;
    }

    public AppendValuesResponse setUpdates(UpdateValuesResponse updateValuesResponse) {
        this.updates = updateValuesResponse;
        return this;
    }

    public AppendValuesResponse set(String str, Object obj) {
        return (AppendValuesResponse) super.set(str, obj);
    }

    public AppendValuesResponse clone() {
        return (AppendValuesResponse) super.clone();
    }
}
