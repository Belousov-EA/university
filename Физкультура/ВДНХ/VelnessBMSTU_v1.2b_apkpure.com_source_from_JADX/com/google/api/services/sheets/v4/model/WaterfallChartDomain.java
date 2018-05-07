package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class WaterfallChartDomain extends GenericJson {
    @Key
    private ChartData data;
    @Key
    private Boolean reversed;

    public ChartData getData() {
        return this.data;
    }

    public WaterfallChartDomain setData(ChartData chartData) {
        this.data = chartData;
        return this;
    }

    public Boolean getReversed() {
        return this.reversed;
    }

    public WaterfallChartDomain setReversed(Boolean bool) {
        this.reversed = bool;
        return this;
    }

    public WaterfallChartDomain set(String str, Object obj) {
        return (WaterfallChartDomain) super.set(str, obj);
    }

    public WaterfallChartDomain clone() {
        return (WaterfallChartDomain) super.clone();
    }
}
