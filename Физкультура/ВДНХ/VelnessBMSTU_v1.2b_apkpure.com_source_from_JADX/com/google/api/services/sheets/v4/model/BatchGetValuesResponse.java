package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchGetValuesResponse extends GenericJson {
    @Key
    private String spreadsheetId;
    @Key
    private List<ValueRange> valueRanges;

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public BatchGetValuesResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public List<ValueRange> getValueRanges() {
        return this.valueRanges;
    }

    public BatchGetValuesResponse setValueRanges(List<ValueRange> list) {
        this.valueRanges = list;
        return this;
    }

    public BatchGetValuesResponse set(String str, Object obj) {
        return (BatchGetValuesResponse) super.set(str, obj);
    }

    public BatchGetValuesResponse clone() {
        return (BatchGetValuesResponse) super.clone();
    }
}
