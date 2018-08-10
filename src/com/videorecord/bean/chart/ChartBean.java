package com.videorecord.bean.chart;

import java.util.Arrays;
import java.util.List;

public class ChartBean {

	private String[] season;

	private List<ChartData> dataList;

	public List<ChartData> getDataList() {
		return dataList;
	}

	public String[] getSeason() {
		return season;
	}

	public void setSeason(String[] season) {
		this.season = season;
	}

	public void setDataList(List<ChartData> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "ChartBean [season=" + Arrays.toString(season) + ", dataList=" + dataList + "]";
	}

}
