package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class FindReplaceResponse extends GenericJson {
    @Key
    private Integer formulasChanged;
    @Key
    private Integer occurrencesChanged;
    @Key
    private Integer rowsChanged;
    @Key
    private Integer sheetsChanged;
    @Key
    private Integer valuesChanged;

    public Integer getFormulasChanged() {
        return this.formulasChanged;
    }

    public FindReplaceResponse setFormulasChanged(Integer num) {
        this.formulasChanged = num;
        return this;
    }

    public Integer getOccurrencesChanged() {
        return this.occurrencesChanged;
    }

    public FindReplaceResponse setOccurrencesChanged(Integer num) {
        this.occurrencesChanged = num;
        return this;
    }

    public Integer getRowsChanged() {
        return this.rowsChanged;
    }

    public FindReplaceResponse setRowsChanged(Integer num) {
        this.rowsChanged = num;
        return this;
    }

    public Integer getSheetsChanged() {
        return this.sheetsChanged;
    }

    public FindReplaceResponse setSheetsChanged(Integer num) {
        this.sheetsChanged = num;
        return this;
    }

    public Integer getValuesChanged() {
        return this.valuesChanged;
    }

    public FindReplaceResponse setValuesChanged(Integer num) {
        this.valuesChanged = num;
        return this;
    }

    public FindReplaceResponse set(String str, Object obj) {
        return (FindReplaceResponse) super.set(str, obj);
    }

    public FindReplaceResponse clone() {
        return (FindReplaceResponse) super.clone();
    }
}
