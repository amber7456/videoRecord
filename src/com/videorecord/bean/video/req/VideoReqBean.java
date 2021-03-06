package com.videorecord.bean.video.req;

public class VideoReqBean {

	private String videoType;
	private String yearRange;
	private String address;
	private String animationSeason;
	private String country;
	private String dramaSeason;
	private String serializeTime;
	private String resourceType;
	private String format;
	private String resolution;
	private String subType;
	private String videoName;

	private String year;

	private Integer page;
	private Integer limit;

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	public String getYearRange() {
		return yearRange;
	}

	public void setYearRange(String yearRange) {
		this.yearRange = yearRange;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAnimationSeason() {
		return animationSeason;
	}

	public void setAnimationSeason(String animationSeason) {
		this.animationSeason = animationSeason;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDramaSeason() {
		return dramaSeason;
	}

	public void setDramaSeason(String dramaSeason) {
		this.dramaSeason = dramaSeason;
	}

	public String getSerializeTime() {
		return serializeTime;
	}

	public void setSerializeTime(String serializeTime) {
		this.serializeTime = serializeTime;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

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

	@Override
	public String toString() {
		return "VideoReqBean [videoType=" + videoType + ", yearRange=" + yearRange + ", address=" + address
				+ ", animationSeason=" + animationSeason + ", country=" + country + ", dramaSeason=" + dramaSeason
				+ ", serializeTime=" + serializeTime + ", resourceType=" + resourceType + ", format=" + format
				+ ", resolution=" + resolution + ", subType=" + subType + ", videoName=" + videoName + ", year=" + year
				+ ", page=" + page + ", limit=" + limit + "]";
	}

}
