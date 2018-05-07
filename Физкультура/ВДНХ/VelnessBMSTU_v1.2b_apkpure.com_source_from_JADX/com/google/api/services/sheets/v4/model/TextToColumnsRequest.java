package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class TextToColumnsRequest extends GenericJson {
    @Key
    private String delimiter;
    @Key
    private String delimiterType;
    @Key
    private GridRange source;

    public String getDelimiter() {
        return this.delimiter;
    }

    public TextToColumnsRequest setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public String getDelimiterType() {
        return this.delimiterType;
    }

    public TextToColumnsRequest setDelimiterType(String str) {
        this.delimiterType = str;
        return this;
    }

    public GridRange getSource() {
        return this.source;
    }

    public TextToColumnsRequest setSource(GridRange gridRange) {
        this.source = gridRange;
        return this;
    }

    public TextToColumnsRequest set(String str, Object obj) {
        return (TextToColumnsRequest) super.set(str, obj);
    }

    public TextToColumnsRequest clone() {
        return (TextToColumnsRequest) super.clone();
    }
}
