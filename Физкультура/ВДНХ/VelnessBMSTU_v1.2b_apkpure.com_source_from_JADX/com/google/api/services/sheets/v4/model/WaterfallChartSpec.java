package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class WaterfallChartSpec extends GenericJson {
    @Key
    private LineStyle connectorLineStyle;
    @Key
    private WaterfallChartDomain domain;
    @Key
    private Boolean firstValueIsTotal;
    @Key
    private Boolean hideConnectorLines;
    @Key
    private List<WaterfallChartSeries> series;
    @Key
    private String stackedType;

    public LineStyle getConnectorLineStyle() {
        return this.connectorLineStyle;
    }

    public WaterfallChartSpec setConnectorLineStyle(LineStyle lineStyle) {
        this.connectorLineStyle = lineStyle;
        return this;
    }

    public WaterfallChartDomain getDomain() {
        return this.domain;
    }

    public WaterfallChartSpec setDomain(WaterfallChartDomain waterfallChartDomain) {
        this.domain = waterfallChartDomain;
        return this;
    }

    public Boolean getFirstValueIsTotal() {
        return this.firstValueIsTotal;
    }

    public WaterfallChartSpec setFirstValueIsTotal(Boolean bool) {
        this.firstValueIsTotal = bool;
        return this;
    }

    public Boolean getHideConnectorLines() {
        return this.hideConnectorLines;
    }

    public WaterfallChartSpec setHideConnectorLines(Boolean bool) {
        this.hideConnectorLines = bool;
        return this;
    }

    public List<WaterfallChartSeries> getSeries() {
        return this.series;
    }

    public WaterfallChartSpec setSeries(List<WaterfallChartSeries> list) {
        this.series = list;
        return this;
    }

    public String getStackedType() {
        return this.stackedType;
    }

    public WaterfallChartSpec setStackedType(String str) {
        this.stackedType = str;
        return this;
    }

    public WaterfallChartSpec set(String str, Object obj) {
        return (WaterfallChartSpec) super.set(str, obj);
    }

    public WaterfallChartSpec clone() {
        return (WaterfallChartSpec) super.clone();
    }
}
