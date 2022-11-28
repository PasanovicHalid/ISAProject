package com.example.BloodBank.dto;

import com.example.BloodBank.model.FilterType;

public class PagableRequestDTO {
    private String sortDirection = "asc";
    private String sortColumn;
    private FilterType filterType;
    private String filter;
    private int pageIndex = 0;
    private int pageSize = 5;

    public PagableRequestDTO(String sortDirection, String sortColumn, FilterType filterType, String filter, int pageIndex, int pageSize) {
        this.sortDirection = sortDirection;
        this.sortColumn = sortColumn;
        this.filterType = filterType;
        this.filter = filter;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
