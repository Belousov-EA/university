package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddChartResponse extends GenericJson {
    @Key
    private EmbeddedChart chart;

    public EmbeddedChart getChart() {
        return this.chart;
    }

    public AddChartResponse setChart(EmbeddedChart embeddedChart) {
        this.chart = embeddedChart;
        return this;
    }

    public AddChartResponse set(String str, Object obj) {
        return (AddChartResponse) super.set(str, obj);
    }

    public AddChartResponse clone() {
        return (AddChartResponse) super.clone();
    }
}
