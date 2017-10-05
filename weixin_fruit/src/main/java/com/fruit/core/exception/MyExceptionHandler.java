package com.fruit.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.weixin.core.utils.WeixinUtil;

/**
 * spring mvc异常捕获类
 * 
 * 网上说此处和配置文件不能共存，我也不知道啥原原因
 * 
 * 我想微信的异常用这个，后台的用配置文件里的
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

	private static final Logger logger = Logger.getLogger(MyExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String exceptionMessage = getExceptionMessage(ex);
		logger.error(exceptionMessage);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("exceptionMessage", exceptionMessage);
		model.put("ex", ex);
		model.put("url", WeixinUtil.send_authorize_url);
		return new ModelAndView("common/error", model);
	}

	public static String getExceptionMessage(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		return sw.toString();
	}
}
