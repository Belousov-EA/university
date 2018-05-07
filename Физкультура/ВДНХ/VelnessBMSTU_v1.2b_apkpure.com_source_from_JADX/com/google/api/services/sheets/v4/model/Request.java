package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Request extends GenericJson {
    @Key
    private AddBandingRequest addBanding;
    @Key
    private AddChartRequest addChart;
    @Key
    private AddConditionalFormatRuleRequest addConditionalFormatRule;
    @Key
    private AddFilterViewRequest addFilterView;
    @Key
    private AddNamedRangeRequest addNamedRange;
    @Key
    private AddProtectedRangeRequest addProtectedRange;
    @Key
    private AddSheetRequest addSheet;
    @Key
    private AppendCellsRequest appendCells;
    @Key
    private AppendDimensionRequest appendDimension;
    @Key
    private AutoFillRequest autoFill;
    @Key
    private AutoResizeDimensionsRequest autoResizeDimensions;
    @Key
    private ClearBasicFilterRequest clearBasicFilter;
    @Key
    private CopyPasteRequest copyPaste;
    @Key
    private CreateDeveloperMetadataRequest createDeveloperMetadata;
    @Key
    private CutPasteRequest cutPaste;
    @Key
    private DeleteBandingRequest deleteBanding;
    @Key
    private DeleteConditionalFormatRuleRequest deleteConditionalFormatRule;
    @Key
    private DeleteDeveloperMetadataRequest deleteDeveloperMetadata;
    @Key
    private DeleteDimensionRequest deleteDimension;
    @Key
    private DeleteEmbeddedObjectRequest deleteEmbeddedObject;
    @Key
    private DeleteFilterViewRequest deleteFilterView;
    @Key
    private DeleteNamedRangeRequest deleteNamedRange;
    @Key
    private DeleteProtectedRangeRequest deleteProtectedRange;
    @Key
    private DeleteRangeRequest deleteRange;
    @Key
    private DeleteSheetRequest deleteSheet;
    @Key
    private DuplicateFilterViewRequest duplicateFilterView;
    @Key
    private DuplicateSheetRequest duplicateSheet;
    @Key
    private FindReplaceRequest findReplace;
    @Key
    private InsertDimensionRequest insertDimension;
    @Key
    private InsertRangeRequest insertRange;
    @Key
    private MergeCellsRequest mergeCells;
    @Key
    private MoveDimensionRequest moveDimension;
    @Key
    private PasteDataRequest pasteData;
    @Key
    private RandomizeRangeRequest randomizeRange;
    @Key
    private RepeatCellRequest repeatCell;
    @Key
    private SetBasicFilterRequest setBasicFilter;
    @Key
    private SetDataValidationRequest setDataValidation;
    @Key
    private SortRangeRequest sortRange;
    @Key
    private TextToColumnsRequest textToColumns;
    @Key
    private UnmergeCellsRequest unmergeCells;
    @Key
    private UpdateBandingRequest updateBanding;
    @Key
    private UpdateBordersRequest updateBorders;
    @Key
    private UpdateCellsRequest updateCells;
    @Key
    private UpdateChartSpecRequest updateChartSpec;
    @Key
    private UpdateConditionalFormatRuleRequest updateConditionalFormatRule;
    @Key
    private UpdateDeveloperMetadataRequest updateDeveloperMetadata;
    @Key
    private UpdateDimensionPropertiesRequest updateDimensionProperties;
    @Key
    private UpdateEmbeddedObjectPositionRequest updateEmbeddedObjectPosition;
    @Key
    private UpdateFilterViewRequest updateFilterView;
    @Key
    private UpdateNamedRangeRequest updateNamedRange;
    @Key
    private UpdateProtectedRangeRequest updateProtectedRange;
    @Key
    private UpdateSheetPropertiesRequest updateSheetProperties;
    @Key
    private UpdateSpreadsheetPropertiesRequest updateSpreadsheetProperties;

    public AddBandingRequest getAddBanding() {
        return this.addBanding;
    }

    public Request setAddBanding(AddBandingRequest addBandingRequest) {
        this.addBanding = addBandingRequest;
        return this;
    }

    public AddChartRequest getAddChart() {
        return this.addChart;
    }

    public Request setAddChart(AddChartRequest addChartRequest) {
        this.addChart = addChartRequest;
        return this;
    }

    public AddConditionalFormatRuleRequest getAddConditionalFormatRule() {
        return this.addConditionalFormatRule;
    }

    public Request setAddConditionalFormatRule(AddConditionalFormatRuleRequest addConditionalFormatRuleRequest) {
        this.addConditionalFormatRule = addConditionalFormatRuleRequest;
        return this;
    }

    public AddFilterViewRequest getAddFilterView() {
        return this.addFilterView;
    }

    public Request setAddFilterView(AddFilterViewRequest addFilterViewRequest) {
        this.addFilterView = addFilterViewRequest;
        return this;
    }

    public AddNamedRangeRequest getAddNamedRange() {
        return this.addNamedRange;
    }

    public Request setAddNamedRange(AddNamedRangeRequest addNamedRangeRequest) {
        this.addNamedRange = addNamedRangeRequest;
        return this;
    }

    public AddProtectedRangeRequest getAddProtectedRange() {
        return this.addProtectedRange;
    }

    public Request setAddProtectedRange(AddProtectedRangeRequest addProtectedRangeRequest) {
        this.addProtectedRange = addProtectedRangeRequest;
        return this;
    }

    public AddSheetRequest getAddSheet() {
        return this.addSheet;
    }

    public Request setAddSheet(AddSheetRequest addSheetRequest) {
        this.addSheet = addSheetRequest;
        return this;
    }

    public AppendCellsRequest getAppendCells() {
        return this.appendCells;
    }

    public Request setAppendCells(AppendCellsRequest appendCellsRequest) {
        this.appendCells = appendCellsRequest;
        return this;
    }

    public AppendDimensionRequest getAppendDimension() {
        return this.appendDimension;
    }

    public Request setAppendDimension(AppendDimensionRequest appendDimensionRequest) {
        this.appendDimension = appendDimensionRequest;
        return this;
    }

    public AutoFillRequest getAutoFill() {
        return this.autoFill;
    }

    public Request setAutoFill(AutoFillRequest autoFillRequest) {
        this.autoFill = autoFillRequest;
        return this;
    }

    public AutoResizeDimensionsRequest getAutoResizeDimensions() {
        return this.autoResizeDimensions;
    }

    public Request setAutoResizeDimensions(AutoResizeDimensionsRequest autoResizeDimensionsRequest) {
        this.autoResizeDimensions = autoResizeDimensionsRequest;
        return this;
    }

    public ClearBasicFilterRequest getClearBasicFilter() {
        return this.clearBasicFilter;
    }

    public Request setClearBasicFilter(ClearBasicFilterRequest clearBasicFilterRequest) {
        this.clearBasicFilter = clearBasicFilterRequest;
        return this;
    }

    public CopyPasteRequest getCopyPaste() {
        return this.copyPaste;
    }

    public Request setCopyPaste(CopyPasteRequest copyPasteRequest) {
        this.copyPaste = copyPasteRequest;
        return this;
    }

    public CreateDeveloperMetadataRequest getCreateDeveloperMetadata() {
        return this.createDeveloperMetadata;
    }

    public Request setCreateDeveloperMetadata(CreateDeveloperMetadataRequest createDeveloperMetadataRequest) {
        this.createDeveloperMetadata = createDeveloperMetadataRequest;
        return this;
    }

    public CutPasteRequest getCutPaste() {
        return this.cutPaste;
    }

    public Request setCutPaste(CutPasteRequest cutPasteRequest) {
        this.cutPaste = cutPasteRequest;
        return this;
    }

    public DeleteBandingRequest getDeleteBanding() {
        return this.deleteBanding;
    }

    public Request setDeleteBanding(DeleteBandingRequest deleteBandingRequest) {
        this.deleteBanding = deleteBandingRequest;
        return this;
    }

    public DeleteConditionalFormatRuleRequest getDeleteConditionalFormatRule() {
        return this.deleteConditionalFormatRule;
    }

    public Request setDeleteConditionalFormatRule(DeleteConditionalFormatRuleRequest deleteConditionalFormatRuleRequest) {
        this.deleteConditionalFormatRule = deleteConditionalFormatRuleRequest;
        return this;
    }

    public DeleteDeveloperMetadataRequest getDeleteDeveloperMetadata() {
        return this.deleteDeveloperMetadata;
    }

    public Request setDeleteDeveloperMetadata(DeleteDeveloperMetadataRequest deleteDeveloperMetadataRequest) {
        this.deleteDeveloperMetadata = deleteDeveloperMetadataRequest;
        return this;
    }

    public DeleteDimensionRequest getDeleteDimension() {
        return this.deleteDimension;
    }

    public Request setDeleteDimension(DeleteDimensionRequest deleteDimensionRequest) {
        this.deleteDimension = deleteDimensionRequest;
        return this;
    }

    public DeleteEmbeddedObjectRequest getDeleteEmbeddedObject() {
        return this.deleteEmbeddedObject;
    }

    public Request setDeleteEmbeddedObject(DeleteEmbeddedObjectRequest deleteEmbeddedObjectRequest) {
        this.deleteEmbeddedObject = deleteEmbeddedObjectRequest;
        return this;
    }

    public DeleteFilterViewRequest getDeleteFilterView() {
        return this.deleteFilterView;
    }

    public Request setDeleteFilterView(DeleteFilterViewRequest deleteFilterViewRequest) {
        this.deleteFilterView = deleteFilterViewRequest;
        return this;
    }

    public DeleteNamedRangeRequest getDeleteNamedRange() {
        return this.deleteNamedRange;
    }

    public Request setDeleteNamedRange(DeleteNamedRangeRequest deleteNamedRangeRequest) {
        this.deleteNamedRange = deleteNamedRangeRequest;
        return this;
    }

    public DeleteProtectedRangeRequest getDeleteProtectedRange() {
        return this.deleteProtectedRange;
    }

    public Request setDeleteProtectedRange(DeleteProtectedRangeRequest deleteProtectedRangeRequest) {
        this.deleteProtectedRange = deleteProtectedRangeRequest;
        return this;
    }

    public DeleteRangeRequest getDeleteRange() {
        return this.deleteRange;
    }

    public Request setDeleteRange(DeleteRangeRequest deleteRangeRequest) {
        this.deleteRange = deleteRangeRequest;
        return this;
    }

    public DeleteSheetRequest getDeleteSheet() {
        return this.deleteSheet;
    }

    public Request setDeleteSheet(DeleteSheetRequest deleteSheetRequest) {
        this.deleteSheet = deleteSheetRequest;
        return this;
    }

    public DuplicateFilterViewRequest getDuplicateFilterView() {
        return this.duplicateFilterView;
    }

    public Request setDuplicateFilterView(DuplicateFilterViewRequest duplicateFilterViewRequest) {
        this.duplicateFilterView = duplicateFilterViewRequest;
        return this;
    }

    public DuplicateSheetRequest getDuplicateSheet() {
        return this.duplicateSheet;
    }

    public Request setDuplicateSheet(DuplicateSheetRequest duplicateSheetRequest) {
        this.duplicateSheet = duplicateSheetRequest;
        return this;
    }

    public FindReplaceRequest getFindReplace() {
        return this.findReplace;
    }

    public Request setFindReplace(FindReplaceRequest findReplaceRequest) {
        this.findReplace = findReplaceRequest;
        return this;
    }

    public InsertDimensionRequest getInsertDimension() {
        return this.insertDimension;
    }

    public Request setInsertDimension(InsertDimensionRequest insertDimensionRequest) {
        this.insertDimension = insertDimensionRequest;
        return this;
    }

    public InsertRangeRequest getInsertRange() {
        return this.insertRange;
    }

    public Request setInsertRange(InsertRangeRequest insertRangeRequest) {
        this.insertRange = insertRangeRequest;
        return this;
    }

    public MergeCellsRequest getMergeCells() {
        return this.mergeCells;
    }

    public Request setMergeCells(MergeCellsRequest mergeCellsRequest) {
        this.mergeCells = mergeCellsRequest;
        return this;
    }

    public MoveDimensionRequest getMoveDimension() {
        return this.moveDimension;
    }

    public Request setMoveDimension(MoveDimensionRequest moveDimensionRequest) {
        this.moveDimension = moveDimensionRequest;
        return this;
    }

    public PasteDataRequest getPasteData() {
        return this.pasteData;
    }

    public Request setPasteData(PasteDataRequest pasteDataRequest) {
        this.pasteData = pasteDataRequest;
        return this;
    }

    public RandomizeRangeRequest getRandomizeRange() {
        return this.randomizeRange;
    }

    public Request setRandomizeRange(RandomizeRangeRequest randomizeRangeRequest) {
        this.randomizeRange = randomizeRangeRequest;
        return this;
    }

    public RepeatCellRequest getRepeatCell() {
        return this.repeatCell;
    }

    public Request setRepeatCell(RepeatCellRequest repeatCellRequest) {
        this.repeatCell = repeatCellRequest;
        return this;
    }

    public SetBasicFilterRequest getSetBasicFilter() {
        return this.setBasicFilter;
    }

    public Request setSetBasicFilter(SetBasicFilterRequest setBasicFilterRequest) {
        this.setBasicFilter = setBasicFilterRequest;
        return this;
    }

    public SetDataValidationRequest getSetDataValidation() {
        return this.setDataValidation;
    }

    public Request setSetDataValidation(SetDataValidationRequest setDataValidationRequest) {
        this.setDataValidation = setDataValidationRequest;
        return this;
    }

    public SortRangeRequest getSortRange() {
        return this.sortRange;
    }

    public Request setSortRange(SortRangeRequest sortRangeRequest) {
        this.sortRange = sortRangeRequest;
        return this;
    }

    public TextToColumnsRequest getTextToColumns() {
        return this.textToColumns;
    }

    public Request setTextToColumns(TextToColumnsRequest textToColumnsRequest) {
        this.textToColumns = textToColumnsRequest;
        return this;
    }

    public UnmergeCellsRequest getUnmergeCells() {
        return this.unmergeCells;
    }

    public Request setUnmergeCells(UnmergeCellsRequest unmergeCellsRequest) {
        this.unmergeCells = unmergeCellsRequest;
        return this;
    }

    public UpdateBandingRequest getUpdateBanding() {
        return this.updateBanding;
    }

    public Request setUpdateBanding(UpdateBandingRequest updateBandingRequest) {
        this.updateBanding = updateBandingRequest;
        return this;
    }

    public UpdateBordersRequest getUpdateBorders() {
        return this.updateBorders;
    }

    public Request setUpdateBorders(UpdateBordersRequest updateBordersRequest) {
        this.updateBorders = updateBordersRequest;
        return this;
    }

    public UpdateCellsRequest getUpdateCells() {
        return this.updateCells;
    }

    public Request setUpdateCells(UpdateCellsRequest updateCellsRequest) {
        this.updateCells = updateCellsRequest;
        return this;
    }

    public UpdateChartSpecRequest getUpdateChartSpec() {
        return this.updateChartSpec;
    }

    public Request setUpdateChartSpec(UpdateChartSpecRequest updateChartSpecRequest) {
        this.updateChartSpec = updateChartSpecRequest;
        return this;
    }

    public UpdateConditionalFormatRuleRequest getUpdateConditionalFormatRule() {
        return this.updateConditionalFormatRule;
    }

    public Request setUpdateConditionalFormatRule(UpdateConditionalFormatRuleRequest updateConditionalFormatRuleRequest) {
        this.updateConditionalFormatRule = updateConditionalFormatRuleRequest;
        return this;
    }

    public UpdateDeveloperMetadataRequest getUpdateDeveloperMetadata() {
        return this.updateDeveloperMetadata;
    }

    public Request setUpdateDeveloperMetadata(UpdateDeveloperMetadataRequest updateDeveloperMetadataRequest) {
        this.updateDeveloperMetadata = updateDeveloperMetadataRequest;
        return this;
    }

    public UpdateDimensionPropertiesRequest getUpdateDimensionProperties() {
        return this.updateDimensionProperties;
    }

    public Request setUpdateDimensionProperties(UpdateDimensionPropertiesRequest updateDimensionPropertiesRequest) {
        this.updateDimensionProperties = updateDimensionPropertiesRequest;
        return this;
    }

    public UpdateEmbeddedObjectPositionRequest getUpdateEmbeddedObjectPosition() {
        return this.updateEmbeddedObjectPosition;
    }

    public Request setUpdateEmbeddedObjectPosition(UpdateEmbeddedObjectPositionRequest updateEmbeddedObjectPositionRequest) {
        this.updateEmbeddedObjectPosition = updateEmbeddedObjectPositionRequest;
        return this;
    }

    public UpdateFilterViewRequest getUpdateFilterView() {
        return this.updateFilterView;
    }

    public Request setUpdateFilterView(UpdateFilterViewRequest updateFilterViewRequest) {
        this.updateFilterView = updateFilterViewRequest;
        return this;
    }

    public UpdateNamedRangeRequest getUpdateNamedRange() {
        return this.updateNamedRange;
    }

    public Request setUpdateNamedRange(UpdateNamedRangeRequest updateNamedRangeRequest) {
        this.updateNamedRange = updateNamedRangeRequest;
        return this;
    }

    public UpdateProtectedRangeRequest getUpdateProtectedRange() {
        return this.updateProtectedRange;
    }

    public Request setUpdateProtectedRange(UpdateProtectedRangeRequest updateProtectedRangeRequest) {
        this.updateProtectedRange = updateProtectedRangeRequest;
        return this;
    }

    public UpdateSheetPropertiesRequest getUpdateSheetProperties() {
        return this.updateSheetProperties;
    }

    public Request setUpdateSheetProperties(UpdateSheetPropertiesRequest updateSheetPropertiesRequest) {
        this.updateSheetProperties = updateSheetPropertiesRequest;
        return this;
    }

    public UpdateSpreadsheetPropertiesRequest getUpdateSpreadsheetProperties() {
        return this.updateSpreadsheetProperties;
    }

    public Request setUpdateSpreadsheetProperties(UpdateSpreadsheetPropertiesRequest updateSpreadsheetPropertiesRequest) {
        this.updateSpreadsheetProperties = updateSpreadsheetPropertiesRequest;
        return this;
    }

    public Request set(String str, Object obj) {
        return (Request) super.set(str, obj);
    }

    public Request clone() {
        return (Request) super.clone();
    }
}
