package com.videorecord.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.chart.TrendBean;
import com.videorecord.bean.video.req.VideoReqBean;
import com.videorecord.service.ChartService;

@RestController
public class ChartController {

	@Autowired
	private ChartService chartService;

	@RequestMapping(value = "/getTrend", method = RequestMethod.POST)
	public ResponseBean<TrendBean> getDiskList(VideoReqBean videoReqBean, HttpSession session) throws Exception {
		return chartService.getTrend(videoReqBean);
	}

}
