package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PieChartSpec extends GenericJson {
    @Key
    private ChartData domain;
    @Key
    private String legendPosition;
    @Key
    private Double pieHole;
    @Key
    private ChartData series;
    @Key
    private Boolean threeDimensional;

    public ChartData getDomain() {
        return this.domain;
    }

    public PieChartSpec setDomain(ChartData chartData) {
        this.domain = chartData;
        return this;
    }

    public String getLegendPosition() {
        return this.legendPosition;
    }

    public PieChartSpec setLegendPosition(String str) {
        this.legendPosition = str;
        return this;
    }

    public Double getPieHole() {
        return this.pieHole;
    }

    public PieChartSpec setPieHole(Double d) {
        this.pieHole = d;
        return this;
    }

    public ChartData getSeries() {
        return this.series;
    }

    public PieChartSpec setSeries(ChartData chartData) {
        this.series = chartData;
        return this;
    }

    public Boolean getThreeDimensional() {
        return this.threeDimensional;
    }

    public PieChartSpec setThreeDimensional(Boolean bool) {
        this.threeDimensional = bool;
        return this;
    }

    public PieChartSpec set(String str, Object obj) {
        return (PieChartSpec) super.set(str, obj);
    }

    public PieChartSpec clone() {
        return (PieChartSpec) super.clone();
    }
}
