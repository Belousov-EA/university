package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchClearValuesResponse extends GenericJson {
    @Key
    private List<String> clearedRanges;
    @Key
    private String spreadsheetId;

    public List<String> getClearedRanges() {
        return this.clearedRanges;
    }

    public BatchClearValuesResponse setClearedRanges(List<String> list) {
        this.clearedRanges = list;
        return this;
    }

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public BatchClearValuesResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public BatchClearValuesResponse set(String str, Object obj) {
        return (BatchClearValuesResponse) super.set(str, obj);
    }

    public BatchClearValuesResponse clone() {
        return (BatchClearValuesResponse) super.clone();
    }
}
