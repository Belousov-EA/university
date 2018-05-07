package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class DataFilterValueRange extends GenericJson {
    @Key
    private DataFilter dataFilter;
    @Key
    private String majorDimension;
    @Key
    private List<List<Object>> values;

    public DataFilter getDataFilter() {
        return this.dataFilter;
    }

    public DataFilterValueRange setDataFilter(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
        return this;
    }

    public String getMajorDimension() {
        return this.majorDimension;
    }

    public DataFilterValueRange setMajorDimension(String str) {
        this.majorDimension = str;
        return this;
    }

    public List<List<Object>> getValues() {
        return this.values;
    }

    public DataFilterValueRange setValues(List<List<Object>> list) {
        this.values = list;
        return this;
    }

    public DataFilterValueRange set(String str, Object obj) {
        return (DataFilterValueRange) super.set(str, obj);
    }

    public DataFilterValueRange clone() {
        return (DataFilterValueRange) super.clone();
    }
}
