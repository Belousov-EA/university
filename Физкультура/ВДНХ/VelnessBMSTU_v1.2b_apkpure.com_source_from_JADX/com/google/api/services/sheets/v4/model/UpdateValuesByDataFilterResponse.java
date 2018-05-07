package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateValuesByDataFilterResponse extends GenericJson {
    @Key
    private DataFilter dataFilter;
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

    public DataFilter getDataFilter() {
        return this.dataFilter;
    }

    public UpdateValuesByDataFilterResponse setDataFilter(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
        return this;
    }

    public Integer getUpdatedCells() {
        return this.updatedCells;
    }

    public UpdateValuesByDataFilterResponse setUpdatedCells(Integer num) {
        this.updatedCells = num;
        return this;
    }

    public Integer getUpdatedColumns() {
        return this.updatedColumns;
    }

    public UpdateValuesByDataFilterResponse setUpdatedColumns(Integer num) {
        this.updatedColumns = num;
        return this;
    }

    public ValueRange getUpdatedData() {
        return this.updatedData;
    }

    public UpdateValuesByDataFilterResponse setUpdatedData(ValueRange valueRange) {
        this.updatedData = valueRange;
        return this;
    }

    public String getUpdatedRange() {
        return this.updatedRange;
    }

    public UpdateValuesByDataFilterResponse setUpdatedRange(String str) {
        this.updatedRange = str;
        return this;
    }

    public Integer getUpdatedRows() {
        return this.updatedRows;
    }

    public UpdateValuesByDataFilterResponse setUpdatedRows(Integer num) {
        this.updatedRows = num;
        return this;
    }

    public UpdateValuesByDataFilterResponse set(String str, Object obj) {
        return (UpdateValuesByDataFilterResponse) super.set(str, obj);
    }

    public UpdateValuesByDataFilterResponse clone() {
        return (UpdateValuesByDataFilterResponse) super.clone();
    }
}
