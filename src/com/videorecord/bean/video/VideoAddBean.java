package com.videorecord.bean.video;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class VideoAddBean {

	private String video_id;

	private String video_name;

	private String video_episode;

	private Date video_broadcast_time;

	private String video_type;

	private String video_source;

	private String video_remark;

	private Date create_time;

	private Date last_update_time;

	private String have_bd_resource;

	private String have_poster;

	private String video_detail_info;

	private String[] resource_type;

	private String[] resource_format;

	private String[] resource_resolution;

	private String[] resource_sub;

	private String[] resource_sub_type;

	private Date[] resource_record_time;

	private String[] resource_record_address;

	private String[] resource_remark;

	private MultipartFile video_poster;

	private String posterUpdateFlag;

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_episode() {
		return video_episode;
	}

	public void setVideo_episode(String video_episode) {
		this.video_episode = video_episode;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getVideo_broadcast_time() {
		return video_broadcast_time;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setVideo_broadcast_time(Date video_broadcast_time) {
		this.video_broadcast_time = video_broadcast_time;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}

	public String getVideo_source() {
		return video_source;
	}

	public void setVideo_source(String video_source) {
		this.video_source = video_source;
	}

	public String getVideo_remark() {
		return video_remark;
	}

	public void setVideo_remark(String video_remark) {
		this.video_remark = video_remark;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getCreate_time() {
		return create_time;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getLast_update_time() {
		return last_update_time;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	public String getHave_bd_resource() {
		return have_bd_resource;
	}

	public void setHave_bd_resource(String have_bd_resource) {
		this.have_bd_resource = have_bd_resource;
	}

	public String getVideo_detail_info() {
		return video_detail_info;
	}

	public void setVideo_detail_info(String video_detail_info) {
		this.video_detail_info = video_detail_info;
	}

	public String[] getResource_type() {
		return resource_type;
	}

	public void setResource_type(String[] resource_type) {
		this.resource_type = resource_type;
	}

	public String[] getResource_format() {
		return resource_format;
	}

	public void setResource_format(String[] resource_format) {
		this.resource_format = resource_format;
	}

	public String[] getResource_resolution() {
		return resource_resolution;
	}

	public void setResource_resolution(String[] resource_resolution) {
		this.resource_resolution = resource_resolution;
	}

	public String[] getResource_sub() {
		return resource_sub;
	}

	public void setResource_sub(String[] resource_sub) {
		this.resource_sub = resource_sub;
	}

	public String[] getResource_sub_type() {
		return resource_sub_type;
	}

	public void setResource_sub_type(String[] resource_sub_type) {
		this.resource_sub_type = resource_sub_type;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date[] getResource_record_time() {
		return resource_record_time;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setResource_record_time(Date[] resource_record_time) {
		this.resource_record_time = resource_record_time;
	}

	public String[] getResource_record_address() {
		return resource_record_address;
	}

	public void setResource_record_address(String[] resource_record_address) {
		this.resource_record_address = resource_record_address;
	}

	public String[] getResource_remark() {
		return resource_remark;
	}

	public void setResource_remark(String[] resource_remark) {
		this.resource_remark = resource_remark;
	}

	public MultipartFile getVideo_poster() {
		return video_poster;
	}

	public void setVideo_poster(MultipartFile video_poster) {
		this.video_poster = video_poster;
	}

	public String getPosterUpdateFlag() {
		return posterUpdateFlag;
	}

	public void setPosterUpdateFlag(String posterUpdateFlag) {
		this.posterUpdateFlag = posterUpdateFlag;
	}

	public String getHave_poster() {
		return have_poster;
	}

	public void setHave_poster(String have_poster) {
		this.have_poster = have_poster;
	}

	@Override
	public String toString() {
		return "VideoAddBean [video_id=" + video_id + ", video_name=" + video_name + ", video_episode=" + video_episode
				+ ", video_broadcast_time=" + video_broadcast_time + ", video_type=" + video_type + ", video_source="
				+ video_source + ", video_remark=" + video_remark + ", create_time=" + create_time
				+ ", last_update_time=" + last_update_time + ", have_bd_resource=" + have_bd_resource + ", have_poster="
				+ have_poster + ", video_detail_info=" + video_detail_info + ", resource_type="
				+ Arrays.toString(resource_type) + ", resource_format=" + Arrays.toString(resource_format)
				+ ", resource_resolution=" + Arrays.toString(resource_resolution) + ", resource_sub="
				+ Arrays.toString(resource_sub) + ", resource_sub_type=" + Arrays.toString(resource_sub_type)
				+ ", resource_record_time=" + Arrays.toString(resource_record_time) + ", resource_record_address="
				+ Arrays.toString(resource_record_address) + ", resource_remark=" + Arrays.toString(resource_remark)
				+ ", video_poster=" + video_poster + ", posterUpdateFlag=" + posterUpdateFlag + "]";
	}

}
