package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class OverlayPosition extends GenericJson {
    @Key
    private GridCoordinate anchorCell;
    @Key
    private Integer heightPixels;
    @Key
    private Integer offsetXPixels;
    @Key
    private Integer offsetYPixels;
    @Key
    private Integer widthPixels;

    public GridCoordinate getAnchorCell() {
        return this.anchorCell;
    }

    public OverlayPosition setAnchorCell(GridCoordinate gridCoordinate) {
        this.anchorCell = gridCoordinate;
        return this;
    }

    public Integer getHeightPixels() {
        return this.heightPixels;
    }

    public OverlayPosition setHeightPixels(Integer num) {
        this.heightPixels = num;
        return this;
    }

    public Integer getOffsetXPixels() {
        return this.offsetXPixels;
    }

    public OverlayPosition setOffsetXPixels(Integer num) {
        this.offsetXPixels = num;
        return this;
    }

    public Integer getOffsetYPixels() {
        return this.offsetYPixels;
    }

    public OverlayPosition setOffsetYPixels(Integer num) {
        this.offsetYPixels = num;
        return this;
    }

    public Integer getWidthPixels() {
        return this.widthPixels;
    }

    public OverlayPosition setWidthPixels(Integer num) {
        this.widthPixels = num;
        return this;
    }

    public OverlayPosition set(String str, Object obj) {
        return (OverlayPosition) super.set(str, obj);
    }

    public OverlayPosition clone() {
        return (OverlayPosition) super.clone();
    }
}
