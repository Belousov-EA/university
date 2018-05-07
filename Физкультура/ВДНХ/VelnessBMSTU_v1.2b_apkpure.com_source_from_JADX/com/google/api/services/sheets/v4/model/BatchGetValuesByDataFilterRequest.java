package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchGetValuesByDataFilterRequest extends GenericJson {
    @Key
    private List<DataFilter> dataFilters;
    @Key
    private String dateTimeRenderOption;
    @Key
    private String majorDimension;
    @Key
    private String valueRenderOption;

    public List<DataFilter> getDataFilters() {
        return this.dataFilters;
    }

    public BatchGetValuesByDataFilterRequest setDataFilters(List<DataFilter> list) {
        this.dataFilters = list;
        return this;
    }

    public String getDateTimeRenderOption() {
        return this.dateTimeRenderOption;
    }

    public BatchGetValuesByDataFilterRequest setDateTimeRenderOption(String str) {
        this.dateTimeRenderOption = str;
        return this;
    }

    public String getMajorDimension() {
        return this.majorDimension;
    }

    public BatchGetValuesByDataFilterRequest setMajorDimension(String str) {
        this.majorDimension = str;
        return this;
    }

    public String getValueRenderOption() {
        return this.valueRenderOption;
    }

    public BatchGetValuesByDataFilterRequest setValueRenderOption(String str) {
        this.valueRenderOption = str;
        return this;
    }

    public BatchGetValuesByDataFilterRequest set(String str, Object obj) {
        return (BatchGetValuesByDataFilterRequest) super.set(str, obj);
    }

    public BatchGetValuesByDataFilterRequest clone() {
        return (BatchGetValuesByDataFilterRequest) super.clone();
    }
}
