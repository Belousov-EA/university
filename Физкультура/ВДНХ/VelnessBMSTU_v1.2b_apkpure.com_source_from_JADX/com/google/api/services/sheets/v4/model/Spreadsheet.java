package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class Spreadsheet extends GenericJson {
    @Key
    private List<DeveloperMetadata> developerMetadata;
    @Key
    private List<NamedRange> namedRanges;
    @Key
    private SpreadsheetProperties properties;
    @Key
    private List<Sheet> sheets;
    @Key
    private String spreadsheetId;
    @Key
    private String spreadsheetUrl;

    static {
        Data.nullOf(DeveloperMetadata.class);
        Data.nullOf(Sheet.class);
    }

    public List<DeveloperMetadata> getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public Spreadsheet setDeveloperMetadata(List<DeveloperMetadata> list) {
        this.developerMetadata = list;
        return this;
    }

    public List<NamedRange> getNamedRanges() {
        return this.namedRanges;
    }

    public Spreadsheet setNamedRanges(List<NamedRange> list) {
        this.namedRanges = list;
        return this;
    }

    public SpreadsheetProperties getProperties() {
        return this.properties;
    }

    public Spreadsheet setProperties(SpreadsheetProperties spreadsheetProperties) {
        this.properties = spreadsheetProperties;
        return this;
    }

    public List<Sheet> getSheets() {
        return this.sheets;
    }

    public Spreadsheet setSheets(List<Sheet> list) {
        this.sheets = list;
        return this;
    }

    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    public Spreadsheet setSpreadsheetId(String str) {
        this.spreadsheetId = str;
        return this;
    }

    public String getSpreadsheetUrl() {
        return this.spreadsheetUrl;
    }

    public Spreadsheet setSpreadsheetUrl(String str) {
        this.spreadsheetUrl = str;
        return this;
    }

    public Spreadsheet set(String str, Object obj) {
        return (Spreadsheet) super.set(str, obj);
    }

    public Spreadsheet clone() {
        return (Spreadsheet) super.clone();
    }
}
