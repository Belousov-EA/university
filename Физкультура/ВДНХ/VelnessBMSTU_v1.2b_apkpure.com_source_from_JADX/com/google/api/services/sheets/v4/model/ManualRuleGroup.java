package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class ManualRuleGroup extends GenericJson {
    @Key
    private ExtendedValue groupName;
    @Key
    private List<ExtendedValue> items;

    static {
        Data.nullOf(ExtendedValue.class);
    }

    public ExtendedValue getGroupName() {
        return this.groupName;
    }

    public ManualRuleGroup setGroupName(ExtendedValue extendedValue) {
        this.groupName = extendedValue;
        return this;
    }

    public List<ExtendedValue> getItems() {
        return this.items;
    }

    public ManualRuleGroup setItems(List<ExtendedValue> list) {
        this.items = list;
        return this;
    }

    public ManualRuleGroup set(String str, Object obj) {
        return (ManualRuleGroup) super.set(str, obj);
    }

    public ManualRuleGroup clone() {
        return (ManualRuleGroup) super.clone();
    }
}
