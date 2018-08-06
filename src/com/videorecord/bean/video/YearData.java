package com.videorecord.bean.video;

import java.util.List;

public class YearData {

	private String year;

	private String countMsg;

	private List<GroupBean> group;

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

	public List<GroupBean> getGroup() {
		return group;
	}

	public void setGroup(List<GroupBean> group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "YearData [year=" + year + ", countMsg=" + countMsg + ", group=" + group + "]";
	}

}
