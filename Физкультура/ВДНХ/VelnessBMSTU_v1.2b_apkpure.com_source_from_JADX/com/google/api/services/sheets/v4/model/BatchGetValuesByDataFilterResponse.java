package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchGetValuesByDataFilterResponse extends GenericJson {
    @Key
    private String spreadsheetId;
    @Key
    private List<MatchedValueRange> valueRanges;

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public BatchGetValuesByDataFilterResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public List<MatchedValueRange> getValueRanges() {
        return this.valueRanges;
    }

    public BatchGetValuesByDataFilterResponse setValueRanges(List<MatchedValueRange> list) {
        this.valueRanges = list;
        return this;
    }

    public BatchGetValuesByDataFilterResponse set(String str, Object obj) {
        return (BatchGetValuesByDataFilterResponse) super.set(str, obj);
    }

    public BatchGetValuesByDataFilterResponse clone() {
        return (BatchGetValuesByDataFilterResponse) super.clone();
    }
}
