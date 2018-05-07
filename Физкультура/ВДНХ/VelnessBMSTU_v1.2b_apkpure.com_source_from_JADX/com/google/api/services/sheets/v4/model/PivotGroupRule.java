package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PivotGroupRule extends GenericJson {
    @Key
    private HistogramRule histogramRule;
    @Key
    private ManualRule manualRule;

    public HistogramRule getHistogramRule() {
        return this.histogramRule;
    }

    public PivotGroupRule setHistogramRule(HistogramRule histogramRule) {
        this.histogramRule = histogramRule;
        return this;
    }

    public ManualRule getManualRule() {
        return this.manualRule;
    }

    public PivotGroupRule setManualRule(ManualRule manualRule) {
        this.manualRule = manualRule;
        return this;
    }

    public PivotGroupRule set(String str, Object obj) {
        return (PivotGroupRule) super.set(str, obj);
    }

    public PivotGroupRule clone() {
        return (PivotGroupRule) super.clone();
    }
}
