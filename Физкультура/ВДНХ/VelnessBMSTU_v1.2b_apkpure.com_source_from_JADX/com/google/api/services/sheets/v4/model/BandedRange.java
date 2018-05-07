package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class BandedRange extends GenericJson {
    @Key
    private Integer bandedRangeId;
    @Key
    private BandingProperties columnProperties;
    @Key
    private GridRange range;
    @Key
    private BandingProperties rowProperties;

    public Integer getBandedRangeId() {
        return this.bandedRangeId;
    }

    public BandedRange setBandedRangeId(Integer num) {
        this.bandedRangeId = num;
        return this;
    }

    public BandingProperties getColumnProperties() {
        return this.columnProperties;
    }

    public BandedRange setColumnProperties(BandingProperties bandingProperties) {
        this.columnProperties = bandingProperties;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public BandedRange setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public BandingProperties getRowProperties() {
        return this.rowProperties;
    }

    public BandedRange setRowProperties(BandingProperties bandingProperties) {
        this.rowProperties = bandingProperties;
        return this;
    }

    public BandedRange set(String str, Object obj) {
        return (BandedRange) super.set(str, obj);
    }

    public BandedRange clone() {
        return (BandedRange) super.clone();
    }
}
