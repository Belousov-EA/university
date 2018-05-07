package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class NamedRange extends GenericJson {
    @Key
    private String name;
    @Key
    private String namedRangeId;
    @Key
    private GridRange range;

    public String getName() {
        return this.name;
    }

    public NamedRange setName(String str) {
        this.name = str;
        return this;
    }

    public String getNamedRangeId() {
        return this.namedRangeId;
    }

    public NamedRange setNamedRangeId(String str) {
        this.namedRangeId = str;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public NamedRange setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public NamedRange set(String str, Object obj) {
        return (NamedRange) super.set(str, obj);
    }

    public NamedRange clone() {
        return (NamedRange) super.clone();
    }
}
