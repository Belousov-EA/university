package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class BasicChartSpec extends GenericJson {
    @Key
    private List<BasicChartAxis> axis;
    @Key
    private String chartType;
    @Key
    private String compareMode;
    @Key
    private List<BasicChartDomain> domains;
    @Key
    private Integer headerCount;
    @Key
    private Boolean interpolateNulls;
    @Key
    private String legendPosition;
    @Key
    private Boolean lineSmoothing;
    @Key
    private List<BasicChartSeries> series;
    @Key
    private String stackedType;
    @Key
    private Boolean threeDimensional;

    static {
        Data.nullOf(BasicChartDomain.class);
    }

    public List<BasicChartAxis> getAxis() {
        return this.axis;
    }

    public BasicChartSpec setAxis(List<BasicChartAxis> list) {
        this.axis = list;
        return this;
    }

    public String getChartType() {
        return this.chartType;
    }

    public BasicChartSpec setChartType(String str) {
        this.chartType = str;
        return this;
    }

    public String getCompareMode() {
        return this.compareMode;
    }

    public BasicChartSpec setCompareMode(String str) {
        this.compareMode = str;
        return this;
    }

    public List<BasicChartDomain> getDomains() {
        return this.domains;
    }

    public BasicChartSpec setDomains(List<BasicChartDomain> list) {
        this.domains = list;
        return this;
    }

    public Integer getHeaderCount() {
        return this.headerCount;
    }

    public BasicChartSpec setHeaderCount(Integer num) {
        this.headerCount = num;
        return this;
    }

    public Boolean getInterpolateNulls() {
        return this.interpolateNulls;
    }

    public BasicChartSpec setInterpolateNulls(Boolean bool) {
        this.interpolateNulls = bool;
        return this;
    }

    public String getLegendPosition() {
        return this.legendPosition;
    }

    public BasicChartSpec setLegendPosition(String str) {
        this.legendPosition = str;
        return this;
    }

    public Boolean getLineSmoothing() {
        return this.lineSmoothing;
    }

    public BasicChartSpec setLineSmoothing(Boolean bool) {
        this.lineSmoothing = bool;
        return this;
    }

    public List<BasicChartSeries> getSeries() {
        return this.series;
    }

    public BasicChartSpec setSeries(List<BasicChartSeries> list) {
        this.series = list;
        return this;
    }

    public String getStackedType() {
        return this.stackedType;
    }

    public BasicChartSpec setStackedType(String str) {
        this.stackedType = str;
        return this;
    }

    public Boolean getThreeDimensional() {
        return this.threeDimensional;
    }

    public BasicChartSpec setThreeDimensional(Boolean bool) {
        this.threeDimensional = bool;
        return this;
    }

    public BasicChartSpec set(String str, Object obj) {
        return (BasicChartSpec) super.set(str, obj);
    }

    public BasicChartSpec clone() {
        return (BasicChartSpec) super.clone();
    }
}
