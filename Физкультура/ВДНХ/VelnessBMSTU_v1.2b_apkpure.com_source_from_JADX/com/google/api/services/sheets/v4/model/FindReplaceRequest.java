package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class FindReplaceRequest extends GenericJson {
    @Key
    private Boolean allSheets;
    @Key
    private String find;
    @Key
    private Boolean includeFormulas;
    @Key
    private Boolean matchCase;
    @Key
    private Boolean matchEntireCell;
    @Key
    private GridRange range;
    @Key
    private String replacement;
    @Key
    private Boolean searchByRegex;
    @Key
    private Integer sheetId;

    public Boolean getAllSheets() {
        return this.allSheets;
    }

    public FindReplaceRequest setAllSheets(Boolean bool) {
        this.allSheets = bool;
        return this;
    }

    public String getFind() {
        return this.find;
    }

    public FindReplaceRequest setFind(String str) {
        this.find = str;
        return this;
    }

    public Boolean getIncludeFormulas() {
        return this.includeFormulas;
    }

    public FindReplaceRequest setIncludeFormulas(Boolean bool) {
        this.includeFormulas = bool;
        return this;
    }

    public Boolean getMatchCase() {
        return this.matchCase;
    }

    public FindReplaceRequest setMatchCase(Boolean bool) {
        this.matchCase = bool;
        return this;
    }

    public Boolean getMatchEntireCell() {
        return this.matchEntireCell;
    }

    public FindReplaceRequest setMatchEntireCell(Boolean bool) {
        this.matchEntireCell = bool;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public FindReplaceRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public String getReplacement() {
        return this.replacement;
    }

    public FindReplaceRequest setReplacement(String str) {
        this.replacement = str;
        return this;
    }

    public Boolean getSearchByRegex() {
        return this.searchByRegex;
    }

    public FindReplaceRequest setSearchByRegex(Boolean bool) {
        this.searchByRegex = bool;
        return this;
    }

    public Integer getSheetId() {
        return this.sheetId;
    }

    public FindReplaceRequest setSheetId(Integer num) {
        this.sheetId = num;
        return this;
    }

    public FindReplaceRequest set(String str, Object obj) {
        return (FindReplaceRequest) super.set(str, obj);
    }

    public FindReplaceRequest clone() {
        return (FindReplaceRequest) super.clone();
    }
}
