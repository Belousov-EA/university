package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class AppendCellsRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private List<RowData> rows;
    @Key
    private Integer sheetId;

    public String getFields() {
        return this.fields;
    }

    public AppendCellsRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public List<RowData> getRows() {
        return this.rows;
    }

    public AppendCellsRequest setRows(List<RowData> list) {
        this.rows = list;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public AppendCellsRequest setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public AppendCellsRequest set(String str, Object obj) {
        return (AppendCellsRequest) super.set(str, obj);
    }

    public AppendCellsRequest clone() {
        return (AppendCellsRequest) super.clone();
    }
}
