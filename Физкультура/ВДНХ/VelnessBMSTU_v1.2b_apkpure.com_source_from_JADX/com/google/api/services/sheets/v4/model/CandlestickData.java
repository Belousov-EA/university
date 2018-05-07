package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CandlestickData extends GenericJson {
    @Key
    private CandlestickSeries closeSeries;
    @Key
    private CandlestickSeries highSeries;
    @Key
    private CandlestickSeries lowSeries;
    @Key
    private CandlestickSeries openSeries;

    public CandlestickSeries getCloseSeries() {
        return this.closeSeries;
    }

    public CandlestickData setCloseSeries(CandlestickSeries candlestickSeries) {
        this.closeSeries = candlestickSeries;
        return this;
    }

    public CandlestickSeries getHighSeries() {
        return this.highSeries;
    }

    public CandlestickData setHighSeries(CandlestickSeries candlestickSeries) {
        this.highSeries = candlestickSeries;
        return this;
    }

    public CandlestickSeries getLowSeries() {
        return this.lowSeries;
    }

    public CandlestickData setLowSeries(CandlestickSeries candlestickSeries) {
        this.lowSeries = candlestickSeries;
        return this;
    }

    public CandlestickSeries getOpenSeries() {
        return this.openSeries;
    }

    public CandlestickData setOpenSeries(CandlestickSeries candlestickSeries) {
        this.openSeries = candlestickSeries;
        return this;
    }

    public CandlestickData set(String str, Object obj) {
        return (CandlestickData) super.set(str, obj);
    }

    public CandlestickData clone() {
        return (CandlestickData) super.clone();
    }
}
