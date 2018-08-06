package com.videorecord.bean.disk;

import com.videorecord.mybatis.pojo.DiskInfo;

public class DiskReqBean extends DiskInfo {

	private Integer page;
	private Integer limit;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "DiskReqBean [page=" + page + ", limit=" + limit + ", toString()=" + super.toString() + "]";
	}

}
