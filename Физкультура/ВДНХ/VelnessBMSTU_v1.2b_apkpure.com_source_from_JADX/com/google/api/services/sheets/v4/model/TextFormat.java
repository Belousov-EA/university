package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class TextFormat extends GenericJson {
    @Key
    private Boolean bold;
    @Key
    private String fontFamily;
    @Key
    private Integer fontSize;
    @Key
    private Color foregroundColor;
    @Key
    private Boolean italic;
    @Key
    private Boolean strikethrough;
    @Key
    private Boolean underline;

    public Boolean getBold() {
        return this.bold;
    }

    public TextFormat setBold(Boolean bool) {
        this.bold = bool;
        return this;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public TextFormat setFontFamily(String str) {
        this.fontFamily = str;
        return this;
    }

    public Integer getFontSize() {
        return this.fontSize;
    }

    public TextFormat setFontSize(Integer num) {
        this.fontSize = num;
        return this;
    }

    public Color getForegroundColor() {
        return this.foregroundColor;
    }

    public TextFormat setForegroundColor(Color color) {
        this.foregroundColor = color;
        return this;
    }

    public Boolean getItalic() {
        return this.italic;
    }

    public TextFormat setItalic(Boolean bool) {
        this.italic = bool;
        return this;
    }

    public Boolean getStrikethrough() {
        return this.strikethrough;
    }

    public TextFormat setStrikethrough(Boolean bool) {
        this.strikethrough = bool;
        return this;
    }

    public Boolean getUnderline() {
        return this.underline;
    }

    public TextFormat setUnderline(Boolean bool) {
        this.underline = bool;
        return this;
    }

    public TextFormat set(String str, Object obj) {
        return (TextFormat) super.set(str, obj);
    }

    public TextFormat clone() {
        return (TextFormat) super.clone();
    }
}
