package com.webtest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// System.out.println("==>DemoFilter启动");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("==>DemoFilter拦截请求");
		chain.doFilter(request, response);

	}

	public void destroy() {

	}
}