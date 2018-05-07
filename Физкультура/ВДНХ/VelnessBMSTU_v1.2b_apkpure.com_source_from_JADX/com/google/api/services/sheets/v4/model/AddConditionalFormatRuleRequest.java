package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class AddConditionalFormatRuleRequest extends GenericJson {
    @Key
    private Integer index;
    @Key
    private ConditionalFormatRule rule;

    public Integer getIndex() {
        return this.index;
    }

    public AddConditionalFormatRuleRequest setIndex(Integer num) {
        this.index = num;
        return this;
    }

    public ConditionalFormatRule getRule() {
        return this.rule;
    }

    public AddConditionalFormatRuleRequest setRule(ConditionalFormatRule conditionalFormatRule) {
        this.rule = conditionalFormatRule;
        return this;
    }

    public AddConditionalFormatRuleRequest set(String str, Object obj) {
        return (AddConditionalFormatRuleRequest) super.set(str, obj);
    }

    public AddConditionalFormatRuleRequest clone() {
        return (AddConditionalFormatRuleRequest) super.clone();
    }
}
