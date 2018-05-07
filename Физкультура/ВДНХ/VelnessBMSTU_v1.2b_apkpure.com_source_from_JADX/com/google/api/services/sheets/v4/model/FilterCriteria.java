package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class FilterCriteria extends GenericJson {
    @Key
    private BooleanCondition condition;
    @Key
    private List<String> hiddenValues;

    public BooleanCondition getCondition() {
        return this.condition;
    }

    public FilterCriteria setCondition(BooleanCondition booleanCondition) {
        this.condition = booleanCondition;
        return this;
    }

    public List<String> getHiddenValues() {
        return this.hiddenValues;
    }

    public FilterCriteria setHiddenValues(List<String> list) {
        this.hiddenValues = list;
        return this;
    }

    public FilterCriteria set(String str, Object obj) {
        return (FilterCriteria) super.set(str, obj);
    }

    public FilterCriteria clone() {
        return (FilterCriteria) super.clone();
    }
}
