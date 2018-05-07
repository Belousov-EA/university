package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class CandlestickChartSpec extends GenericJson {
    @Key
    private List<CandlestickData> data;
    @Key
    private CandlestickDomain domain;

    public List<CandlestickData> getData() {
        return this.data;
    }

    public CandlestickChartSpec setData(List<CandlestickData> list) {
        this.data = list;
        return this;
    }

    public CandlestickDomain getDomain() {
        return this.domain;
    }

    public CandlestickChartSpec setDomain(CandlestickDomain candlestickDomain) {
        this.domain = candlestickDomain;
        return this;
    }

    public CandlestickChartSpec set(String str, Object obj) {
        return (CandlestickChartSpec) super.set(str, obj);
    }

    public CandlestickChartSpec clone() {
        return (CandlestickChartSpec) super.clone();
    }
}
