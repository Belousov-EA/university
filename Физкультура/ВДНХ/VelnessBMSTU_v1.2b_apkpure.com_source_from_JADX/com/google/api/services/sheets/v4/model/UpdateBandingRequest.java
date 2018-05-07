package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateBandingRequest extends GenericJson {
    @Key
    private BandedRange bandedRange;
    @Key
    private String fields;

    public BandedRange getBandedRange() {
        return this.bandedRange;
    }

    public UpdateBandingRequest setBandedRange(BandedRange bandedRange) {
        this.bandedRange = bandedRange;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public UpdateBandingRequest setFields(String str) {
        this.fields = str;
        return this;
    }

    public UpdateBandingRequest set(String str, Object obj) {
        return (UpdateBandingRequest) super.set(str, obj);
    }

    public UpdateBandingRequest clone() {
        return (UpdateBandingRequest) super.clone();
    }
}
