package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CandlestickSeries extends GenericJson {
    @Key
    private ChartData data;

    public ChartData getData() {
        return this.data;
    }

    public CandlestickSeries setData(ChartData chartData) {
        this.data = chartData;
        return this;
    }

    public CandlestickSeries set(String str, Object obj) {
        return (CandlestickSeries) super.set(str, obj);
    }

    public CandlestickSeries clone() {
        return (CandlestickSeries) super.clone();
    }
}
