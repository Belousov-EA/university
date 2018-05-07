package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class GridRange extends GenericJson {
    @Key
    private Integer endColumnIndex;
    @Key
    private Integer endRowIndex;
    @Key
    private Integer sheetId;
    @Key
    private Integer startColumnIndex;
    @Key
    private Integer startRowIndex;

    public Integer getEndColumnIndex() {
        return this.endColumnIndex;
    }

    public GridRange setEndColumnIndex(Integer num) {
        this.endColumnIndex = num;
        return this;
    }

    public Integer getEndRowIndex() {
        return this.endRowIndex;
    }

    public GridRange setEndRowIndex(Integer num) {
        this.endRowIndex = num;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public GridRange setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public Integer getStartColumnIndex() {
        return this.startColumnIndex;
    }

    public GridRange setStartColumnIndex(Integer num) {
        this.startColumnIndex = num;
        return this;
    }

    public Integer getStartRowIndex() {
        return this.startRowIndex;
    }

    public GridRange setStartRowIndex(Integer num) {
        this.startRowIndex = num;
        return this;
    }

    public GridRange set(String str, Object obj) {
        return (GridRange) super.set(str, obj);
    }

    public GridRange clone() {
        return (GridRange) super.clone();
    }
}
