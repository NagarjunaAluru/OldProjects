/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: ExtURLFilter.java
 * Purpose: ExtURLFilter helps to accept only external URLs
 */
package com.ge.aloc.ext.filters;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;

/**
 * @author madhusudhan.gosula
 *
 */
public class ExtURLFilter implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger(ExtURLFilter.class);
	private static final Pattern URL_PATTERN = Pattern.compile("/ext/.*");
	
	/**
	 * This method converts user requests to actual resource paths.
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		String uri = trimRequestURI(httpReq);
		
		if(URL_PATTERN.matcher(uri).matches()) {
			chain.doFilter(req, res);
		} else {
			LOGGER.error(httpReq.getRequestURI() + " is not external URL");
			throw new ALOCRuntimeException(null, "Invalid external Request");
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * This method initialises the object;
	 * Compiles the RegEx pattern.
	 */
	public void init(FilterConfig config) throws ServletException {
		
	}
	
	/**
	 * This method returns the request URI excluding context path.
	 * 
	 * @param request
	 * @return
	 */
	private String trimRequestURI(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int index = uri.indexOf(contextPath);
		if(index < ALOCConstants.BASE_VALUE) {
			throw new ALOCRuntimeException(null, "Context Path not found in requested URI"); // TODO Need to assign the code
		}
		String requestedResource = uri.substring(index + contextPath.length());
		return requestedResource;
	}
}
