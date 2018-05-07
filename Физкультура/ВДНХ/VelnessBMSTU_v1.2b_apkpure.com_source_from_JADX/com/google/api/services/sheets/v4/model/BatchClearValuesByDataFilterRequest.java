package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchClearValuesByDataFilterRequest extends GenericJson {
    @Key
    private List<DataFilter> dataFilters;

    public List<DataFilter> getDataFilters() {
        return this.dataFilters;
    }

    public BatchClearValuesByDataFilterRequest setDataFilters(List<DataFilter> list) {
        this.dataFilters = list;
        return this;
    }

    public BatchClearValuesByDataFilterRequest set(String str, Object obj) {
        return (BatchClearValuesByDataFilterRequest) super.set(str, obj);
    }

    public BatchClearValuesByDataFilterRequest clone() {
        return (BatchClearValuesByDataFilterRequest) super.clone();
    }
}
