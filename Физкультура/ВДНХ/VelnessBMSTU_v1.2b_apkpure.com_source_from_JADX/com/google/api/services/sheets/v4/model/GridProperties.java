package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class GridProperties extends GenericJson {
    @Key
    private Integer columnCount;
    @Key
    private Integer frozenColumnCount;
    @Key
    private Integer frozenRowCount;
    @Key
    private Boolean hideGridlines;
    @Key
    private Integer rowCount;

    public Integer getColumnCount() {
        return this.columnCount;
    }

    public GridProperties setColumnCount(Integer num) {
        this.columnCount = num;
        return this;
    }

    public Integer getFrozenColumnCount() {
        return this.frozenColumnCount;
    }

    public GridProperties setFrozenColumnCount(Integer num) {
        this.frozenColumnCount = num;
        return this;
    }

    public Integer getFrozenRowCount() {
        return this.frozenRowCount;
    }

    public GridProperties setFrozenRowCount(Integer num) {
        this.frozenRowCount = num;
        return this;
    }

    public Boolean getHideGridlines() {
        return this.hideGridlines;
    }

    public GridProperties setHideGridlines(Boolean bool) {
        this.hideGridlines = bool;
        return this;
    }

    public Integer getRowCount() {
        return this.rowCount;
    }

    public GridProperties setRowCount(Integer num) {
        this.rowCount = num;
        return this;
    }

    public GridProperties set(String str, Object obj) {
        return (GridProperties) super.set(str, obj);
    }

    public GridProperties clone() {
        return (GridProperties) super.clone();
    }
}
