package com.videorecord.mybatis.pojo;

public class VideoSearch {

	private String videoType;
	private String yearRange;
	private String yearBegin;// 年范围 起始
	private String yearEnd;// 年范围 结束
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

	private String episodeBegin;
	private String episodeEnd;

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

	public String getYearBegin() {
		return yearBegin;
	}

	public void setYearBegin(String yearBegin) {
		this.yearBegin = yearBegin;
	}

	public String getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
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

	public String getEpisodeBegin() {
		return episodeBegin;
	}

	public void setEpisodeBegin(String episodeBegin) {
		this.episodeBegin = episodeBegin;
	}

	public String getEpisodeEnd() {
		return episodeEnd;
	}

	public void setEpisodeEnd(String episodeEnd) {
		this.episodeEnd = episodeEnd;
	}

	@Override
	public String toString() {
		return "VideoSearch [videoType=" + videoType + ", yearRange=" + yearRange + ", yearBegin=" + yearBegin
				+ ", yearEnd=" + yearEnd + ", address=" + address + ", animationSeason=" + animationSeason
				+ ", country=" + country + ", dramaSeason=" + dramaSeason + ", serializeTime=" + serializeTime
				+ ", resourceType=" + resourceType + ", format=" + format + ", resolution=" + resolution + ", subType="
				+ subType + ", videoName=" + videoName + ", episodeBegin=" + episodeBegin + ", episodeEnd=" + episodeEnd
				+ ", year=" + year + ", page=" + page + ", limit=" + limit + "]";
	}

}