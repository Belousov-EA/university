package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateProtectedRangeRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private ProtectedRange protectedRange;

    public String getFields() {
        return this.fields;
    }

    public UpdateProtectedRangeRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public ProtectedRange getProtectedRange() {
        return this.protectedRange;
    }

    public UpdateProtectedRangeRequest setProtectedRange(ProtectedRange protectedRange) {
        this.protectedRange = protectedRange;
        return this;
    }

    public UpdateProtectedRangeRequest set(String str, Object obj) {
        return (UpdateProtectedRangeRequest) super.set(str, obj);
    }

    public UpdateProtectedRangeRequest clone() {
        return (UpdateProtectedRangeRequest) super.clone();
    }
}
