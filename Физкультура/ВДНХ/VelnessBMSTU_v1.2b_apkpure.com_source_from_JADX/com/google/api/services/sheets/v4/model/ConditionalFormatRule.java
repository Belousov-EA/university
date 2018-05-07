package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class ConditionalFormatRule extends GenericJson {
    @Key
    private BooleanRule booleanRule;
    @Key
    private GradientRule gradientRule;
    @Key
    private List<GridRange> ranges;

    public BooleanRule getBooleanRule() {
        return this.booleanRule;
    }

    public ConditionalFormatRule setBooleanRule(BooleanRule booleanRule) {
        this.booleanRule = booleanRule;
        return this;
    }

    public GradientRule getGradientRule() {
        return this.gradientRule;
    }

    public ConditionalFormatRule setGradientRule(GradientRule gradientRule) {
        this.gradientRule = gradientRule;
        return this;
    }

    public List<GridRange> getRanges() {
        return this.ranges;
    }

    public ConditionalFormatRule setRanges(List<GridRange> list) {
        this.ranges = list;
        return this;
    }

    public ConditionalFormatRule set(String str, Object obj) {
        return (ConditionalFormatRule) super.set(str, obj);
    }

    public ConditionalFormatRule clone() {
        return (ConditionalFormatRule) super.clone();
    }
}
