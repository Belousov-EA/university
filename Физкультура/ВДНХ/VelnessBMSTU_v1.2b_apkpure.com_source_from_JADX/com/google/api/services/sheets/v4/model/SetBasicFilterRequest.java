package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SetBasicFilterRequest extends GenericJson {
    @Key
    private BasicFilter filter;

    public BasicFilter getFilter() {
        return this.filter;
    }

    public SetBasicFilterRequest setFilter(BasicFilter basicFilter) {
        this.filter = basicFilter;
        return this;
    }

    public SetBasicFilterRequest set(String str, Object obj) {
        return (SetBasicFilterRequest) super.set(str, obj);
    }

    public SetBasicFilterRequest clone() {
        return (SetBasicFilterRequest) super.clone();
    }
}
