package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SetDataValidationRequest extends GenericJson {
    @Key
    private GridRange range;
    @Key
    private DataValidationRule rule;

    public GridRange getRange() {
        return this.range;
    }

    public SetDataValidationRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public DataValidationRule getRule() {
        return this.rule;
    }

    public SetDataValidationRequest setRule(DataValidationRule dataValidationRule) {
        this.rule = dataValidationRule;
        return this;
    }

    public SetDataValidationRequest set(String str, Object obj) {
        return (SetDataValidationRequest) super.set(str, obj);
    }

    public SetDataValidationRequest clone() {
        return (SetDataValidationRequest) super.clone();
    }
}
