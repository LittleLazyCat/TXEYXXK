package com.fruit.web.weixin.api.core.handler;

import com.fruit.web.weixin.api.core.req.model.WeixinReqParam;
import com.fruit.web.weixin.core.exceptionm.WexinReqException;

/**
 * 获取微信接口的信息
 */
public interface WeiXinReqHandler {
	
	public String doRequest(WeixinReqParam weixinReqParam) throws WexinReqException;
	
}
