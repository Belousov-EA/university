package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class UpdateCellsRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private GridRange range;
    @Key
    private List<RowData> rows;
    @Key
    private GridCoordinate start;

    public String getFields() {
        return this.fields;
    }

    public UpdateCellsRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public UpdateCellsRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public List<RowData> getRows() {
        return this.rows;
    }

    public UpdateCellsRequest setRows(List<RowData> list) {
        this.rows = list;
        return this;
    }

    public GridCoordinate getStart() {
        return this.start;
    }

    public UpdateCellsRequest setStart(GridCoordinate gridCoordinate) {
        this.start = gridCoordinate;
        return this;
    }

    public UpdateCellsRequest set(String str, Object obj) {
        return (UpdateCellsRequest) super.set(str, obj);
    }

    public UpdateCellsRequest clone() {
        return (UpdateCellsRequest) super.clone();
    }
}
