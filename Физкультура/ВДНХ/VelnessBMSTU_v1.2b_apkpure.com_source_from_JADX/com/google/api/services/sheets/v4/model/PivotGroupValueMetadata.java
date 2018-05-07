package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PivotGroupValueMetadata extends GenericJson {
    @Key
    private Boolean collapsed;
    @Key
    private ExtendedValue value;

    public Boolean getCollapsed() {
        return this.collapsed;
    }

    public PivotGroupValueMetadata setCollapsed(Boolean bool) {
        this.collapsed = bool;
        return this;
    }

    public ExtendedValue getValue() {
        return this.value;
    }

    public PivotGroupValueMetadata setValue(ExtendedValue extendedValue) {
        this.value = extendedValue;
        return this;
    }

    public PivotGroupValueMetadata set(String str, Object obj) {
        return (PivotGroupValueMetadata) super.set(str, obj);
    }

    public PivotGroupValueMetadata clone() {
        return (PivotGroupValueMetadata) super.clone();
    }
}
