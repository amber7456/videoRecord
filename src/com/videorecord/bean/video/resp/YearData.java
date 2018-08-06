package com.videorecord.bean.video.resp;

import java.util.List;

public class YearData {

	private String year;

	private String countMsg;

	private List<SeasonBean> season;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCountMsg() {
		return countMsg;
	}

	public void setCountMsg(String countMsg) {
		this.countMsg = countMsg;
	}

	public List<SeasonBean> getSeason() {
		return season;
	}

	public void setSeason(List<SeasonBean> season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "YearData [year=" + year + ", countMsg=" + countMsg + ", season=" + season + "]";
	}

}
