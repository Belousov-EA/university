package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateValuesResponse extends GenericJson {
    @Key
    private List<UpdateValuesResponse> responses;
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

    public List<UpdateValuesResponse> getResponses() {
        return this.responses;
    }

    public BatchUpdateValuesResponse setResponses(List<UpdateValuesResponse> list) {
        this.responses = list;
        return this;
    }

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public BatchUpdateValuesResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public Integer getTotalUpdatedCells() {
        return this.totalUpdatedCells;
    }

    public BatchUpdateValuesResponse setTotalUpdatedCells(Integer num) {
        this.totalUpdatedCells = num;
        return this;
    }

    public Integer getTotalUpdatedColumns() {
        return this.totalUpdatedColumns;
    }

    public BatchUpdateValuesResponse setTotalUpdatedColumns(Integer num) {
        this.totalUpdatedColumns = num;
        return this;
    }

    public Integer getTotalUpdatedRows() {
        return this.totalUpdatedRows;
    }

    public BatchUpdateValuesResponse setTotalUpdatedRows(Integer num) {
        this.totalUpdatedRows = num;
        return this;
    }

    public Integer getTotalUpdatedSheets() {
        return this.totalUpdatedSheets;
    }

    public BatchUpdateValuesResponse setTotalUpdatedSheets(Integer num) {
        this.totalUpdatedSheets = num;
        return this;
    }

    public BatchUpdateValuesResponse set(String str, Object obj) {
        return (BatchUpdateValuesResponse) super.set(str, obj);
    }

    public BatchUpdateValuesResponse clone() {
        return (BatchUpdateValuesResponse) super.clone();
    }
}
