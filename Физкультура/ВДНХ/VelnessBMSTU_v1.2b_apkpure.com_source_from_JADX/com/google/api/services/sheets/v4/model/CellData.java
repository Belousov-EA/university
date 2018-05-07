package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class CellData extends GenericJson {
    @Key
    private DataValidationRule dataValidation;
    @Key
    private CellFormat effectiveFormat;
    @Key
    private ExtendedValue effectiveValue;
    @Key
    private String formattedValue;
    @Key
    private String hyperlink;
    @Key
    private String note;
    @Key
    private PivotTable pivotTable;
    @Key
    private List<TextFormatRun> textFormatRuns;
    @Key
    private CellFormat userEnteredFormat;
    @Key
    private ExtendedValue userEnteredValue;

    public DataValidationRule getDataValidation() {
        return this.dataValidation;
    }

    public CellData setDataValidation(DataValidationRule dataValidationRule) {
        this.dataValidation = dataValidationRule;
        return this;
    }

    public CellFormat getEffectiveFormat() {
        return this.effectiveFormat;
    }

    public CellData setEffectiveFormat(CellFormat cellFormat) {
        this.effectiveFormat = cellFormat;
        return this;
    }

    public ExtendedValue getEffectiveValue() {
        return this.effectiveValue;
    }

    public CellData setEffectiveValue(ExtendedValue extendedValue) {
        this.effectiveValue = extendedValue;
        return this;
    }

    public String getFormattedValue() {
        return this.formattedValue;
    }

    public CellData setFormattedValue(String str) {
        this.formattedValue = str;
        return this;
    }

    public String getHyperlink() {
        return this.hyperlink;
    }

    public CellData setHyperlink(String str) {
        this.hyperlink = str;
        return this;
    }

    public String getNote() {
        return this.note;
    }

    public CellData setNote(String str) {
        this.note = str;
        return this;
    }

    public PivotTable getPivotTable() {
        return this.pivotTable;
    }

    public CellData setPivotTable(PivotTable pivotTable) {
        this.pivotTable = pivotTable;
        return this;
    }

    public List<TextFormatRun> getTextFormatRuns() {
        return this.textFormatRuns;
    }

    public CellData setTextFormatRuns(List<TextFormatRun> list) {
        this.textFormatRuns = list;
        return this;
    }

    public CellFormat getUserEnteredFormat() {
        return this.userEnteredFormat;
    }

    public CellData setUserEnteredFormat(CellFormat cellFormat) {
        this.userEnteredFormat = cellFormat;
        return this;
    }

    public ExtendedValue getUserEnteredValue() {
        return this.userEnteredValue;
    }

    public CellData setUserEnteredValue(ExtendedValue extendedValue) {
        this.userEnteredValue = extendedValue;
        return this;
    }

    public CellData set(String str, Object obj) {
        return (CellData) super.set(str, obj);
    }

    public CellData clone() {
        return (CellData) super.clone();
    }
}
