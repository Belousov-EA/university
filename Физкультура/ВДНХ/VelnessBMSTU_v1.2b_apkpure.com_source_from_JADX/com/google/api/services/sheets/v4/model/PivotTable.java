package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

public final class PivotTable extends GenericJson {
    @Key
    private List<PivotGroup> columns;
    @Key
    private Map<String, PivotFilterCriteria> criteria;
    @Key
    private List<PivotGroup> rows;
    @Key
    private GridRange source;
    @Key
    private String valueLayout;
    @Key
    private List<PivotValue> values;

    static {
        Data.nullOf(PivotGroup.class);
        Data.nullOf(PivotFilterCriteria.class);
        Data.nullOf(PivotGroup.class);
        Data.nullOf(PivotValue.class);
    }

    public List<PivotGroup> getColumns() {
        return this.columns;
    }

    public PivotTable setColumns(List<PivotGroup> list) {
        this.columns = list;
        return this;
    }

    public Map<String, PivotFilterCriteria> getCriteria() {
        return this.criteria;
    }

    public PivotTable setCriteria(Map<String, PivotFilterCriteria> map) {
        this.criteria = map;
        return this;
    }

    public List<PivotGroup> getRows() {
        return this.rows;
    }

    public PivotTable setRows(List<PivotGroup> list) {
        this.rows = list;
        return this;
    }

    public GridRange getSource() {
        return this.source;
    }

    public PivotTable setSource(GridRange gridRange) {
        this.source = gridRange;
        return this;
    }

    public String getValueLayout() {
        return this.valueLayout;
    }

    public PivotTable setValueLayout(String str) {
        this.valueLayout = str;
        return this;
    }

    public List<PivotValue> getValues() {
        return this.values;
    }

    public PivotTable setValues(List<PivotValue> list) {
        this.values = list;
        return this;
    }

    public PivotTable set(String str, Object obj) {
        return (PivotTable) super.set(str, obj);
    }

    public PivotTable clone() {
        return (PivotTable) super.clone();
    }
}
