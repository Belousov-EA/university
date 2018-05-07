package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddProtectedRangeRequest extends GenericJson {
    @Key
    private ProtectedRange protectedRange;

    public ProtectedRange getProtectedRange() {
        return this.protectedRange;
    }

    public AddProtectedRangeRequest setProtectedRange(ProtectedRange protectedRange) {
        this.protectedRange = protectedRange;
        return this;
    }

    public AddProtectedRangeRequest set(String str, Object obj) {
        return (AddProtectedRangeRequest) super.set(str, obj);
    }

    public AddProtectedRangeRequest clone() {
        return (AddProtectedRangeRequest) super.clone();
    }
}
