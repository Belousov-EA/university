package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddProtectedRangeResponse extends GenericJson {
    @Key
    private ProtectedRange protectedRange;

    public ProtectedRange getProtectedRange() {
        return this.protectedRange;
    }

    public AddProtectedRangeResponse setProtectedRange(ProtectedRange protectedRange) {
        this.protectedRange = protectedRange;
        return this;
    }

    public AddProtectedRangeResponse set(String str, Object obj) {
        return (AddProtectedRangeResponse) super.set(str, obj);
    }

    public AddProtectedRangeResponse clone() {
        return (AddProtectedRangeResponse) super.clone();
    }
}
