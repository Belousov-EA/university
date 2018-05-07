package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class GridCoordinate extends GenericJson {
    @Key
    private Integer columnIndex;
    @Key
    private Integer rowIndex;
    @Key
    private Integer sheetId;

    public Integer getColumnIndex() {
        return this.columnIndex;
    }

    public GridCoordinate setColumnIndex(Integer num) {
        this.columnIndex = num;
        return this;
    }

    public Integer getRowIndex() {
        return this.rowIndex;
    }

    public GridCoordinate setRowIndex(Integer num) {
        this.rowIndex = num;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public GridCoordinate setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public GridCoordinate set(String str, Object obj) {
        return (GridCoordinate) super.set(str, obj);
    }

    public GridCoordinate clone() {
        return (GridCoordinate) super.clone();
    }
}
