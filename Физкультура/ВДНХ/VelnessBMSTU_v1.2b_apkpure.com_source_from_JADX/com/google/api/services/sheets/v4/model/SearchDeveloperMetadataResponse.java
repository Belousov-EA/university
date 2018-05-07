package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class SearchDeveloperMetadataResponse extends GenericJson {
    @Key
    private List<MatchedDeveloperMetadata> matchedDeveloperMetadata;

    static {
        Data.nullOf(MatchedDeveloperMetadata.class);
    }

    public List<MatchedDeveloperMetadata> getMatchedDeveloperMetadata() {
        return this.matchedDeveloperMetadata;
    }

    public SearchDeveloperMetadataResponse setMatchedDeveloperMetadata(List<MatchedDeveloperMetadata> list) {
        this.matchedDeveloperMetadata = list;
        return this;
    }

    public SearchDeveloperMetadataResponse set(String str, Object obj) {
        return (SearchDeveloperMetadataResponse) super.set(str, obj);
    }

    public SearchDeveloperMetadataResponse clone() {
        return (SearchDeveloperMetadataResponse) super.clone();
    }
}
