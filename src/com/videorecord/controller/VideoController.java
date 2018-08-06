package com.videorecord.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.video.req.VideoAddReqBean;
import com.videorecord.bean.video.req.VideoReqBean;
import com.videorecord.bean.video.req.VideoSearchReqBean;
import com.videorecord.bean.video.resp.VideoListBean;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.service.VideoService;

@RestController
public class VideoController {

	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "/getVideoList", method = RequestMethod.POST)
	public ResponseBean<VideoListBean> getVideoList(VideoReqBean videoReqBean, HttpSession session) throws Exception {
		return videoService.getVideoList(videoReqBean);
	}

	@RequestMapping(value = "/searchVideo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseBean<VideoListBean> searchVideo(VideoSearchReqBean req, HttpSession session) throws Exception {
		return videoService.searchVideo(req);
	}

	@RequestMapping(value = "/getVideoDetail/{video_id}", method = RequestMethod.POST)
	public ResponseBean<VideoInfo> getVideoDetail(@PathVariable String video_id, HttpSession session) throws Exception {
		return videoService.getVideoDetail(video_id);
	}

	@RequestMapping(value = "/addVideo", method = RequestMethod.POST)
	public ResponseBean<Integer> addAnimation(VideoAddReqBean videoAddBean, HttpSession session) throws Exception {
		return videoService.addVideo(videoAddBean);
	}

	@RequestMapping(value = "/editVideo", method = RequestMethod.POST)
	public ResponseBean<Integer> editAnimation(VideoAddReqBean videoAddBean, HttpSession session) throws Exception {
		return videoService.editVideo(videoAddBean);
	}

	@RequestMapping(value = "/delVideo", method = RequestMethod.POST)
	public ResponseBean<Integer> delVideo(String video_id, HttpSession session) throws Exception {
		return videoService.delVideo(video_id);
	}

}
