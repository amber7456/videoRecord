package com.videorecord.bean.video;

import java.util.List;

public class AnimationListBean {

	private List<YearData> yearData;

	public List<YearData> getYearData() {
		return yearData;
	}

	public void setYearData(List<YearData> yearData) {
		this.yearData = yearData;
	}

	@Override
	public String toString() {
		return "AnimationListBean [yearData=" + yearData + "]";
	}

}
