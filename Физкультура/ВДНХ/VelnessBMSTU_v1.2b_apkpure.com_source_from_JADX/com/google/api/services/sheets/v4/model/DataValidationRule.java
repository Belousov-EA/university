package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DataValidationRule extends GenericJson {
    @Key
    private BooleanCondition condition;
    @Key
    private String inputMessage;
    @Key
    private Boolean showCustomUi;
    @Key
    private Boolean strict;

    public BooleanCondition getCondition() {
        return this.condition;
    }

    public DataValidationRule setCondition(BooleanCondition booleanCondition) {
        this.condition = booleanCondition;
        return this;
    }

    public String getInputMessage() {
        return this.inputMessage;
    }

    public DataValidationRule setInputMessage(String str) {
        this.inputMessage = str;
        return this;
    }

    public Boolean getShowCustomUi() {
        return this.showCustomUi;
    }

    public DataValidationRule setShowCustomUi(Boolean bool) {
        this.showCustomUi = bool;
        return this;
    }

    public Boolean getStrict() {
        return this.strict;
    }

    public DataValidationRule setStrict(Boolean bool) {
        this.strict = bool;
        return this;
    }

    public DataValidationRule set(String str, Object obj) {
        return (DataValidationRule) super.set(str, obj);
    }

    public DataValidationRule clone() {
        return (DataValidationRule) super.clone();
    }
}
