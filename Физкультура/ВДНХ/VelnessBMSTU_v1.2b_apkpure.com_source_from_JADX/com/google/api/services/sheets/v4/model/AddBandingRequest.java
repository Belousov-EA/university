package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddBandingRequest extends GenericJson {
    @Key
    private BandedRange bandedRange;

    public BandedRange getBandedRange() {
        return this.bandedRange;
    }

    public AddBandingRequest setBandedRange(BandedRange bandedRange) {
        this.bandedRange = bandedRange;
        return this;
    }

    public AddBandingRequest set(String str, Object obj) {
        return (AddBandingRequest) super.set(str, obj);
    }

    public AddBandingRequest clone() {
        return (AddBandingRequest) super.clone();
    }
}
