package com.videorecord.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.batchupload.UploadReqBean;

@RestController
public class BatchUploadContoller {
	
	@RequestMapping(value = "/batchUpload", method = RequestMethod.POST)
	public void getEchartsData(UploadReqBean req, HttpSession session) throws Exception {
		System.out.println(req.getFile());
	}
}
