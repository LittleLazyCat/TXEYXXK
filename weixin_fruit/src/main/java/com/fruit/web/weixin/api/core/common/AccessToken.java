package com.fruit.web.weixin.api.core.common;

import com.fruit.web.service.weixin.WeixinAccountService;
import com.fruit.web.weixin.utils.SpringContextUtils;

public class AccessToken {

	private WeixinAccountService weixinAccountService;
	
	private String appid;
	private String appscret;
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppscret() {
		return appscret;
	}

	public void setAppscret(String appscret) {
		this.appscret = appscret;
	}

	public AccessToken(String appid, String appscret) {
		this.setAppid(appid);
		this.setAppscret(appscret);		
		this.weixinAccountService = (WeixinAccountService)SpringContextUtils.getBean("weixinAccountService");
	}

	public String getNewAccessToken() {
		String token = weixinAccountService.getAccessToken();
		return token;
	}

}
