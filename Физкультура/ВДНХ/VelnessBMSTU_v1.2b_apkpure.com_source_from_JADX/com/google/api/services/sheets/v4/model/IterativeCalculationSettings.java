package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class IterativeCalculationSettings extends GenericJson {
    @Key
    private Double convergenceThreshold;
    @Key
    private Integer maxIterations;

    public Double getConvergenceThreshold() {
        return this.convergenceThreshold;
    }

    public IterativeCalculationSettings setConvergenceThreshold(Double d) {
        this.convergenceThreshold = d;
        return this;
    }

    public Integer getMaxIterations() {
        return this.maxIterations;
    }

    public IterativeCalculationSettings setMaxIterations(Integer num) {
        this.maxIterations = num;
        return this;
    }

    public IterativeCalculationSettings set(String str, Object obj) {
        return (IterativeCalculationSettings) super.set(str, obj);
    }

    public IterativeCalculationSettings clone() {
        return (IterativeCalculationSettings) super.clone();
    }
}
