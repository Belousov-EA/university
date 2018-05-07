package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddNamedRangeResponse extends GenericJson {
    @Key
    private NamedRange namedRange;

    public NamedRange getNamedRange() {
        return this.namedRange;
    }

    public AddNamedRangeResponse setNamedRange(NamedRange namedRange) {
        this.namedRange = namedRange;
        return this;
    }

    public AddNamedRangeResponse set(String str, Object obj) {
        return (AddNamedRangeResponse) super.set(str, obj);
    }

    public AddNamedRangeResponse clone() {
        return (AddNamedRangeResponse) super.clone();
    }
}
