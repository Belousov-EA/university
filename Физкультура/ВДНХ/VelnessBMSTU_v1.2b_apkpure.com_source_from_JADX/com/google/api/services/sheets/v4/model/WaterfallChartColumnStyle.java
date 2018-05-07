package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class WaterfallChartColumnStyle extends GenericJson {
    @Key
    private Color color;
    @Key
    private String label;

    public Color getColor() {
        return this.color;
    }

    public WaterfallChartColumnStyle setColor(Color color) {
        this.color = color;
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public WaterfallChartColumnStyle setLabel(String str) {
        this.label = str;
        return this;
    }

    public WaterfallChartColumnStyle set(String str, Object obj) {
        return (WaterfallChartColumnStyle) super.set(str, obj);
    }

    public WaterfallChartColumnStyle clone() {
        return (WaterfallChartColumnStyle) super.clone();
    }
}
