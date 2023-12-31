package com.rtn.dto;

import javax.validation.constraints.Min;

import org.springframework.web.bind.annotation.RequestParam;

import com.rtn.contant.RtnCateGory;

public class RtnQueryParams {
	private RtnCateGory rtnCateGory;
	private String search;

	private String rtnDate;
	private String sort;

	private Integer limit;
	private Integer offset;

	public RtnCateGory getRtnCateGory() {
		return rtnCateGory;
	}

	public void setRtnCateGory(RtnCateGory rtnCateGory) {
		this.rtnCateGory = rtnCateGory;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getRtnDate() {
		return rtnDate;
	}

	public void setRtnDate(String rtnDate) {
		this.rtnDate = rtnDate;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
