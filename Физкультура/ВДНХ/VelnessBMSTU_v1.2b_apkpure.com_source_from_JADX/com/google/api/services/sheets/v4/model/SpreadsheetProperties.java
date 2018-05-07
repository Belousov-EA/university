package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SpreadsheetProperties extends GenericJson {
    @Key
    private String autoRecalc;
    @Key
    private CellFormat defaultFormat;
    @Key
    private IterativeCalculationSettings iterativeCalculationSettings;
    @Key
    private String locale;
    @Key
    private String timeZone;
    @Key
    private String title;

    public String getAutoRecalc() {
        return this.autoRecalc;
    }

    public SpreadsheetProperties setAutoRecalc(String str) {
        this.autoRecalc = str;
        return this;
    }

    public CellFormat getDefaultFormat() {
        return this.defaultFormat;
    }

    public SpreadsheetProperties setDefaultFormat(CellFormat cellFormat) {
        this.defaultFormat = cellFormat;
        return this;
    }

    public IterativeCalculationSettings getIterativeCalculationSettings() {
        return this.iterativeCalculationSettings;
    }

    public SpreadsheetProperties setIterativeCalculationSettings(IterativeCalculationSettings iterativeCalculationSettings) {
        this.iterativeCalculationSettings = iterativeCalculationSettings;
        return this;
    }

    public String getLocale() {
        return this.locale;
    }

    public SpreadsheetProperties setLocale(String str) {
        this.locale = str;
        return this;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public SpreadsheetProperties setTimeZone(String str) {
        this.timeZone = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public SpreadsheetProperties setTitle(String str) {
        this.title = str;
        return this;
    }

    public SpreadsheetProperties set(String str, Object obj) {
        return (SpreadsheetProperties) super.set(str, obj);
    }

    public SpreadsheetProperties clone() {
        return (SpreadsheetProperties) super.clone();
    }
}
