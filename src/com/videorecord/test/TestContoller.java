package com.videorecord.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class TestContoller {
	int i = 0;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void getPoster(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(i);
		i++;
		System.out.println(i);

	}

}
