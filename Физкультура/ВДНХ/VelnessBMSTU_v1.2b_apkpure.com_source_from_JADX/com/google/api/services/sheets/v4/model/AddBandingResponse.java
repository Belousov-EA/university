package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddBandingResponse extends GenericJson {
    @Key
    private BandedRange bandedRange;

    public BandedRange getBandedRange() {
        return this.bandedRange;
    }

    public AddBandingResponse setBandedRange(BandedRange bandedRange) {
        this.bandedRange = bandedRange;
        return this;
    }

    public AddBandingResponse set(String str, Object obj) {
        return (AddBandingResponse) super.set(str, obj);
    }

    public AddBandingResponse clone() {
        return (AddBandingResponse) super.clone();
    }
}
