package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateValuesByDataFilterResponse extends GenericJson {
    @Key
    private List<UpdateValuesByDataFilterResponse> responses;
    @Key
    private String spreadsheetId;
    @Key
    private Integer totalUpdatedCells;
    @Key
    private Integer totalUpdatedColumns;
    @Key
    private Integer totalUpdatedRows;
    @Key
    private Integer totalUpdatedSheets;

    static {
        Data.nullOf(UpdateValuesByDataFilterResponse.class);
    }

    public List<UpdateValuesByDataFilterResponse> getResponses() {
        return this.responses;
    }

    public BatchUpdateValuesByDataFilterResponse setResponses(List<UpdateValuesByDataFilterResponse> list) {
        this.responses = list;
        return this;
    }

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public BatchUpdateValuesByDataFilterResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public Integer getTotalUpdatedCells() {
        return this.totalUpdatedCells;
    }

    public BatchUpdateValuesByDataFilterResponse setTotalUpdatedCells(Integer num) {
        this.totalUpdatedCells = num;
        return this;
    }

    public Integer getTotalUpdatedColumns() {
        return this.totalUpdatedColumns;
    }

    public BatchUpdateValuesByDataFilterResponse setTotalUpdatedColumns(Integer num) {
        this.totalUpdatedColumns = num;
        return this;
    }

    public Integer getTotalUpdatedRows() {
        return this.totalUpdatedRows;
    }

    public BatchUpdateValuesByDataFilterResponse setTotalUpdatedRows(Integer num) {
        this.totalUpdatedRows = num;
        return this;
    }

    public Integer getTotalUpdatedSheets() {
        return this.totalUpdatedSheets;
    }

    public BatchUpdateValuesByDataFilterResponse setTotalUpdatedSheets(Integer num) {
        this.totalUpdatedSheets = num;
        return this;
    }

    public BatchUpdateValuesByDataFilterResponse set(String str, Object obj) {
        return (BatchUpdateValuesByDataFilterResponse) super.set(str, obj);
    }

    public BatchUpdateValuesByDataFilterResponse clone() {
        return (BatchUpdateValuesByDataFilterResponse) super.clone();
    }
}
