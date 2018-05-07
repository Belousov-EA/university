package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class MatchedValueRange extends GenericJson {
    @Key
    private List<DataFilter> dataFilters;
    @Key
    private ValueRange valueRange;

    public List<DataFilter> getDataFilters() {
        return this.dataFilters;
    }

    public MatchedValueRange setDataFilters(List<DataFilter> list) {
        this.dataFilters = list;
        return this;
    }

    public ValueRange getValueRange() {
        return this.valueRange;
    }

    public MatchedValueRange setValueRange(ValueRange valueRange) {
        this.valueRange = valueRange;
        return this;
    }

    public MatchedValueRange set(String str, Object obj) {
        return (MatchedValueRange) super.set(str, obj);
    }

    public MatchedValueRange clone() {
        return (MatchedValueRange) super.clone();
    }
}
