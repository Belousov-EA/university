package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ChartData extends GenericJson {
    @Key
    private ChartSourceRange sourceRange;

    public ChartSourceRange getSourceRange() {
        return this.sourceRange;
    }

    public ChartData setSourceRange(ChartSourceRange chartSourceRange) {
        this.sourceRange = chartSourceRange;
        return this;
    }

    public ChartData set(String str, Object obj) {
        return (ChartData) super.set(str, obj);
    }

    public ChartData clone() {
        return (ChartData) super.clone();
    }
}
