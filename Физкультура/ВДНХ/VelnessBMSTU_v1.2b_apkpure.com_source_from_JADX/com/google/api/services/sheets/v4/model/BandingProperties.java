package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class BandingProperties extends GenericJson {
    @Key
    private Color firstBandColor;
    @Key
    private Color footerColor;
    @Key
    private Color headerColor;
    @Key
    private Color secondBandColor;

    public Color getFirstBandColor() {
        return this.firstBandColor;
    }

    public BandingProperties setFirstBandColor(Color color) {
        this.firstBandColor = color;
        return this;
    }

    public Color getFooterColor() {
        return this.footerColor;
    }

    public BandingProperties setFooterColor(Color color) {
        this.footerColor = color;
        return this;
    }

    public Color getHeaderColor() {
        return this.headerColor;
    }

    public BandingProperties setHeaderColor(Color color) {
        this.headerColor = color;
        return this;
    }

    public Color getSecondBandColor() {
        return this.secondBandColor;
    }

    public BandingProperties setSecondBandColor(Color color) {
        this.secondBandColor = color;
        return this;
    }

    public BandingProperties set(String str, Object obj) {
        return (BandingProperties) super.set(str, obj);
    }

    public BandingProperties clone() {
        return (BandingProperties) super.clone();
    }
}
