package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class UpdateBordersRequest extends GenericJson {
    @Key
    private Border bottom;
    @Key
    private Border innerHorizontal;
    @Key
    private Border innerVertical;
    @Key
    private Border left;
    @Key
    private GridRange range;
    @Key
    private Border right;
    @Key
    private Border top;

    public Border getBottom() {
        return this.bottom;
    }

    public UpdateBordersRequest setBottom(Border border) {
        this.bottom = border;
        return this;
    }

    public Border getInnerHorizontal() {
        return this.innerHorizontal;
    }

    public UpdateBordersRequest setInnerHorizontal(Border border) {
        this.innerHorizontal = border;
        return this;
    }

    public Border getInnerVertical() {
        return this.innerVertical;
    }

    public UpdateBordersRequest setInnerVertical(Border border) {
        this.innerVertical = border;
        return this;
    }

    public Border getLeft() {
        return this.left;
    }

    public UpdateBordersRequest setLeft(Border border) {
        this.left = border;
        return this;
    }

    public GridRange getRange() {
        return this.range;
    }

    public UpdateBordersRequest setRange(GridRange gridRange) {
        this.range = gridRange;
        return this;
    }

    public Border getRight() {
        return this.right;
    }

    public UpdateBordersRequest setRight(Border border) {
        this.right = border;
        return this;
    }

    public Border getTop() {
        return this.top;
    }

    public UpdateBordersRequest setTop(Border border) {
        this.top = border;
        return this;
    }

    public UpdateBordersRequest set(String str, Object obj) {
        return (UpdateBordersRequest) super.set(str, obj);
    }

    public UpdateBordersRequest clone() {
        return (UpdateBordersRequest) super.clone();
    }
}
