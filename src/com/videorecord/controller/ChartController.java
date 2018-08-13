package com.videorecord.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.chart.ChartBean;
import com.videorecord.bean.video.req.VideoSearchReqBean;
import com.videorecord.service.ChartService;

@RestController
public class ChartController {

	@Autowired
	private ChartService chartService;

	@RequestMapping(value = "/getEchartsData", method = RequestMethod.POST)
	public ResponseBean<ChartBean> getEchartsData(VideoSearchReqBean req, HttpSession session) throws Exception {
		return chartService.getEchartsData(req);
	}

}
