package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateNamedRangeRequest extends GenericJson {
    @Key
    private String fields;
    @Key
    private NamedRange namedRange;

    public String getFields() {
        return this.fields;
    }

    public UpdateNamedRangeRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public NamedRange getNamedRange() {
        return this.namedRange;
    }

    public UpdateNamedRangeRequest setNamedRange(NamedRange namedRange) {
        this.namedRange = namedRange;
        return this;
    }

    public UpdateNamedRangeRequest set(String str, Object obj) {
        return (UpdateNamedRangeRequest) super.set(str, obj);
    }

    public UpdateNamedRangeRequest clone() {
        return (UpdateNamedRangeRequest) super.clone();
    }
}
