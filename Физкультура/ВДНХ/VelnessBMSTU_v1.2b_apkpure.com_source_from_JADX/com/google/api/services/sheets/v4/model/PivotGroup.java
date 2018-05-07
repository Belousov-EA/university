package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class PivotGroup extends GenericJson {
    @Key
    private PivotGroupRule groupRule;
    @Key
    private String label;
    @Key
    private Boolean repeatHeadings;
    @Key
    private Boolean showTotals;
    @Key
    private String sortOrder;
    @Key
    private Integer sourceColumnOffset;
    @Key
    private PivotGroupSortValueBucket valueBucket;
    @Key
    private List<PivotGroupValueMetadata> valueMetadata;

    static {
        Data.nullOf(PivotGroupValueMetadata.class);
    }

    public PivotGroupRule getGroupRule() {
        return this.groupRule;
    }

    public PivotGroup setGroupRule(PivotGroupRule pivotGroupRule) {
        this.groupRule = pivotGroupRule;
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public PivotGroup setLabel(String str) {
        this.label = str;
        return this;
    }

    public Boolean getRepeatHeadings() {
        return this.repeatHeadings;
    }

    public PivotGroup setRepeatHeadings(Boolean bool) {
        this.repeatHeadings = bool;
        return this;
    }

    public Boolean getShowTotals() {
        return this.showTotals;
    }

    public PivotGroup setShowTotals(Boolean bool) {
        this.showTotals = bool;
        return this;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public PivotGroup setSortOrder(String str) {
        this.sortOrder = str;
        return this;
    }

    public Integer getSourceColumnOffset() {
        return this.sourceColumnOffset;
    }

    public PivotGroup setSourceColumnOffset(Integer num) {
        this.sourceColumnOffset = num;
        return this;
    }

    public PivotGroupSortValueBucket getValueBucket() {
        return this.valueBucket;
    }

    public PivotGroup setValueBucket(PivotGroupSortValueBucket pivotGroupSortValueBucket) {
        this.valueBucket = pivotGroupSortValueBucket;
        return this;
    }

    public List<PivotGroupValueMetadata> getValueMetadata() {
        return this.valueMetadata;
    }

    public PivotGroup setValueMetadata(List<PivotGroupValueMetadata> list) {
        this.valueMetadata = list;
        return this;
    }

    public PivotGroup set(String str, Object obj) {
        return (PivotGroup) super.set(str, obj);
    }

    public PivotGroup clone() {
        return (PivotGroup) super.clone();
    }
}
