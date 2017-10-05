package com.fruit.core.web.interceptor.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.core.hook.interceptor.InterceptorHookSupport;
import com.fruit.core.web.utils.DateUtils;
import com.fruit.core.web.utils.IPUtil;
import com.fruit.web.model.SystemLoginLog;
import com.fruit.web.service.system.SystemLoginService;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SystemLoginController拦截钩子
 *
 * @author jzx
 * @date 2016-10-10 14:18:01
 * 
 * 特别感谢围城大哥的项目，让我长姿势了。
 */
@Component
public class SystemLoginHook extends InterceptorHookSupport {

	@Autowired
	private SystemLoginService loginService;
	
    @Override
    public void init() {
        this.plugins = getPlugins(SystemLoginInterceptorListener.class);
    }

    @Override
    public String[] getInterceptor() {
        String[] n = {"com.fruit.web.controller.system.SystemHomeController#welcome"};
        return n;
    }

	
    @Override
    public void preHandle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) throws Exception {
    	
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler, ModelAndView modelAndView) throws Exception {

        System.out.println(handler.getMethod().getName());

        System.out.println(modelAndView);

        System.out.println("");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler, Exception ex) throws Exception {
    	UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent")); 
		String os=userAgent.getOperatingSystem().getName();	//获取客户端操作系统
		String browser=userAgent.getBrowser().getName();	//获取客户端浏览器
		
		SystemLoginLog log=new SystemLoginLog();
		log.setOs(os);
		log.setBrowser(browser);
		log.setIp(IPUtil.getIpAddress(request));
		log.setCreateDate(DateUtils.getSysTimestamp());
		
		// 过滤本地IP
		if(!IPUtil.getIpAddress(request).equals("127.0.0.1")){
			loginService.create(log);
		}
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) throws Exception {

    }

    public interface SystemLoginInterceptorListener extends InterceptorListener {

    }

}
