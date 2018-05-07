package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteNamedRangeRequest extends GenericJson {
    @Key
    private String namedRangeId;

    public String getNamedRangeId() {
        return this.namedRangeId;
    }

    public DeleteNamedRangeRequest setNamedRangeId(String str) {
        this.namedRangeId = str;
        return this;
    }

    public DeleteNamedRangeRequest set(String str, Object obj) {
        return (DeleteNamedRangeRequest) super.set(str, obj);
    }

    public DeleteNamedRangeRequest clone() {
        return (DeleteNamedRangeRequest) super.clone();
    }
}
