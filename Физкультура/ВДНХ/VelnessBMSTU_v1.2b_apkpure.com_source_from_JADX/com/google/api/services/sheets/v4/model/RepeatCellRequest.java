package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class RepeatCellRequest extends GenericJson {
    @Key
    private CellData cell;
    @Key
    private String fields;
    @Key
    private GridRange range;

    public CellData getCell() {
        return this.cell;
    }

    public RepeatCellRequest setCell(CellData cellData) {
        this.cell = cellData;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public RepeatCellRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public RepeatCellRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public RepeatCellRequest set(String str, Object obj) {
        return (RepeatCellRequest) super.set(str, obj);
    }

    public RepeatCellRequest clone() {
        return (RepeatCellRequest) super.clone();
    }
}
