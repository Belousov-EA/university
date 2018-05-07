package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class WaterfallChartSeries extends GenericJson {
    @Key
    private List<WaterfallChartCustomSubtotal> customSubtotals;
    @Key
    private ChartData data;
    @Key
    private Boolean hideTrailingSubtotal;
    @Key
    private WaterfallChartColumnStyle negativeColumnsStyle;
    @Key
    private WaterfallChartColumnStyle positiveColumnsStyle;
    @Key
    private WaterfallChartColumnStyle subtotalColumnsStyle;

    public List<WaterfallChartCustomSubtotal> getCustomSubtotals() {
        return this.customSubtotals;
    }

    public WaterfallChartSeries setCustomSubtotals(List<WaterfallChartCustomSubtotal> list) {
        this.customSubtotals = list;
        return this;
    }

    public ChartData getData() {
        return this.data;
    }

    public WaterfallChartSeries setData(ChartData chartData) {
        this.data = chartData;
        return this;
    }

    public Boolean getHideTrailingSubtotal() {
        return this.hideTrailingSubtotal;
    }

    public WaterfallChartSeries setHideTrailingSubtotal(Boolean bool) {
        this.hideTrailingSubtotal = bool;
        return this;
    }

    public WaterfallChartColumnStyle getNegativeColumnsStyle() {
        return this.negativeColumnsStyle;
    }

    public WaterfallChartSeries setNegativeColumnsStyle(WaterfallChartColumnStyle waterfallChartColumnStyle) {
        this.negativeColumnsStyle = waterfallChartColumnStyle;
        return this;
    }

    public WaterfallChartColumnStyle getPositiveColumnsStyle() {
        return this.positiveColumnsStyle;
    }

    public WaterfallChartSeries setPositiveColumnsStyle(WaterfallChartColumnStyle waterfallChartColumnStyle) {
        this.positiveColumnsStyle = waterfallChartColumnStyle;
        return this;
    }

    public WaterfallChartColumnStyle getSubtotalColumnsStyle() {
        return this.subtotalColumnsStyle;
    }

    public WaterfallChartSeries setSubtotalColumnsStyle(WaterfallChartColumnStyle waterfallChartColumnStyle) {
        this.subtotalColumnsStyle = waterfallChartColumnStyle;
        return this;
    }

    public WaterfallChartSeries set(String str, Object obj) {
        return (WaterfallChartSeries) super.set(str, obj);
    }

    public WaterfallChartSeries clone() {
        return (WaterfallChartSeries) super.clone();
    }
}
