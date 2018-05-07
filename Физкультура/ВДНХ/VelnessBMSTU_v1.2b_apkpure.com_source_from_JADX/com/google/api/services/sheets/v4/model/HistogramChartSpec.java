package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class HistogramChartSpec extends GenericJson {
    @Key
    private Double bucketSize;
    @Key
    private String legendPosition;
    @Key
    private Double outlierPercentile;
    @Key
    private List<HistogramSeries> series;
    @Key
    private Boolean showItemDividers;

    public Double getBucketSize() {
        return this.bucketSize;
    }

    public HistogramChartSpec setBucketSize(Double d) {
        this.bucketSize = d;
        return this;
    }

    public String getLegendPosition() {
        return this.legendPosition;
    }

    public HistogramChartSpec setLegendPosition(String str) {
        this.legendPosition = str;
        return this;
    }

    public Double getOutlierPercentile() {
        return this.outlierPercentile;
    }

    public HistogramChartSpec setOutlierPercentile(Double d) {
        this.outlierPercentile = d;
        return this;
    }

    public List<HistogramSeries> getSeries() {
        return this.series;
    }

    public HistogramChartSpec setSeries(List<HistogramSeries> list) {
        this.series = list;
        return this;
    }

    public Boolean getShowItemDividers() {
        return this.showItemDividers;
    }

    public HistogramChartSpec setShowItemDividers(Boolean bool) {
        this.showItemDividers = bool;
        return this;
    }

    public HistogramChartSpec set(String str, Object obj) {
        return (HistogramChartSpec) super.set(str, obj);
    }

    public HistogramChartSpec clone() {
        return (HistogramChartSpec) super.clone();
    }
}
