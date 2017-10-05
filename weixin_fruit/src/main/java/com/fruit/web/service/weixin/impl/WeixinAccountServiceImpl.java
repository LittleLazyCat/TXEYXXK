package com.fruit.web.service.weixin.impl;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.utils.Printer;
import com.fruit.web.service.weixin.WeixinAccountService;
import com.fruit.web.weixin.core.utils.WeixinUtil;
import com.fruit.web.weixin.model.WeixinAccount;

import net.sf.json.JSONObject;

@Service
public class WeixinAccountServiceImpl extends BaseDao<WeixinAccount, String> implements WeixinAccountService {

	@Override
	public String getAccessToken() {
		String token = "";
		String requestUrl = WeixinUtil.access_token_url.replace("APPID", WeixinUtil.appid).replace("APPSECRET", WeixinUtil.appscret);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				token = jsonObject.getString("access_token");
			} catch (Exception e) {
				token = null;
			}
		}
		return token;
	}

	@Override
	public String createMenu(String accessToken,String menu) {
		String url = WeixinUtil.menu_create_url.replace("ACCESS_TOKEN",accessToken);
		JSONObject jsonObject= new JSONObject();
		jsonObject = WeixinUtil.httpRequest(url, "POST", menu);
		Printer.info(jsonObject);
		String message = "";
		try{
			if(jsonObject!=null){
				if (0 == jsonObject.getInt("errcode")) {
						message = "同步菜单信息数据成功！";
				}
				else {
					message = "同步菜单信息数据失败！错误码为："+jsonObject.getInt("errcode")+"错误信息为："+jsonObject.getString("errmsg");
				}
			}else{
				message = "同步菜单信息数据失败！同步自定义菜单URL地址不正确。";
			}
		} catch(Exception e) {
			message = "同步菜单信息数据失败！";
		}
		return message;
	}

}
