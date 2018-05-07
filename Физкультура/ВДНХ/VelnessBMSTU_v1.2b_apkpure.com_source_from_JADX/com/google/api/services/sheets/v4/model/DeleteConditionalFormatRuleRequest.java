package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteConditionalFormatRuleRequest extends GenericJson {
    @Key
    private Integer index;
    @Key
    private Integer sheetId;

    public Integer getIndex() {
        return this.index;
    }

    public DeleteConditionalFormatRuleRequest setIndex(Integer num) {
        this.index = num;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public DeleteConditionalFormatRuleRequest setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public DeleteConditionalFormatRuleRequest set(String str, Object obj) {
        return (DeleteConditionalFormatRuleRequest) super.set(str, obj);
    }

    public DeleteConditionalFormatRuleRequest clone() {
        return (DeleteConditionalFormatRuleRequest) super.clone();
    }
}
