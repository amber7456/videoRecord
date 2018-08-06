package com.videorecord.bean.chart;

import java.util.List;

public class TrendBean {
	private List<DataList> dataList;

	public List<DataList> getDataList() {
		return dataList;
	}

	public void setDataList(List<DataList> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "TrendBean [dataList=" + dataList + "]";
	}

}
