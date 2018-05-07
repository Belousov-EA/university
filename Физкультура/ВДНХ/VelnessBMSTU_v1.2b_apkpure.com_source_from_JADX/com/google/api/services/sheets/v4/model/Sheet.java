package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class Sheet extends GenericJson {
    @Key
    private List<BandedRange> bandedRanges;
    @Key
    private BasicFilter basicFilter;
    @Key
    private List<EmbeddedChart> charts;
    @Key
    private List<ConditionalFormatRule> conditionalFormats;
    @Key
    private List<GridData> data;
    @Key
    private List<DeveloperMetadata> developerMetadata;
    @Key
    private List<FilterView> filterViews;
    @Key
    private List<GridRange> merges;
    @Key
    private SheetProperties properties;
    @Key
    private List<ProtectedRange> protectedRanges;

    public List<BandedRange> getBandedRanges() {
        return this.bandedRanges;
    }

    public Sheet setBandedRanges(List<BandedRange> list) {
        this.bandedRanges = list;
        return this;
    }

    public BasicFilter getBasicFilter() {
        return this.basicFilter;
    }

    public Sheet setBasicFilter(BasicFilter basicFilter) {
        this.basicFilter = basicFilter;
        return this;
    }

    public List<EmbeddedChart> getCharts() {
        return this.charts;
    }

    public Sheet setCharts(List<EmbeddedChart> list) {
        this.charts = list;
        return this;
    }

    public List<ConditionalFormatRule> getConditionalFormats() {
        return this.conditionalFormats;
    }

    public Sheet setConditionalFormats(List<ConditionalFormatRule> list) {
        this.conditionalFormats = list;
        return this;
    }

    public List<GridData> getData() {
        return this.data;
    }

    public Sheet setData(List<GridData> list) {
        this.data = list;
        return this;
    }

    public List<DeveloperMetadata> getDeveloperMetadata() {
        return this.developerMetadata;
    }

    public Sheet setDeveloperMetadata(List<DeveloperMetadata> list) {
        this.developerMetadata = list;
        return this;
    }

    public List<FilterView> getFilterViews() {
        return this.filterViews;
    }

    public Sheet setFilterViews(List<FilterView> list) {
        this.filterViews = list;
        return this;
    }

    public List<GridRange> getMerges() {
        return this.merges;
    }

    public Sheet setMerges(List<GridRange> list) {
        this.merges = list;
        return this;
    }

    public SheetProperties getProperties() {
        return this.properties;
    }

    public Sheet setProperties(SheetProperties sheetProperties) {
        this.properties = sheetProperties;
        return this;
    }

    public List<ProtectedRange> getProtectedRanges() {
        return this.protectedRanges;
    }

    public Sheet setProtectedRanges(List<ProtectedRange> list) {
        this.protectedRanges = list;
        return this;
    }

    public Sheet set(String str, Object obj) {
        return (Sheet) super.set(str, obj);
    }

    public Sheet clone() {
        return (Sheet) super.clone();
    }
}
