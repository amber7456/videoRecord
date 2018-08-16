package com.videorecord.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.batchupload.UploadReqBean; 
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.service.BatchAddService;

@RestController
public class BatchAddContoller {

	@Autowired
	private BatchAddService batchAddService;

	@RequestMapping(value = "/parseExcel", method = RequestMethod.POST)
	public ResponseBean<List<VideoInfo>> getEchartsData(UploadReqBean req, HttpSession session) throws Exception {
		return batchAddService.parseExcel(req);
	}

}
