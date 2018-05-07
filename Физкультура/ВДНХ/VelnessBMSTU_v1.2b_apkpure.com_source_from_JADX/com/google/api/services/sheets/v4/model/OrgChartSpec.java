package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class OrgChartSpec extends GenericJson {
    @Key
    private ChartData labels;
    @Key
    private Color nodeColor;
    @Key
    private String nodeSize;
    @Key
    private ChartData parentLabels;
    @Key
    private Color selectedNodeColor;
    @Key
    private ChartData tooltips;

    public ChartData getLabels() {
        return this.labels;
    }

    public OrgChartSpec setLabels(ChartData chartData) {
        this.labels = chartData;
        return this;
    }

    public Color getNodeColor() {
        return this.nodeColor;
    }

    public OrgChartSpec setNodeColor(Color color) {
        this.nodeColor = color;
        return this;
    }

    public String getNodeSize() {
        return this.nodeSize;
    }

    public OrgChartSpec setNodeSize(String str) {
        this.nodeSize = str;
        return this;
    }

    public ChartData getParentLabels() {
        return this.parentLabels;
    }

    public OrgChartSpec setParentLabels(ChartData chartData) {
        this.parentLabels = chartData;
        return this;
    }

    public Color getSelectedNodeColor() {
        return this.selectedNodeColor;
    }

    public OrgChartSpec setSelectedNodeColor(Color color) {
        this.selectedNodeColor = color;
        return this;
    }

    public ChartData getTooltips() {
        return this.tooltips;
    }

    public OrgChartSpec setTooltips(ChartData chartData) {
        this.tooltips = chartData;
        return this;
    }

    public OrgChartSpec set(String str, Object obj) {
        return (OrgChartSpec) super.set(str, obj);
    }

    public OrgChartSpec clone() {
        return (OrgChartSpec) super.clone();
    }
}
