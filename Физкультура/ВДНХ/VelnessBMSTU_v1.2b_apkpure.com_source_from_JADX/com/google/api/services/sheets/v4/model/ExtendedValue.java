package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ExtendedValue extends GenericJson {
    @Key
    private Boolean boolValue;
    @Key
    private ErrorValue errorValue;
    @Key
    private String formulaValue;
    @Key
    private Double numberValue;
    @Key
    private String stringValue;

    public Boolean getBoolValue() {
        return this.boolValue;
    }

    public ExtendedValue setBoolValue(Boolean bool) {
        this.boolValue = bool;
        return this;
    }

    public ErrorValue getErrorValue() {
        return this.errorValue;
    }

    public ExtendedValue setErrorValue(ErrorValue errorValue) {
        this.errorValue = errorValue;
        return this;
    }

    public String getFormulaValue() {
        return this.formulaValue;
    }

    public ExtendedValue setFormulaValue(String str) {
        this.formulaValue = str;
        return this;
    }

    public Double getNumberValue() {
        return this.numberValue;
    }

    public ExtendedValue setNumberValue(Double d) {
        this.numberValue = d;
        return this;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public ExtendedValue setStringValue(String str) {
        this.stringValue = str;
        return this;
    }

    public ExtendedValue set(String str, Object obj) {
        return (ExtendedValue) super.set(str, obj);
    }

    public ExtendedValue clone() {
        return (ExtendedValue) super.clone();
    }
}
