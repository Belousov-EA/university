package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class CellFormat extends GenericJson {
    @Key
    private Color backgroundColor;
    @Key
    private Borders borders;
    @Key
    private String horizontalAlignment;
    @Key
    private String hyperlinkDisplayType;
    @Key
    private NumberFormat numberFormat;
    @Key
    private Padding padding;
    @Key
    private String textDirection;
    @Key
    private TextFormat textFormat;
    @Key
    private TextRotation textRotation;
    @Key
    private String verticalAlignment;
    @Key
    private String wrapStrategy;

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public CellFormat setBackgroundColor(Color color) {
        this.backgroundColor = color;
        return this;
    }

    public Borders getBorders() {
        return this.borders;
    }

    public CellFormat setBorders(Borders borders) {
        this.borders = borders;
        return this;
    }

    public String getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public CellFormat setHorizontalAlignment(String str) {
        this.horizontalAlignment = str;
        return this;
    }

    public String getHyperlinkDisplayType() {
        return this.hyperlinkDisplayType;
    }

    public CellFormat setHyperlinkDisplayType(String str) {
        this.hyperlinkDisplayType = str;
        return this;
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    public CellFormat setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
        return this;
    }

    public Padding getPadding() {
        return this.padding;
    }

    public CellFormat setPadding(Padding padding) {
        this.padding = padding;
        return this;
    }

    public String getTextDirection() {
        return this.textDirection;
    }

    public CellFormat setTextDirection(String str) {
        this.textDirection = str;
        return this;
    }

    public TextFormat getTextFormat() {
        return this.textFormat;
    }

    public CellFormat setTextFormat(TextFormat textFormat) {
        this.textFormat = textFormat;
        return this;
    }

    public TextRotation getTextRotation() {
        return this.textRotation;
    }

    public CellFormat setTextRotation(TextRotation textRotation) {
        this.textRotation = textRotation;
        return this;
    }

    public String getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public CellFormat setVerticalAlignment(String str) {
        this.verticalAlignment = str;
        return this;
    }

    public String getWrapStrategy() {
        return this.wrapStrategy;
    }

    public CellFormat setWrapStrategy(String str) {
        this.wrapStrategy = str;
        return this;
    }

    public CellFormat set(String str, Object obj) {
        return (CellFormat) super.set(str, obj);
    }

    public CellFormat clone() {
        return (CellFormat) super.clone();
    }
}
