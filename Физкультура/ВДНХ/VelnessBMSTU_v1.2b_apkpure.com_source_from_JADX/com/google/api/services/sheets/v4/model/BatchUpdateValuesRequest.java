package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchUpdateValuesRequest extends GenericJson {
    @Key
    private List<ValueRange> data;
    @Key
    private Boolean includeValuesInResponse;
    @Key
    private String responseDateTimeRenderOption;
    @Key
    private String responseValueRenderOption;
    @Key
    private String valueInputOption;

    public List<ValueRange> getData() {
        return this.data;
    }

    public BatchUpdateValuesRequest setData(List<ValueRange> list) {
        this.data = list;
        return this;
    }

    public Boolean getIncludeValuesInResponse() {
        return this.includeValuesInResponse;
    }

    public BatchUpdateValuesRequest setIncludeValuesInResponse(Boolean bool) {
        this.includeValuesInResponse = bool;
        return this;
    }

    public String getResponseDateTimeRenderOption() {
        return this.responseDateTimeRenderOption;
    }

    public BatchUpdateValuesRequest setResponseDateTimeRenderOption(String str) {
        this.responseDateTimeRenderOption = str;
        return this;
    }

    public String getResponseValueRenderOption() {
        return this.responseValueRenderOption;
    }

    public BatchUpdateValuesRequest setResponseValueRenderOption(String str) {
        this.responseValueRenderOption = str;
        return this;
    }

    public String getValueInputOption() {
        return this.valueInputOption;
    }

    public BatchUpdateValuesRequest setValueInputOption(String str) {
        this.valueInputOption = str;
        return this;
    }

    public BatchUpdateValuesRequest set(String str, Object obj) {
        return (BatchUpdateValuesRequest) super.set(str, obj);
    }

    public BatchUpdateValuesRequest clone() {
        return (BatchUpdateValuesRequest) super.clone();
    }
}
