package com.videorecord.bean.video;

public class VideoAdvSearchBean {
	private String yearBegin;// 年范围 起始

	private String yearEnd;// 年范围 结束

	private String video_type;// 类型

	private String episodeBegin;// 连载时长 起始

	private String episodeEnd;// 连载时长结束

	private String resource_record_address;//

	private String resource_type;//

	private String resource_format;//

	private String resource_resolution;//

	private String resource_sub_type;//

	private String video_name;//

	private String resource_sub;//

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

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
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

	public String getResource_record_address() {
		return resource_record_address;
	}

	public void setResource_record_address(String resource_record_address) {
		this.resource_record_address = resource_record_address;
	}

	public String getResource_type() {
		return resource_type;
	}

	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}

	public String getResource_format() {
		return resource_format;
	}

	public void setResource_format(String resource_format) {
		this.resource_format = resource_format;
	}

	public String getResource_resolution() {
		return resource_resolution;
	}

	public void setResource_resolution(String resource_resolution) {
		this.resource_resolution = resource_resolution;
	}

	public String getResource_sub_type() {
		return resource_sub_type;
	}

	public void setResource_sub_type(String resource_sub_type) {
		this.resource_sub_type = resource_sub_type;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getResource_sub() {
		return resource_sub;
	}

	public void setResource_sub(String resource_sub) {
		this.resource_sub = resource_sub;
	}

	@Override
	public String toString() {
		return "VideoAdvSearchBean [yearBegin=" + yearBegin + ", yearEnd=" + yearEnd + ", video_type=" + video_type
				+ ", episodeBegin=" + episodeBegin + ", episodeEnd=" + episodeEnd + ", resource_record_address="
				+ resource_record_address + ", resource_type=" + resource_type + ", resource_format=" + resource_format
				+ ", resource_resolution=" + resource_resolution + ", resource_sub_type=" + resource_sub_type
				+ ", video_name=" + video_name + ", resource_sub=" + resource_sub + "]";
	}

}