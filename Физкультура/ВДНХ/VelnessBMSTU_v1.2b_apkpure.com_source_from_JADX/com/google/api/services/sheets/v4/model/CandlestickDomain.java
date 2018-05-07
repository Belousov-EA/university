package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CandlestickDomain extends GenericJson {
    @Key
    private ChartData data;
    @Key
    private Boolean reversed;

    public ChartData getData() {
        return this.data;
    }

    public CandlestickDomain setData(ChartData chartData) {
        this.data = chartData;
        return this;
    }

    public Boolean getReversed() {
        return this.reversed;
    }

    public CandlestickDomain setReversed(Boolean bool) {
        this.reversed = bool;
        return this;
    }

    public CandlestickDomain set(String str, Object obj) {
        return (CandlestickDomain) super.set(str, obj);
    }

    public CandlestickDomain clone() {
        return (CandlestickDomain) super.clone();
    }
}
