package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateSpreadsheetResponse extends GenericJson {
    @Key
    private List<Response> replies;
    @Key
    private String spreadsheetId;
    @Key
    private Spreadsheet updatedSpreadsheet;

    public List<Response> getReplies() {
        return this.replies;
    }

    public BatchUpdateSpreadsheetResponse setReplies(List<Response> list) {
        this.replies = list;
        return this;
    }

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public BatchUpdateSpreadsheetResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public Spreadsheet getUpdatedSpreadsheet() {
        return this.updatedSpreadsheet;
    }

    public BatchUpdateSpreadsheetResponse setUpdatedSpreadsheet(Spreadsheet spreadsheet) {
        this.updatedSpreadsheet = spreadsheet;
        return this;
    }

    public BatchUpdateSpreadsheetResponse set(String str, Object obj) {
        return (BatchUpdateSpreadsheetResponse) super.set(str, obj);
    }

    public BatchUpdateSpreadsheetResponse clone() {
        return (BatchUpdateSpreadsheetResponse) super.clone();
    }
}
