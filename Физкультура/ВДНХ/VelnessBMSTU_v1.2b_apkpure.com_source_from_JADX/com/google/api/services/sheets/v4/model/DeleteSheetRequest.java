package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteSheetRequest extends GenericJson {
    @Key
    private Integer sheetId;

    public Integer getSheetId() {
        return this.sheetId;
    }

    public DeleteSheetRequest setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public DeleteSheetRequest set(String str, Object obj) {
        return (DeleteSheetRequest) super.set(str, obj);
    }

    public DeleteSheetRequest clone() {
        return (DeleteSheetRequest) super.clone();
    }
}
