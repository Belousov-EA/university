package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class ManualRule extends GenericJson {
    @Key
    private List<ManualRuleGroup> groups;

    public List<ManualRuleGroup> getGroups() {
        return this.groups;
    }

    public ManualRule setGroups(List<ManualRuleGroup> list) {
        this.groups = list;
        return this;
    }

    public ManualRule set(String str, Object obj) {
        return (ManualRule) super.set(str, obj);
    }

    public ManualRule clone() {
        return (ManualRule) super.clone();
    }
}
