package com.videorecord.bean.video;

import com.videorecord.mybatis.pojo.VideoInfo;

public class VideoReqBean extends VideoInfo {

	private String yearRange;
	private String serializeTime;
	private String resource_record_address;
	private String resource_resolution;
	private String resource_sub;
	private String resource_sub_type;
	private String resource_format;
	private String resource_type;

	private String year;

	private Integer page;
	private Integer limit;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

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

	public String getYearRange() {
		return yearRange;
	}

	public void setYearRange(String yearRange) {
		this.yearRange = yearRange;
	}

	public String getSerializeTime() {
		return serializeTime;
	}

	public void setSerializeTime(String serializeTime) {
		this.serializeTime = serializeTime;
	}

	public String getResource_record_address() {
		return resource_record_address;
	}

	public void setResource_record_address(String resource_record_address) {
		this.resource_record_address = resource_record_address;
	}

	public String getResource_resolution() {
		return resource_resolution;
	}

	public void setResource_resolution(String resource_resolution) {
		this.resource_resolution = resource_resolution;
	}

	public String getResource_sub() {
		return resource_sub;
	}

	public void setResource_sub(String resource_sub) {
		this.resource_sub = resource_sub;
	}

	public String getResource_sub_type() {
		return resource_sub_type;
	}

	public void setResource_sub_type(String resource_sub_type) {
		this.resource_sub_type = resource_sub_type;
	}

	public String getResource_format() {
		return resource_format;
	}

	public void setResource_format(String resource_format) {
		this.resource_format = resource_format;
	}

	public String getResource_type() {
		return resource_type;
	}

	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}

	@Override
	public String toString() {
		return "VideoReqBean [yearRange=" + yearRange + ", serializeTime=" + serializeTime
				+ ", resource_record_address=" + resource_record_address + ", resource_resolution="
				+ resource_resolution + ", resource_sub=" + resource_sub + ", resource_sub_type=" + resource_sub_type
				+ ", resource_format=" + resource_format + ", resource_type=" + resource_type + ", year=" + year
				+ ", page=" + page + ", limit=" + limit + ", toString()=" + super.toString() + "]";
	}

}
