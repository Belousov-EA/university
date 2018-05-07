package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class DeleteConditionalFormatRuleResponse extends GenericJson {
    @Key
    private ConditionalFormatRule rule;

    public ConditionalFormatRule getRule() {
        return this.rule;
    }

    public DeleteConditionalFormatRuleResponse setRule(ConditionalFormatRule conditionalFormatRule) {
        this.rule = conditionalFormatRule;
        return this;
    }

    public DeleteConditionalFormatRuleResponse set(String str, Object obj) {
        return (DeleteConditionalFormatRuleResponse) super.set(str, obj);
    }

    public DeleteConditionalFormatRuleResponse clone() {
        return (DeleteConditionalFormatRuleResponse) super.clone();
    }
}
