package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class BubbleChartSpec extends GenericJson {
    @Key
    private Color bubbleBorderColor;
    @Key
    private ChartData bubbleLabels;
    @Key
    private Integer bubbleMaxRadiusSize;
    @Key
    private Integer bubbleMinRadiusSize;
    @Key
    private Float bubbleOpacity;
    @Key
    private ChartData bubbleSizes;
    @Key
    private TextFormat bubbleTextStyle;
    @Key
    private ChartData domain;
    @Key
    private ChartData groupIds;
    @Key
    private String legendPosition;
    @Key
    private ChartData series;

    public Color getBubbleBorderColor() {
        return this.bubbleBorderColor;
    }

    public BubbleChartSpec setBubbleBorderColor(Color color) {
        this.bubbleBorderColor = color;
        return this;
    }

    public ChartData getBubbleLabels() {
        return this.bubbleLabels;
    }

    public BubbleChartSpec setBubbleLabels(ChartData chartData) {
        this.bubbleLabels = chartData;
        return this;
    }

    public Integer getBubbleMaxRadiusSize() {
        return this.bubbleMaxRadiusSize;
    }

    public BubbleChartSpec setBubbleMaxRadiusSize(Integer num) {
        this.bubbleMaxRadiusSize = num;
        return this;
    }

    public Integer getBubbleMinRadiusSize() {
        return this.bubbleMinRadiusSize;
    }

    public BubbleChartSpec setBubbleMinRadiusSize(Integer num) {
        this.bubbleMinRadiusSize = num;
        return this;
    }

    public Float getBubbleOpacity() {
        return this.bubbleOpacity;
    }

    public BubbleChartSpec setBubbleOpacity(Float f) {
        this.bubbleOpacity = f;
        return this;
    }

    public ChartData getBubbleSizes() {
        return this.bubbleSizes;
    }

    public BubbleChartSpec setBubbleSizes(ChartData chartData) {
        this.bubbleSizes = chartData;
        return this;
    }

    public TextFormat getBubbleTextStyle() {
        return this.bubbleTextStyle;
    }

    public BubbleChartSpec setBubbleTextStyle(TextFormat textFormat) {
        this.bubbleTextStyle = textFormat;
        return this;
    }

    public ChartData getDomain() {
        return this.domain;
    }

    public BubbleChartSpec setDomain(ChartData chartData) {
        this.domain = chartData;
        return this;
    }

    public ChartData getGroupIds() {
        return this.groupIds;
    }

    public BubbleChartSpec setGroupIds(ChartData chartData) {
        this.groupIds = chartData;
        return this;
    }

    public String getLegendPosition() {
        return this.legendPosition;
    }

    public BubbleChartSpec setLegendPosition(String str) {
        this.legendPosition = str;
        return this;
    }

    public ChartData getSeries() {
        return this.series;
    }

    public BubbleChartSpec setSeries(ChartData chartData) {
        this.series = chartData;
        return this;
    }

    public BubbleChartSpec set(String str, Object obj) {
        return (BubbleChartSpec) super.set(str, obj);
    }

    public BubbleChartSpec clone() {
        return (BubbleChartSpec) super.clone();
    }
}
