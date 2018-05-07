package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateChartSpecRequest extends GenericJson {
    @Key
    private Integer chartId;
    @Key
    private ChartSpec spec;

    public Integer getChartId() {
        return this.chartId;
    }

    public UpdateChartSpecRequest setChartId(Integer num) {
        this.chartId = num;
        return this;
    }

    public ChartSpec getSpec() {
        return this.spec;
    }

    public UpdateChartSpecRequest setSpec(ChartSpec chartSpec) {
        this.spec = chartSpec;
        return this;
    }

    public UpdateChartSpecRequest set(String str, Object obj) {
        return (UpdateChartSpecRequest) super.set(str, obj);
    }

    public UpdateChartSpecRequest clone() {
        return (UpdateChartSpecRequest) super.clone();
    }
}
