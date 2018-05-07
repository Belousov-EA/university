package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class ChartSourceRange extends GenericJson {
    @Key
    private List<GridRange> sources;

    static {
        Data.nullOf(GridRange.class);
    }

    public List<GridRange> getSources() {
        return this.sources;
    }

    public ChartSourceRange setSources(List<GridRange> list) {
        this.sources = list;
        return this;
    }

    public ChartSourceRange set(String str, Object obj) {
        return (ChartSourceRange) super.set(str, obj);
    }

    public ChartSourceRange clone() {
        return (ChartSourceRange) super.clone();
    }
}
