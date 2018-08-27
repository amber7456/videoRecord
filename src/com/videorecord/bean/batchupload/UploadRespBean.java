package com.videorecord.bean.batchupload;

import java.util.List;


import com.videorecord.mybatis.pojo.VideoInfo;

public class UploadRespBean {

	List<VideoInfo> videoInfo;

	public List<VideoInfo> getVideoInfo() {
		return videoInfo;
	}

	public void setVideoInfo(List<VideoInfo> videoInfo) {
		this.videoInfo = videoInfo;
	}

	@Override
	public String toString() {
		return "UploadRespBean [videoInfo=" + videoInfo + "]";
	}

}
