package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchClearValuesByDataFilterResponse extends GenericJson {
    @Key
    private List<String> clearedRanges;
    @Key
    private String spreadsheetId;

    public List<String> getClearedRanges() {
        return this.clearedRanges;
    }

    public BatchClearValuesByDataFilterResponse setClearedRanges(List<String> list) {
        this.clearedRanges = list;
        return this;
    }

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public BatchClearValuesByDataFilterResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public BatchClearValuesByDataFilterResponse set(String str, Object obj) {
        return (BatchClearValuesByDataFilterResponse) super.set(str, obj);
    }

    public BatchClearValuesByDataFilterResponse clone() {
        return (BatchClearValuesByDataFilterResponse) super.clone();
    }
}
