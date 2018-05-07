package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class BasicChartSeries extends GenericJson {
    @Key
    private LineStyle lineStyle;
    @Key
    private ChartData series;
    @Key
    private String targetAxis;
    @Key
    private String type;

    public LineStyle getLineStyle() {
        return this.lineStyle;
    }

    public BasicChartSeries setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    public ChartData getSeries() {
        return this.series;
    }

    public BasicChartSeries setSeries(ChartData chartData) {
        this.series = chartData;
        return this;
    }

    public String getTargetAxis() {
        return this.targetAxis;
    }

    public BasicChartSeries setTargetAxis(String str) {
        this.targetAxis = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public BasicChartSeries setType(String str) {
        this.type = str;
        return this;
    }

    public BasicChartSeries set(String str, Object obj) {
        return (BasicChartSeries) super.set(str, obj);
    }

    public BasicChartSeries clone() {
        return (BasicChartSeries) super.clone();
    }
}
