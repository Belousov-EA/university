package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class BasicChartDomain extends GenericJson {
    @Key
    private ChartData domain;
    @Key
    private Boolean reversed;

    public ChartData getDomain() {
        return this.domain;
    }

    public BasicChartDomain setDomain(ChartData chartData) {
        this.domain = chartData;
        return this;
    }

    public Boolean getReversed() {
        return this.reversed;
    }

    public BasicChartDomain setReversed(Boolean bool) {
        this.reversed = bool;
        return this;
    }

    public BasicChartDomain set(String str, Object obj) {
        return (BasicChartDomain) super.set(str, obj);
    }

    public BasicChartDomain clone() {
        return (BasicChartDomain) super.clone();
    }
}
