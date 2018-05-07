package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BatchClearValuesRequest extends GenericJson {
    @Key
    private List<String> ranges;

    public List<String> getRanges() {
        return this.ranges;
    }

    public BatchClearValuesRequest setRanges(List<String> list) {
        this.ranges = list;
        return this;
    }

    public BatchClearValuesRequest set(String str, Object obj) {
        return (BatchClearValuesRequest) super.set(str, obj);
    }

    public BatchClearValuesRequest clone() {
        return (BatchClearValuesRequest) super.clone();
    }
}
