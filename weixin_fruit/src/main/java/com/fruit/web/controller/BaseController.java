package com.fruit.web.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fruit.core.WebContext;
import com.fruit.core.utils.ClassUtil;
import com.fruit.core.web.utils.ActionRequest;
import com.fruit.core.web.utils.Bundle;
import com.fruit.core.web.utils.DataUtil;
import com.fruit.core.web.utils.DateUtils;
import com.fruit.core.web.utils.IPUtil;
import com.fruit.core.web.utils.MD5;
import com.fruit.web.model.SystemUser;
import com.fruit.web.shiro.realm.UserUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author jzx
 * @desc controller 基础操作类
 * @date 2016.3.19
 * 
 */
public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public String getPara(String name) {
		return getRequest().getParameter(name);
	}

	public String getPara(String name, String defaultValue) {
		return ActionRequest.getPara(name, defaultValue, getRequest());
	}

	public Integer getParaToInt(String name) {
		return parseInt((getRequest().getParameter(name)));
	}

	public Long getParaToLong(String name) {
		return parseLong(getRequest().getParameter(name));
	}

	public Double getParaToDouble(String name) {
		return parseDouble(getRequest().getParameter(name));
	}

	public Float getParaToFloat(String name) {
		return parseFloat(getRequest().getParameter(name));
	}

	public String[] getParaValues(String key) {
		return getRequest().getParameterValues(key);
	}

	public String getParaFormatDate(String name) {
		return parseDate(getRequest().getParameter(name));
	}

	public <T> void setAttr(String key, List<T> value) {
		getRequest().setAttribute(key, value);
	}

	public <T> void setAttr(String key, Set<T> value) {
		getRequest().setAttribute(key, value);
	}

	public <T> void setAttr(String key, Stack<T> value) {
		getRequest().setAttribute(key, value);
	}

	public void setAttr(String key, Object value) {
		getRequest().setAttribute(key, value);
	}

	public void setAttrs(Map<String, Object> map) {
		ActionRequest.setAttrs(getRequest(), map);
	}

	public Object getAttr(String name) {
		return getRequest().getAttribute(name);
	}

	public Object getAttrSession(String name) {
		return getSession().getAttribute(name);
	}

	public String getAttrSessionToStr(String name) {
		return getSession().getAttribute(name).toString();
	}

	public void removeAttrSession(String name) {
		getSession().removeAttribute(name);
	}

	public void setAttrSession(String name, Object value) {
		getSession().setAttribute(name, value);
	}

	public void renderJson200() {
		renderJson("{\"code\":200}");
	}

	public void renderJsonError(String msg) {
		renderJson("{\"msg\":\" " + msg + " \"}");
	}

	public void renderJson(String data) {
		ActionRequest.renderJson(data, getResponse());
	}

	public List<Map<String, Object>> toGson(String data) {
		Gson gson = new Gson();
		return gson.fromJson(data, new TypeToken<List<Map<String, Object>>>() {
		}.getType());
	}

	public <T> List<T> toGson(String data, Class<T> clz) {
		Gson gson = new Gson();
		return gson.fromJson(data, new TypeToken<T>() {
		}.getType());
	}

	public String toJson(Object src) {
		Gson gson = new Gson();
		return gson.toJson(src);
	}

	/**
	 * 拿到IP信息
	 */
	public String getIpAddr() {
		return DataUtil.getIpAddr(getRequest());
	}

	/**
	 * 处理IP的信息
	 */
	public String getIPaddr() {
		return IPUtil.getIpAddress(getRequest());
	}

	/**
	 * 拿到一些时间的简单调用
	 */
	public String getTimeNow() {
		return DateUtils.getNowTime();
	}

	public Timestamp getSysTimestamp() {
		return DateUtils.getSysTimestamp();
	}

	/**
	 * 拿到系统当前用户信息
	 */
	public SystemUser getCurrentUser() {
		return UserUtil.getCurrentUser();
	}

	protected AuthenticationToken createToken(String username, String password) {
		return new UsernamePasswordToken(username, MD5.encodeString(password));
	}

	/**
	 * 简单转换
	 */
	public Integer parseInt(String val) {
		return Bundle.convInt(val);
	}

	public Long parseLong(String val) {
		return Bundle.convLong(val);
	}

	public Float parseFloat(String val) {
		return Bundle.convFloat(val);
	}

	public Double parseDouble(String val) {
		return Bundle.convDouble(val);
	}

	public String parseDate(String val) {
		return DateUtils.parseDate(DateUtils.yyyyMMdd, val);
	}

	public String parseDate(Object val) {
		return DateUtils.parseDate(DateUtils.yyyyMMddHHMMSS, val);
	}

	public <T> Map<String, Object> convertObj2Map(T obj) {
		return ClassUtil.convertObj2Map(obj);
	}

	public String parseStr(Integer val) {
		return Bundle.convStr(val);
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

		/**
		 * 防止XSS攻击
		 */
		// binder.registerCustomEditor(String.class, new
		// StringEscapeEditor(true, true,true));
	}

	@ModelAttribute
	private void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public HttpServletResponse getResponse() {
		return WebContext.getInstance().getResponse();
	}

	public HttpServletRequest getRequest() {
		return WebContext.getInstance().getRequest();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

}
