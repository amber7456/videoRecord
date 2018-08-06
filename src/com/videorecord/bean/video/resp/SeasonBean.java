package com.videorecord.bean.video.resp;

import java.util.List;

import com.videorecord.mybatis.pojo.VideoInfo;

public class SeasonBean {

	private String type;

	private List<VideoInfo> videoInfo;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<VideoInfo> getVideoInfo() {
		return videoInfo;
	}

	public void setVideoInfo(List<VideoInfo> videoInfo) {
		this.videoInfo = videoInfo;
	}

	@Override
	public String toString() {
		return "AnimationBean [type=" + type + ", videoInfo=" + videoInfo + "]";
	}

}
