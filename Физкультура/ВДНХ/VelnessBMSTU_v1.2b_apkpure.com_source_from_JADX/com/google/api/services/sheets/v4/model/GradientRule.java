package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class GradientRule extends GenericJson {
    @Key
    private InterpolationPoint maxpoint;
    @Key
    private InterpolationPoint midpoint;
    @Key
    private InterpolationPoint minpoint;

    public InterpolationPoint getMaxpoint() {
        return this.maxpoint;
    }

    public GradientRule setMaxpoint(InterpolationPoint interpolationPoint) {
        this.maxpoint = interpolationPoint;
        return this;
    }

    public InterpolationPoint getMidpoint() {
        return this.midpoint;
    }

    public GradientRule setMidpoint(InterpolationPoint interpolationPoint) {
        this.midpoint = interpolationPoint;
        return this;
    }

    public InterpolationPoint getMinpoint() {
        return this.minpoint;
    }

    public GradientRule setMinpoint(InterpolationPoint interpolationPoint) {
        this.minpoint = interpolationPoint;
        return this;
    }

    public GradientRule set(String str, Object obj) {
        return (GradientRule) super.set(str, obj);
    }

    public GradientRule clone() {
        return (GradientRule) super.clone();
    }
}
