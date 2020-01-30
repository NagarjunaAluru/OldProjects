package com.ge.icfp.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * This filter sets no cache headers to HTTP response.
 */
public class NoCacheResponseFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		if(!res.containsHeader("Cache-Control")) {
			res.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //HTTP 1.1
		}
		
		if(!res.containsHeader("Pragma")) {
			res.setHeader("Pragma","no-cache"); //HTTP 1.0
		}
		
		if(!res.containsHeader("Expires")) {
			res.setDateHeader ("Expires", -1); //prevents caching at the proxy 
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
}
