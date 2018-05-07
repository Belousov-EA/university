package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ChartSpec extends GenericJson {
    @Key
    private String altText;
    @Key
    private Color backgroundColor;
    @Key
    private BasicChartSpec basicChart;
    @Key
    private BubbleChartSpec bubbleChart;
    @Key
    private CandlestickChartSpec candlestickChart;
    @Key
    private String fontName;
    @Key
    private String hiddenDimensionStrategy;
    @Key
    private HistogramChartSpec histogramChart;
    @Key
    private Boolean maximized;
    @Key
    private OrgChartSpec orgChart;
    @Key
    private PieChartSpec pieChart;
    @Key
    private String subtitle;
    @Key
    private TextFormat subtitleTextFormat;
    @Key
    private TextPosition subtitleTextPosition;
    @Key
    private String title;
    @Key
    private TextFormat titleTextFormat;
    @Key
    private TextPosition titleTextPosition;
    @Key
    private WaterfallChartSpec waterfallChart;

    public String getAltText() {
        return this.altText;
    }

    public ChartSpec setAltText(String str) {
        this.altText = str;
        return this;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public ChartSpec setBackgroundColor(Color color) {
        this.backgroundColor = color;
        return this;
    }

    public BasicChartSpec getBasicChart() {
        return this.basicChart;
    }

    public ChartSpec setBasicChart(BasicChartSpec basicChartSpec) {
        this.basicChart = basicChartSpec;
        return this;
    }

    public BubbleChartSpec getBubbleChart() {
        return this.bubbleChart;
    }

    public ChartSpec setBubbleChart(BubbleChartSpec bubbleChartSpec) {
        this.bubbleChart = bubbleChartSpec;
        return this;
    }

    public CandlestickChartSpec getCandlestickChart() {
        return this.candlestickChart;
    }

    public ChartSpec setCandlestickChart(CandlestickChartSpec candlestickChartSpec) {
        this.candlestickChart = candlestickChartSpec;
        return this;
    }

    public String getFontName() {
        return this.fontName;
    }

    public ChartSpec setFontName(String str) {
        this.fontName = str;
        return this;
    }

    public String getHiddenDimensionStrategy() {
        return this.hiddenDimensionStrategy;
    }

    public ChartSpec setHiddenDimensionStrategy(String str) {
        this.hiddenDimensionStrategy = str;
        return this;
    }

    public HistogramChartSpec getHistogramChart() {
        return this.histogramChart;
    }

    public ChartSpec setHistogramChart(HistogramChartSpec histogramChartSpec) {
        this.histogramChart = histogramChartSpec;
        return this;
    }

    public Boolean getMaximized() {
        return this.maximized;
    }

    public ChartSpec setMaximized(Boolean bool) {
        this.maximized = bool;
        return this;
    }

    public OrgChartSpec getOrgChart() {
        return this.orgChart;
    }

    public ChartSpec setOrgChart(OrgChartSpec orgChartSpec) {
        this.orgChart = orgChartSpec;
        return this;
    }

    public PieChartSpec getPieChart() {
        return this.pieChart;
    }

    public ChartSpec setPieChart(PieChartSpec pieChartSpec) {
        this.pieChart = pieChartSpec;
        return this;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public ChartSpec setSubtitle(String str) {
        this.subtitle = str;
        return this;
    }

    public TextFormat getSubtitleTextFormat() {
        return this.subtitleTextFormat;
    }

    public ChartSpec setSubtitleTextFormat(TextFormat textFormat) {
        this.subtitleTextFormat = textFormat;
        return this;
    }

    public TextPosition getSubtitleTextPosition() {
        return this.subtitleTextPosition;
    }

    public ChartSpec setSubtitleTextPosition(TextPosition textPosition) {
        this.subtitleTextPosition = textPosition;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public ChartSpec setTitle(String str) {
        this.title = str;
        return this;
    }

    public TextFormat getTitleTextFormat() {
        return this.titleTextFormat;
    }

    public ChartSpec setTitleTextFormat(TextFormat textFormat) {
        this.titleTextFormat = textFormat;
        return this;
    }

    public TextPosition getTitleTextPosition() {
        return this.titleTextPosition;
    }

    public ChartSpec setTitleTextPosition(TextPosition textPosition) {
        this.titleTextPosition = textPosition;
        return this;
    }

    public WaterfallChartSpec getWaterfallChart() {
        return this.waterfallChart;
    }

    public ChartSpec setWaterfallChart(WaterfallChartSpec waterfallChartSpec) {
        this.waterfallChart = waterfallChartSpec;
        return this;
    }

    public ChartSpec set(String str, Object obj) {
        return (ChartSpec) super.set(str, obj);
    }

    public ChartSpec clone() {
        return (ChartSpec) super.clone();
    }
}
