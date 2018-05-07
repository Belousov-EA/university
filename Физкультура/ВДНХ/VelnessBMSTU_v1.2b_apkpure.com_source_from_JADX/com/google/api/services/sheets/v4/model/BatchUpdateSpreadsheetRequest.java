package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateSpreadsheetRequest extends GenericJson {
    @Key
    private Boolean includeSpreadsheetInResponse;
    @Key
    private List<Request> requests;
    @Key
    private Boolean responseIncludeGridData;
    @Key
    private List<String> responseRanges;

    static {
        Data.nullOf(Request.class);
    }

    public Boolean getIncludeSpreadsheetInResponse() {
        return this.includeSpreadsheetInResponse;
    }

    public BatchUpdateSpreadsheetRequest setIncludeSpreadsheetInResponse(Boolean bool) {
        this.includeSpreadsheetInResponse = bool;
        return this;
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public BatchUpdateSpreadsheetRequest setRequests(List<Request> list) {
        this.requests = list;
        return this;
    }

    public Boolean getResponseIncludeGridData() {
        return this.responseIncludeGridData;
    }

    public BatchUpdateSpreadsheetRequest setResponseIncludeGridData(Boolean bool) {
        this.responseIncludeGridData = bool;
        return this;
    }

    public List<String> getResponseRanges() {
        return this.responseRanges;
    }

    public BatchUpdateSpreadsheetRequest setResponseRanges(List<String> list) {
        this.responseRanges = list;
        return this;
    }

    public BatchUpdateSpreadsheetRequest set(String str, Object obj) {
        return (BatchUpdateSpreadsheetRequest) super.set(str, obj);
    }

    public BatchUpdateSpreadsheetRequest clone() {
        return (BatchUpdateSpreadsheetRequest) super.clone();
    }
}
