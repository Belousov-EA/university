package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class WaterfallChartCustomSubtotal extends GenericJson {
    @Key
    private Boolean dataIsSubtotal;
    @Key
    private String label;
    @Key
    private Integer subtotalIndex;

    public Boolean getDataIsSubtotal() {
        return this.dataIsSubtotal;
    }

    public WaterfallChartCustomSubtotal setDataIsSubtotal(Boolean bool) {
        this.dataIsSubtotal = bool;
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public WaterfallChartCustomSubtotal setLabel(String str) {
        this.label = str;
        return this;
    }

    public Integer getSubtotalIndex() {
        return this.subtotalIndex;
    }

    public WaterfallChartCustomSubtotal setSubtotalIndex(Integer num) {
        this.subtotalIndex = num;
        return this;
    }

    public WaterfallChartCustomSubtotal set(String str, Object obj) {
        return (WaterfallChartCustomSubtotal) super.set(str, obj);
    }

    public WaterfallChartCustomSubtotal clone() {
        return (WaterfallChartCustomSubtotal) super.clone();
    }
}
