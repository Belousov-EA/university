package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateConditionalFormatRuleRequest extends GenericJson {
    @Key
    private Integer index;
    @Key
    private Integer newIndex;
    @Key
    private ConditionalFormatRule rule;
    @Key
    private Integer sheetId;

    public Integer getIndex() {
        return this.index;
    }

    public UpdateConditionalFormatRuleRequest setIndex(Integer num) {
        this.index = num;
        return this;
    }

    public Integer getNewIndex() {
        return this.newIndex;
    }

    public UpdateConditionalFormatRuleRequest setNewIndex(Integer num) {
        this.newIndex = num;
        return this;
    }

    public ConditionalFormatRule getRule() {
        return this.rule;
    }

    public UpdateConditionalFormatRuleRequest setRule(ConditionalFormatRule conditionalFormatRule) {
        this.rule = conditionalFormatRule;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public UpdateConditionalFormatRuleRequest setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public UpdateConditionalFormatRuleRequest set(String str, Object obj) {
        return (UpdateConditionalFormatRuleRequest) super.set(str, obj);
    }

    public UpdateConditionalFormatRuleRequest clone() {
        return (UpdateConditionalFormatRuleRequest) super.clone();
    }
}
