package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DuplicateFilterViewRequest extends GenericJson {
    @Key
    private Integer filterId;

    public Integer getFilterId() {
        return this.filterId;
    }

    public DuplicateFilterViewRequest setFilterId(Integer num) {
        this.filterId = num;
        return this;
    }

    public DuplicateFilterViewRequest set(String str, Object obj) {
        return (DuplicateFilterViewRequest) super.set(str, obj);
    }

    public DuplicateFilterViewRequest clone() {
        return (DuplicateFilterViewRequest) super.clone();
    }
}
