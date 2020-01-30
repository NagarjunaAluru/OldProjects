/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ExternalURLTranslator.java
 * Purpose: ExternalURLTranslator converts external user requests to actual resource URLs
 */
package com.ge.aloc.ext;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;

/**
 * This class converts external request URLs to actual resource URLs.
 * 
 * This class only redirects the requests of static data like images, css files and js files.
 * 
 * Requests of action classes forwards as it is.
 * 
 * @author chaitanya.n
 */
public class ExternalURLTranslator implements Filter{
	private static final Logger LOGGER = Logger.getLogger(ExternalURLTranslator.class);
	public static final String STR_PATTERN = "^(/ext)(/public)?(/css|/img|/js|/font|/struts)(/.*)$";
	public static final String REQ_ATTR_ISEXTERNAL = "externalRequest";
	public static final int DIR_GRP_NUM = ALOCConstants.NUM_THREE;
	public static final int RES_PATH_GRP_NUM = ALOCConstants.NUM_FOUR;

	private Pattern uriPattern;

	/**
	 * This method initialises the object;
	 * Compiles the RegEx pattern.
	 */
	public void init(FilterConfig config) throws ServletException {
		uriPattern = Pattern.compile(STR_PATTERN);
	}

	/**
	 * This method converts user requests to actual resource paths.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		String uri = trimRequestURI((HttpServletRequest)request);
		Matcher m = uriPattern.matcher(uri);
		request.setAttribute(REQ_ATTR_ISEXTERNAL, Boolean.TRUE);
		if(m.matches()) {
			String newURI = m.group(DIR_GRP_NUM) + m.group(RES_PATH_GRP_NUM);
			if(LOGGER.isDebugEnabled()) {
				String msg = new StringBuilder().append("Translated URI for the request URI \'").append(uri).append("\'")
						.append(" is \'").append(newURI).append("\'").toString();
				LOGGER.debug(msg);
			}
			RequestDispatcher rd = request.getRequestDispatcher(newURI);
			if(rd != null) {
				rd.forward(request, response);
			} else {
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}  else {
			filterChain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
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
