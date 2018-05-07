package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ClearBasicFilterRequest extends GenericJson {
    @Key
    private Integer sheetId;

    public Integer getSheetId() {
        return this.sheetId;
    }

    public ClearBasicFilterRequest setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public ClearBasicFilterRequest set(String str, Object obj) {
        return (ClearBasicFilterRequest) super.set(str, obj);
    }

    public ClearBasicFilterRequest clone() {
        return (ClearBasicFilterRequest) super.clone();
    }
}
