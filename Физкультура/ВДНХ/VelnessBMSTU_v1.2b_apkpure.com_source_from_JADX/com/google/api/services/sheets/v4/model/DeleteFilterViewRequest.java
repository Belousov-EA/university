package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteFilterViewRequest extends GenericJson {
    @Key
    private Integer filterId;

    public Integer getFilterId() {
        return this.filterId;
    }

    public DeleteFilterViewRequest setFilterId(Integer num) {
        this.filterId = num;
        return this;
    }

    public DeleteFilterViewRequest set(String str, Object obj) {
        return (DeleteFilterViewRequest) super.set(str, obj);
    }

    public DeleteFilterViewRequest clone() {
        return (DeleteFilterViewRequest) super.clone();
    }
}
