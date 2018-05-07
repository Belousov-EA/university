package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddNamedRangeRequest extends GenericJson {
    @Key
    private NamedRange namedRange;

    public NamedRange getNamedRange() {
        return this.namedRange;
    }

    public AddNamedRangeRequest setNamedRange(NamedRange namedRange) {
        this.namedRange = namedRange;
        return this;
    }

    public AddNamedRangeRequest set(String str, Object obj) {
        return (AddNamedRangeRequest) super.set(str, obj);
    }

    public AddNamedRangeRequest clone() {
        return (AddNamedRangeRequest) super.clone();
    }
}
