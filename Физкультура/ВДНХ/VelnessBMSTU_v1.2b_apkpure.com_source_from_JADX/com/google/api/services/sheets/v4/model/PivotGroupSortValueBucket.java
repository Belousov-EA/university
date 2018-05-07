package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class PivotGroupSortValueBucket extends GenericJson {
    @Key
    private List<ExtendedValue> buckets;
    @Key
    private Integer valuesIndex;

    public List<ExtendedValue> getBuckets() {
        return this.buckets;
    }

    public PivotGroupSortValueBucket setBuckets(List<ExtendedValue> list) {
        this.buckets = list;
        return this;
    }

    public Integer getValuesIndex() {
        return this.valuesIndex;
    }

    public PivotGroupSortValueBucket setValuesIndex(Integer num) {
        this.valuesIndex = num;
        return this;
    }

    public PivotGroupSortValueBucket set(String str, Object obj) {
        return (PivotGroupSortValueBucket) super.set(str, obj);
    }

    public PivotGroupSortValueBucket clone() {
        return (PivotGroupSortValueBucket) super.clone();
    }
}
