package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class HistogramRule extends GenericJson {
    @Key
    private Double end;
    @Key
    private Double interval;
    @Key
    private Double start;

    public Double getEnd() {
        return this.end;
    }

    public HistogramRule setEnd(Double d) {
        this.end = d;
        return this;
    }

    public Double getInterval() {
        return this.interval;
    }

    public HistogramRule setInterval(Double d) {
        this.interval = d;
        return this;
    }

    public Double getStart() {
        return this.start;
    }

    public HistogramRule setStart(Double d) {
        this.start = d;
        return this;
    }

    public HistogramRule set(String str, Object obj) {
        return (HistogramRule) super.set(str, obj);
    }

    public HistogramRule clone() {
        return (HistogramRule) super.clone();
    }
}
