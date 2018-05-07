package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class GetSpreadsheetByDataFilterRequest extends GenericJson {
    @Key
    private List<DataFilter> dataFilters;
    @Key
    private Boolean includeGridData;

    public List<DataFilter> getDataFilters() {
        return this.dataFilters;
    }

    public GetSpreadsheetByDataFilterRequest setDataFilters(List<DataFilter> list) {
        this.dataFilters = list;
        return this;
    }

    public Boolean getIncludeGridData() {
        return this.includeGridData;
    }

    public GetSpreadsheetByDataFilterRequest setIncludeGridData(Boolean bool) {
        this.includeGridData = bool;
        return this;
    }

    public GetSpreadsheetByDataFilterRequest set(String str, Object obj) {
        return (GetSpreadsheetByDataFilterRequest) super.set(str, obj);
    }

    public GetSpreadsheetByDataFilterRequest clone() {
        return (GetSpreadsheetByDataFilterRequest) super.clone();
    }
}
