package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class RowData extends GenericJson {
    @Key
    private List<CellData> values;

    static {
        Data.nullOf(CellData.class);
    }

    public List<CellData> getValues() {
        return this.values;
    }

    public RowData setValues(List<CellData> list) {
        this.values = list;
        return this;
    }

    public RowData set(String str, Object obj) {
        return (RowData) super.set(str, obj);
    }

    public RowData clone() {
        return (RowData) super.clone();
    }
}
