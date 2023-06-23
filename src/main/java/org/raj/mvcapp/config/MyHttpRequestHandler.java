package org.raj.mvcapp.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestHandler;

public class MyHttpRequestHandler implements HttpRequestHandler {
	private static final Logger logger = LoggerFactory.getLogger(MyHttpRequestHandler.class);
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("handling request in MyHttpRequestHandler");
		PrintWriter writer = response.getWriter();
		writer.write("response from MyHttpRequestHandler, uri: " + request.getRequestURI());
	}
}