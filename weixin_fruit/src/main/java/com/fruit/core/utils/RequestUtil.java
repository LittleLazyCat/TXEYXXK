package com.fruit.core.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	/**
	 * 判断请求是否为Ajax请求. <br/>
	 * 
	 * @param request
	 *            请求对象
	 * @return boolean
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		return "XMLHttpRequest".equals(header);
	}
	
	/**
	 * 获取请求路径,即contextPath后面部分. 如http://www.aaa.com/rms/sys/index.jsp<br>
	 * 返回/sys/index.jsp
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String result = request.getServletPath();
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			result = result + pathInfo;
		}

		// getServletPath() returns null unless the mapping corresponds to a
		// servlet
		if (result == null) {
			String requestURI = request.getRequestURI();
			if (request.getPathInfo() != null) {
				// strip the pathInfo from the requestURI
				return requestURI.substring(0,
						requestURI.indexOf(request.getPathInfo()));
			} else {
				return requestURI;
			}
		} else if ("".equals(result)) {
			// in servlet 2.4, if a request is mapped to '/*', getServletPath
			// returns null (SIM-130)
			return request.getPathInfo();
		} else {
			return result;
		}
	}

}
