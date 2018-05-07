package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Response extends GenericJson {
    @Key
    private AddBandingResponse addBanding;
    @Key
    private AddChartResponse addChart;
    @Key
    private AddFilterViewResponse addFilterView;
    @Key
    private AddNamedRangeResponse addNamedRange;
    @Key
    private AddProtectedRangeResponse addProtectedRange;
    @Key
    private AddSheetResponse addSheet;
    @Key
    private CreateDeveloperMetadataResponse createDeveloperMetadata;
    @Key
    private DeleteConditionalFormatRuleResponse deleteConditionalFormatRule;
    @Key
    private DeleteDeveloperMetadataResponse deleteDeveloperMetadata;
    @Key
    private DuplicateFilterViewResponse duplicateFilterView;
    @Key
    private DuplicateSheetResponse duplicateSheet;
    @Key
    private FindReplaceResponse findReplace;
    @Key
    private UpdateConditionalFormatRuleResponse updateConditionalFormatRule;
    @Key
    private UpdateDeveloperMetadataResponse updateDeveloperMetadata;
    @Key
    private UpdateEmbeddedObjectPositionResponse updateEmbeddedObjectPosition;

    public AddBandingResponse getAddBanding() {
        return this.addBanding;
    }

    public Response setAddBanding(AddBandingResponse addBandingResponse) {
        this.addBanding = addBandingResponse;
        return this;
    }

    public AddChartResponse getAddChart() {
        return this.addChart;
    }

    public Response setAddChart(AddChartResponse addChartResponse) {
        this.addChart = addChartResponse;
        return this;
    }

    public AddFilterViewResponse getAddFilterView() {
        return this.addFilterView;
    }

    public Response setAddFilterView(AddFilterViewResponse addFilterViewResponse) {
        this.addFilterView = addFilterViewResponse;
        return this;
    }

    public AddNamedRangeResponse getAddNamedRange() {
        return this.addNamedRange;
    }

    public Response setAddNamedRange(AddNamedRangeResponse addNamedRangeResponse) {
        this.addNamedRange = addNamedRangeResponse;
        return this;
    }

    public AddProtectedRangeResponse getAddProtectedRange() {
        return this.addProtectedRange;
    }

    public Response setAddProtectedRange(AddProtectedRangeResponse addProtectedRangeResponse) {
        this.addProtectedRange = addProtectedRangeResponse;
        return this;
    }

    public AddSheetResponse getAddSheet() {
        return this.addSheet;
    }

    public Response setAddSheet(AddSheetResponse addSheetResponse) {
        this.addSheet = addSheetResponse;
        return this;
    }

    public CreateDeveloperMetadataResponse getCreateDeveloperMetadata() {
        return this.createDeveloperMetadata;
    }

    public Response setCreateDeveloperMetadata(CreateDeveloperMetadataResponse createDeveloperMetadataResponse) {
        this.createDeveloperMetadata = createDeveloperMetadataResponse;
        return this;
    }

    public DeleteConditionalFormatRuleResponse getDeleteConditionalFormatRule() {
        return this.deleteConditionalFormatRule;
    }

    public Response setDeleteConditionalFormatRule(DeleteConditionalFormatRuleResponse deleteConditionalFormatRuleResponse) {
        this.deleteConditionalFormatRule = deleteConditionalFormatRuleResponse;
        return this;
    }

    public DeleteDeveloperMetadataResponse getDeleteDeveloperMetadata() {
        return this.deleteDeveloperMetadata;
    }

    public Response setDeleteDeveloperMetadata(DeleteDeveloperMetadataResponse deleteDeveloperMetadataResponse) {
        this.deleteDeveloperMetadata = deleteDeveloperMetadataResponse;
        return this;
    }

    public DuplicateFilterViewResponse getDuplicateFilterView() {
        return this.duplicateFilterView;
    }

    public Response setDuplicateFilterView(DuplicateFilterViewResponse duplicateFilterViewResponse) {
        this.duplicateFilterView = duplicateFilterViewResponse;
        return this;
    }

    public DuplicateSheetResponse getDuplicateSheet() {
        return this.duplicateSheet;
    }

    public Response setDuplicateSheet(DuplicateSheetResponse duplicateSheetResponse) {
        this.duplicateSheet = duplicateSheetResponse;
        return this;
    }

    public FindReplaceResponse getFindReplace() {
        return this.findReplace;
    }

    public Response setFindReplace(FindReplaceResponse findReplaceResponse) {
        this.findReplace = findReplaceResponse;
        return this;
    }

    public UpdateConditionalFormatRuleResponse getUpdateConditionalFormatRule() {
        return this.updateConditionalFormatRule;
    }

    public Response setUpdateConditionalFormatRule(UpdateConditionalFormatRuleResponse updateConditionalFormatRuleResponse) {
        this.updateConditionalFormatRule = updateConditionalFormatRuleResponse;
        return this;
    }

    public UpdateDeveloperMetadataResponse getUpdateDeveloperMetadata() {
        return this.updateDeveloperMetadata;
    }

    public Response setUpdateDeveloperMetadata(UpdateDeveloperMetadataResponse updateDeveloperMetadataResponse) {
        this.updateDeveloperMetadata = updateDeveloperMetadataResponse;
        return this;
    }

    public UpdateEmbeddedObjectPositionResponse getUpdateEmbeddedObjectPosition() {
        return this.updateEmbeddedObjectPosition;
    }

    public Response setUpdateEmbeddedObjectPosition(UpdateEmbeddedObjectPositionResponse updateEmbeddedObjectPositionResponse) {
        this.updateEmbeddedObjectPosition = updateEmbeddedObjectPositionResponse;
        return this;
    }

    public Response set(String str, Object obj) {
        return (Response) super.set(str, obj);
    }

    public Response clone() {
        return (Response) super.clone();
    }
}
