package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateValuesResponse extends GenericJson {
    @Key
    private String spreadsheetId;
    @Key
    private Integer updatedCells;
    @Key
    private Integer updatedColumns;
    @Key
    private ValueRange updatedData;
    @Key
    private String updatedRange;
    @Key
    private Integer updatedRows;

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public UpdateValuesResponse setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public Integer getUpdatedCells() {
        return this.updatedCells;
    }

    public UpdateValuesResponse setUpdatedCells(Integer num) {
        this.updatedCells = num;
        return this;
    }

    public Integer getUpdatedColumns() {
        return this.updatedColumns;
    }

    public UpdateValuesResponse setUpdatedColumns(Integer num) {
        this.updatedColumns = num;
        return this;
    }

    public ValueRange getUpdatedData() {
        return this.updatedData;
    }

    public UpdateValuesResponse setUpdatedData(ValueRange valueRange) {
        this.updatedData = valueRange;
        return this;
    }

    public String getUpdatedRange() {
        return this.updatedRange;
    }

    public UpdateValuesResponse setUpdatedRange(String str) {
        this.updatedRange = str;
        return this;
    }

    public Integer getUpdatedRows() {
        return this.updatedRows;
    }

    public UpdateValuesResponse setUpdatedRows(Integer num) {
        this.updatedRows = num;
        return this;
    }

    public UpdateValuesResponse set(String str, Object obj) {
        return (UpdateValuesResponse) super.set(str, obj);
    }

    public UpdateValuesResponse clone() {
        return (UpdateValuesResponse) super.clone();
    }
}
