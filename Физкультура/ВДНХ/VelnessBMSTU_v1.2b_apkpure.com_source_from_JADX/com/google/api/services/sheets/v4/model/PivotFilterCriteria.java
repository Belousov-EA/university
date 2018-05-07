package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class PivotFilterCriteria extends GenericJson {
    @Key
    private List<String> visibleValues;

    public List<String> getVisibleValues() {
        return this.visibleValues;
    }

    public PivotFilterCriteria setVisibleValues(List<String> list) {
        this.visibleValues = list;
        return this;
    }

    public PivotFilterCriteria set(String str, Object obj) {
        return (PivotFilterCriteria) super.set(str, obj);
    }

    public PivotFilterCriteria clone() {
        return (PivotFilterCriteria) super.clone();
    }
}
