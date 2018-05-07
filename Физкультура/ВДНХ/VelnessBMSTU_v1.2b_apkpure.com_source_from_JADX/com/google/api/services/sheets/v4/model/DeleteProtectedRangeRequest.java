package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteProtectedRangeRequest extends GenericJson {
    @Key
    private Integer protectedRangeId;

    public Integer getProtectedRangeId() {
        return this.protectedRangeId;
    }

    public DeleteProtectedRangeRequest setProtectedRangeId(Integer num) {
        this.protectedRangeId = num;
        return this;
    }

    public DeleteProtectedRangeRequest set(String str, Object obj) {
        return (DeleteProtectedRangeRequest) super.set(str, obj);
    }

    public DeleteProtectedRangeRequest clone() {
        return (DeleteProtectedRangeRequest) super.clone();
    }
}
