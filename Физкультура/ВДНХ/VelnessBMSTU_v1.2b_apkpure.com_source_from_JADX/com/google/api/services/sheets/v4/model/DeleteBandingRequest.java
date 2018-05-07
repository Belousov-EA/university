package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteBandingRequest extends GenericJson {
    @Key
    private Integer bandedRangeId;

    public Integer getBandedRangeId() {
        return this.bandedRangeId;
    }

    public DeleteBandingRequest setBandedRangeId(Integer num) {
        this.bandedRangeId = num;
        return this;
    }

    public DeleteBandingRequest set(String str, Object obj) {
        return (DeleteBandingRequest) super.set(str, obj);
    }

    public DeleteBandingRequest clone() {
        return (DeleteBandingRequest) super.clone();
    }
}
