package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddChartRequest extends GenericJson {
    @Key
    private EmbeddedChart chart;

    public EmbeddedChart getChart() {
        return this.chart;
    }

    public AddChartRequest setChart(EmbeddedChart embeddedChart) {
        this.chart = embeddedChart;
        return this;
    }

    public AddChartRequest set(String str, Object obj) {
        return (AddChartRequest) super.set(str, obj);
    }

    public AddChartRequest clone() {
        return (AddChartRequest) super.clone();
    }
}
