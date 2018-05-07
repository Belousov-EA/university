package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class GridData extends GenericJson {
    @Key
    private List<DimensionProperties> columnMetadata;
    @Key
    private List<RowData> rowData;
    @Key
    private List<DimensionProperties> rowMetadata;
    @Key
    private Integer startColumn;
    @Key
    private Integer startRow;

    static {
        Data.nullOf(DimensionProperties.class);
        Data.nullOf(RowData.class);
        Data.nullOf(DimensionProperties.class);
    }

    public List<DimensionProperties> getColumnMetadata() {
        return this.columnMetadata;
    }

    public GridData setColumnMetadata(List<DimensionProperties> list) {
        this.columnMetadata = list;
        return this;
    }

    public List<RowData> getRowData() {
        return this.rowData;
    }

    public GridData setRowData(List<RowData> list) {
        this.rowData = list;
        return this;
    }

    public List<DimensionProperties> getRowMetadata() {
        return this.rowMetadata;
    }

    public GridData setRowMetadata(List<DimensionProperties> list) {
        this.rowMetadata = list;
        return this;
    }

    public Integer getStartColumn() {
        return this.startColumn;
    }

    public GridData setStartColumn(Integer num) {
        this.startColumn = num;
        return this;
    }

    public Integer getStartRow() {
        return this.startRow;
    }

    public GridData setStartRow(Integer num) {
        this.startRow = num;
        return this;
    }

    public GridData set(String str, Object obj) {
        return (GridData) super.set(str, obj);
    }

    public GridData clone() {
        return (GridData) super.clone();
    }
}
