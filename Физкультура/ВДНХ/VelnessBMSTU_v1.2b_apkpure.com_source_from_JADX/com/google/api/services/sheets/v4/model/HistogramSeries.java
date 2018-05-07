package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class HistogramSeries extends GenericJson {
    @Key
    private Color barColor;
    @Key
    private ChartData data;

    public Color getBarColor() {
        return this.barColor;
    }

    public HistogramSeries setBarColor(Color color) {
        this.barColor = color;
        return this;
    }

    public ChartData getData() {
        return this.data;
    }

    public HistogramSeries setData(ChartData chartData) {
        this.data = chartData;
        return this;
    }

    public HistogramSeries set(String str, Object obj) {
        return (HistogramSeries) super.set(str, obj);
    }

    public HistogramSeries clone() {
        return (HistogramSeries) super.clone();
    }
}
