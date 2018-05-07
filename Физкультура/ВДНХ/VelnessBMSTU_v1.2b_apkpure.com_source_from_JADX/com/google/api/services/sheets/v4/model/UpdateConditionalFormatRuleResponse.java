package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateConditionalFormatRuleResponse extends GenericJson {
    @Key
    private Integer newIndex;
    @Key
    private ConditionalFormatRule newRule;
    @Key
    private Integer oldIndex;
    @Key
    private ConditionalFormatRule oldRule;

    public Integer getNewIndex() {
        return this.newIndex;
    }

    public UpdateConditionalFormatRuleResponse setNewIndex(Integer num) {
        this.newIndex = num;
        return this;
    }

    public ConditionalFormatRule getNewRule() {
        return this.newRule;
    }

    public UpdateConditionalFormatRuleResponse setNewRule(ConditionalFormatRule conditionalFormatRule) {
        this.newRule = conditionalFormatRule;
        return this;
    }

    public Integer getOldIndex() {
        return this.oldIndex;
    }

    public UpdateConditionalFormatRuleResponse setOldIndex(Integer num) {
        this.oldIndex = num;
        return this;
    }

    public ConditionalFormatRule getOldRule() {
        return this.oldRule;
    }

    public UpdateConditionalFormatRuleResponse setOldRule(ConditionalFormatRule conditionalFormatRule) {
        this.oldRule = conditionalFormatRule;
        return this;
    }

    public UpdateConditionalFormatRuleResponse set(String str, Object obj) {
        return (UpdateConditionalFormatRuleResponse) super.set(str, obj);
    }

    public UpdateConditionalFormatRuleResponse clone() {
        return (UpdateConditionalFormatRuleResponse) super.clone();
    }
}
