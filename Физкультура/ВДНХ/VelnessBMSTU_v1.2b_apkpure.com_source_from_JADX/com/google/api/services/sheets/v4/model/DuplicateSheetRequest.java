package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DuplicateSheetRequest extends GenericJson {
    @Key
    private Integer insertSheetIndex;
    @Key
    private Integer newSheetId;
    @Key
    private String newSheetName;
    @Key
    private Integer sourceSheetId;

    public Integer getInsertSheetIndex() {
        return this.insertSheetIndex;
    }

    public DuplicateSheetRequest setInsertSheetIndex(Integer num) {
        this.insertSheetIndex = num;
        return this;
    }

    public Integer getNewSheetId() {
        return this.newSheetId;
    }

    public DuplicateSheetRequest setNewSheetId(Integer num) {
        this.newSheetId = num;
        return this;
    }

    public String getNewSheetName() {
        return this.newSheetName;
    }

    public DuplicateSheetRequest setNewSheetName(String str) {
        this.newSheetName = str;
        return this;
    }

    public Integer getSourceSheetId() {
        return this.sourceSheetId;
    }

    public DuplicateSheetRequest setSourceSheetId(Integer num) {
        this.sourceSheetId = num;
        return this;
    }

    public DuplicateSheetRequest set(String str, Object obj) {
        return (DuplicateSheetRequest) super.set(str, obj);
    }

    public DuplicateSheetRequest clone() {
        return (DuplicateSheetRequest) super.clone();
    }
}
