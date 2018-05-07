package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ConditionValue extends GenericJson {
    @Key
    private String relativeDate;
    @Key
    private String userEnteredValue;

    public String getRelativeDate() {
        return this.relativeDate;
    }

    public ConditionValue setRelativeDate(String str) {
        this.relativeDate = str;
        return this;
    }

    public String getUserEnteredValue() {
        return this.userEnteredValue;
    }

    public ConditionValue setUserEnteredValue(String str) {
        this.userEnteredValue = str;
        return this;
    }

    public ConditionValue set(String str, Object obj) {
        return (ConditionValue) super.set(str, obj);
    }

    public ConditionValue clone() {
        return (ConditionValue) super.clone();
    }
}
