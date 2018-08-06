package com.videorecord.mybatis.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VideoInfo {
	private String video_id;

	private String video_name;

	private String video_episode;

	private Date video_broadcast_time;

	private String video_type;

	private String video_season;

	private String video_country;

	private String video_source;

	private String video_remark;

	private Date create_time;

	private Date last_update_time;

	private String have_bd_resource;

	private String have_poster;

	private String video_detail_info;

	private List<VideoResourceInfo> videoResourceInfo;

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id == null ? null : video_id.trim();
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name == null ? null : video_name.trim();
	}

	public String getVideo_episode() {
		return video_episode;
	}

	public void setVideo_episode(String video_episode) {
		this.video_episode = video_episode == null ? null : video_episode.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getVideo_broadcast_time() {
		return video_broadcast_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public void setVideo_broadcast_time(Date video_broadcast_time) {
		this.video_broadcast_time = video_broadcast_time;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type == null ? null : video_type.trim();
	}

	public String getVideo_season() {
		return video_season;
	}

	public void setVideo_season(String video_season) {
		this.video_season = video_season == null ? null : video_season.trim();
	}

	public String getVideo_country() {
		return video_country;
	}

	public void setVideo_country(String video_country) {
		this.video_country = video_country == null ? null : video_country.trim();
	}

	public String getVideo_source() {
		return video_source;
	}

	public void setVideo_source(String video_source) {
		this.video_source = video_source == null ? null : video_source.trim();
	}

	public String getVideo_remark() {
		return video_remark;
	}

	public void setVideo_remark(String video_remark) {
		this.video_remark = video_remark == null ? null : video_remark.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreate_time() {
		return create_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getLast_update_time() {
		return last_update_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	public String getHave_bd_resource() {
		return have_bd_resource;
	}

	public void setHave_bd_resource(String have_bd_resource) {
		this.have_bd_resource = have_bd_resource == null ? null : have_bd_resource.trim();
	}

	public String getHave_poster() {
		return have_poster;
	}

	public void setHave_poster(String have_poster) {
		this.have_poster = have_poster == null ? null : have_poster.trim();
	}

	public String getVideo_detail_info() {
		return video_detail_info;
	}

	public void setVideo_detail_info(String video_detail_info) {
		this.video_detail_info = video_detail_info == null ? null : video_detail_info.trim();
	}

	public List<VideoResourceInfo> getVideoResourceInfo() {
		return videoResourceInfo;
	}

	public void setVideoResourceInfo(List<VideoResourceInfo> videoResourceInfo) {
		this.videoResourceInfo = videoResourceInfo;
	}

	@Override
	public String toString() {
		return "VideoInfo [video_id=" + video_id + ", video_name=" + video_name + ", video_episode=" + video_episode
				+ ", video_broadcast_time=" + video_broadcast_time + ", video_type=" + video_type + ", video_season="
				+ video_season + ", video_country=" + video_country + ", video_source=" + video_source
				+ ", video_remark=" + video_remark + ", create_time=" + create_time + ", last_update_time="
				+ last_update_time + ", have_bd_resource=" + have_bd_resource + ", have_poster=" + have_poster
				+ ", video_detail_info=" + video_detail_info + "]";
	}

}