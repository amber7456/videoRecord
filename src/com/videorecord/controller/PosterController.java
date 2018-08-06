package com.videorecord.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.service.PosterService;

@RestController
public class PosterController {

	@Autowired
	private PosterService posterService;

	@RequestMapping(value = "/getPoster/{video_id}", method = RequestMethod.GET)
	public void getPoster(@PathVariable String video_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("image/gif");
		try {
			OutputStream out = response.getOutputStream();
			byte[] b = posterService.getPosterById(video_id);
			out.write(b);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
