package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PivotValue extends GenericJson {
    @Key
    private String calculatedDisplayType;
    @Key
    private String formula;
    @Key
    private String name;
    @Key
    private Integer sourceColumnOffset;
    @Key
    private String summarizeFunction;

    public String getCalculatedDisplayType() {
        return this.calculatedDisplayType;
    }

    public PivotValue setCalculatedDisplayType(String str) {
        this.calculatedDisplayType = str;
        return this;
    }

    public String getFormula() {
        return this.formula;
    }

    public PivotValue setFormula(String str) {
        this.formula = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public PivotValue setName(String str) {
        this.name = str;
        return this;
    }

    public Integer getSourceColumnOffset() {
        return this.sourceColumnOffset;
    }

    public PivotValue setSourceColumnOffset(Integer num) {
        this.sourceColumnOffset = num;
        return this;
    }

    public String getSummarizeFunction() {
        return this.summarizeFunction;
    }

    public PivotValue setSummarizeFunction(String str) {
        this.summarizeFunction = str;
        return this;
    }

    public PivotValue set(String str, Object obj) {
        return (PivotValue) super.set(str, obj);
    }

    public PivotValue clone() {
        return (PivotValue) super.clone();
    }
}
