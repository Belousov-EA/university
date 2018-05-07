package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SheetProperties extends GenericJson {
    @Key
    private GridProperties gridProperties;
    @Key
    private Boolean hidden;
    @Key
    private Integer index;
    @Key
    private Boolean rightToLeft;
    @Key
    private Integer sheetId;
    @Key
    private String sheetType;
    @Key
    private Color tabColor;
    @Key
    private String title;

    public GridProperties getGridProperties() {
        return this.gridProperties;
    }

    public SheetProperties setGridProperties(GridProperties gridProperties) {
        this.gridProperties = gridProperties;
        return this;
    }

    public Boolean getHidden() {
        return this.hidden;
    }

    public SheetProperties setHidden(Boolean bool) {
        this.hidden = bool;
        return this;
    }

    public Integer getIndex() {
        return this.index;
    }

    public SheetProperties setIndex(Integer num) {
        this.index = num;
        return this;
    }

    public Boolean getRightToLeft() {
        return this.rightToLeft;
    }

    public SheetProperties setRightToLeft(Boolean bool) {
        this.rightToLeft = bool;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public SheetProperties setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public String getSheetType() {
        return this.sheetType;
    }

    public SheetProperties setSheetType(String str) {
        this.sheetType = str;
        return this;
    }

    public Color getTabColor() {
        return this.tabColor;
    }

    public SheetProperties setTabColor(Color color) {
        this.tabColor = color;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public SheetProperties setTitle(String str) {
        this.title = str;
        return this;
    }

    public SheetProperties set(String str, Object obj) {
        return (SheetProperties) super.set(str, obj);
    }

    public SheetProperties clone() {
        return (SheetProperties) super.clone();
    }
}
