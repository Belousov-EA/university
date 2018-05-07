package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class ProtectedRange extends GenericJson {
    @Key
    private String description;
    @Key
    private Editors editors;
    @Key
    private String namedRangeId;
    @Key
    private Integer protectedRangeId;
    @Key
    private GridRange range;
    @Key
    private Boolean requestingUserCanEdit;
    @Key
    private List<GridRange> unprotectedRanges;
    @Key
    private Boolean warningOnly;

    static {
        Data.nullOf(GridRange.class);
    }

    public String getDescription() {
        return this.description;
    }

    public ProtectedRange setDescription(String str) {
        this.description = str;
        return this;
    }

    public Editors getEditors() {
        return this.editors;
    }

    public ProtectedRange setEditors(Editors editors) {
        this.editors = editors;
        return this;
    }

    public String getNamedRangeId() {
        return this.namedRangeId;
    }

    public ProtectedRange setNamedRangeId(String str) {
        this.namedRangeId = str;
        return this;
    }

    public Integer getProtectedRangeId() {
        return this.protectedRangeId;
    }

    public ProtectedRange setProtectedRangeId(Integer num) {
        this.protectedRangeId = num;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public ProtectedRange setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public Boolean getRequestingUserCanEdit() {
        return this.requestingUserCanEdit;
    }

    public ProtectedRange setRequestingUserCanEdit(Boolean bool) {
        this.requestingUserCanEdit = bool;
        return this;
    }

    public List<GridRange> getUnprotectedRanges() {
        return this.unprotectedRanges;
    }

    public ProtectedRange setUnprotectedRanges(List<GridRange> list) {
        this.unprotectedRanges = list;
        return this;
    }

    public Boolean getWarningOnly() {
        return this.warningOnly;
    }

    public ProtectedRange setWarningOnly(Boolean bool) {
        this.warningOnly = bool;
        return this;
    }

    public ProtectedRange set(String str, Object obj) {
        return (ProtectedRange) super.set(str, obj);
    }

    public ProtectedRange clone() {
        return (ProtectedRange) super.clone();
    }
}
