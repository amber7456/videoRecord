package com.videorecord.bean.chart;

import java.util.Arrays;

public class ChartData {

	private String key;

	private Integer[] arr;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer[] getArr() {
		return arr;
	}

	public void setArr(Integer[] arr) {
		this.arr = arr;
	}

	@Override
	public String toString() {
		return "DataList [key=" + key + ", arr=" + Arrays.toString(arr) + "]";
	}

}
