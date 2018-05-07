package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateValuesByDataFilterRequest extends GenericJson {
    @Key
    private List<DataFilterValueRange> data;
    @Key
    private Boolean includeValuesInResponse;
    @Key
    private String responseDateTimeRenderOption;
    @Key
    private String responseValueRenderOption;
    @Key
    private String valueInputOption;

    public List<DataFilterValueRange> getData() {
        return this.data;
    }

    public BatchUpdateValuesByDataFilterRequest setData(List<DataFilterValueRange> list) {
        this.data = list;
        return this;
    }

    public Boolean getIncludeValuesInResponse() {
        return this.includeValuesInResponse;
    }

    public BatchUpdateValuesByDataFilterRequest setIncludeValuesInResponse(Boolean bool) {
        this.includeValuesInResponse = bool;
        return this;
    }

    public String getResponseDateTimeRenderOption() {
        return this.responseDateTimeRenderOption;
    }

    public BatchUpdateValuesByDataFilterRequest setResponseDateTimeRenderOption(String str) {
        this.responseDateTimeRenderOption = str;
        return this;
    }

    public String getResponseValueRenderOption() {
        return this.responseValueRenderOption;
    }

    public BatchUpdateValuesByDataFilterRequest setResponseValueRenderOption(String str) {
        this.responseValueRenderOption = str;
        return this;
    }

    public String getValueInputOption() {
        return this.valueInputOption;
    }

    public BatchUpdateValuesByDataFilterRequest setValueInputOption(String str) {
        this.valueInputOption = str;
        return this;
    }

    public BatchUpdateValuesByDataFilterRequest set(String str, Object obj) {
        return (BatchUpdateValuesByDataFilterRequest) super.set(str, obj);
    }

    public BatchUpdateValuesByDataFilterRequest clone() {
        return (BatchUpdateValuesByDataFilterRequest) super.clone();
    }
}
