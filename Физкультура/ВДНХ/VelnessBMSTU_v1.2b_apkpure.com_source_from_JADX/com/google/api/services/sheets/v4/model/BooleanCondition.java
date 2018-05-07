package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class BooleanCondition extends GenericJson {
    @Key
    private String type;
    @Key
    private List<ConditionValue> values;

    public String getType() {
        return this.type;
    }

    public BooleanCondition setType(String str) {
        this.type = str;
        return this;
    }

    public List<ConditionValue> getValues() {
        return this.values;
    }

    public BooleanCondition setValues(List<ConditionValue> list) {
        this.values = list;
        return this;
    }

    public BooleanCondition set(String str, Object obj) {
        return (BooleanCondition) super.set(str, obj);
    }

    public BooleanCondition clone() {
        return (BooleanCondition) super.clone();
    }
}
