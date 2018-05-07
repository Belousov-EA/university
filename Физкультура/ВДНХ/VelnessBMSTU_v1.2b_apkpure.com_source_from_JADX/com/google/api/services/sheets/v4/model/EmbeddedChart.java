package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class EmbeddedChart extends GenericJson {
    @Key
    private Integer chartId;
    @Key
    private EmbeddedObjectPosition position;
    @Key
    private ChartSpec spec;

    public Integer getChartId() {
        return this.chartId;
    }

    public EmbeddedChart setChartId(Integer num) {
        this.chartId = num;
        return this;
    }

    public EmbeddedObjectPosition getPosition() {
        return this.position;
    }

    public EmbeddedChart setPosition(EmbeddedObjectPosition embeddedObjectPosition) {
        this.position = embeddedObjectPosition;
        return this;
    }

    public ChartSpec getSpec() {
        return this.spec;
    }

    public EmbeddedChart setSpec(ChartSpec chartSpec) {
        this.spec = chartSpec;
        return this;
    }

    public EmbeddedChart set(String str, Object obj) {
        return (EmbeddedChart) super.set(str, obj);
    }

    public EmbeddedChart clone() {
        return (EmbeddedChart) super.clone();
    }
}
