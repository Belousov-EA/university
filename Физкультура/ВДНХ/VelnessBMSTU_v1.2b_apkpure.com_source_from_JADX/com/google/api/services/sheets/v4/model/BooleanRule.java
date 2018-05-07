package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class BooleanRule extends GenericJson {
    @Key
    private BooleanCondition condition;
    @Key
    private CellFormat format;

    public BooleanCondition getCondition() {
        return this.condition;
    }

    public BooleanRule setCondition(BooleanCondition booleanCondition) {
        this.condition = booleanCondition;
        return this;
    }

    public CellFormat getFormat() {
        return this.format;
    }

    public BooleanRule setFormat(CellFormat cellFormat) {
        this.format = cellFormat;
        return this;
    }

    public BooleanRule set(String str, Object obj) {
        return (BooleanRule) super.set(str, obj);
    }

    public BooleanRule clone() {
        return (BooleanRule) super.clone();
    }
}
