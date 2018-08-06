package com.videorecord.mybatis.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VideoResourceInfo {
	private String video_id;

	private String resource_type;

	private String resource_format;

	private String resource_resolution;

	private String resource_sub;

	private String resource_sub_type;

	private Date resource_record_time;

	private String resource_record_address;

	private String resource_remark;

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id == null ? null : video_id.trim();
	}

	public String getResource_type() {
		return resource_type;
	}

	public void setResource_type(String resource_type) {
		this.resource_type = resource_type == null ? null : resource_type.trim();
	}

	public String getResource_format() {
		return resource_format;
	}

	public void setResource_format(String resource_format) {
		this.resource_format = resource_format == null ? null : resource_format.trim();
	}

	public String getResource_resolution() {
		return resource_resolution;
	}

	public void setResource_resolution(String resource_resolution) {
		this.resource_resolution = resource_resolution == null ? null : resource_resolution.trim();
	}

	public String getResource_sub() {
		return resource_sub;
	}

	public void setResource_sub(String resource_sub) {
		this.resource_sub = resource_sub == null ? null : resource_sub.trim();
	}

	public String getResource_sub_type() {
		return resource_sub_type;
	}

	public void setResource_sub_type(String resource_sub_type) {
		this.resource_sub_type = resource_sub_type == null ? null : resource_sub_type.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getResource_record_time() {
		return resource_record_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public void setResource_record_time(Date resource_record_time) {
		this.resource_record_time = resource_record_time;
	}

	public String getResource_record_address() {
		return resource_record_address;
	}

	public void setResource_record_address(String resource_record_address) {
		this.resource_record_address = resource_record_address == null ? null : resource_record_address.trim();
	}

	public String getResource_remark() {
		return resource_remark;
	}

	public void setResource_remark(String resource_remark) {
		this.resource_remark = resource_remark == null ? null : resource_remark.trim();
	}

	@Override
	public String toString() {
		return "VideoResourceInfo [video_id=" + video_id + ", resource_type=" + resource_type + ", resource_format="
				+ resource_format + ", resource_resolution=" + resource_resolution + ", resource_sub=" + resource_sub
				+ ", resource_sub_type=" + resource_sub_type + ", resource_record_time=" + resource_record_time
				+ ", resource_record_address=" + resource_record_address + ", resource_remark=" + resource_remark + "]";
	}

}