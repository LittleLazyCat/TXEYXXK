package com.kp.qy.util;

import com.kp.qy.enums.EnumMethod;
import com.kp.qy.pojo.AccessToken;
import com.kp.qy.pojo.WXjsTicket;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 公众平台通用接口工具类
 * 
 */
public class WechatAccessToken {
	// 获取微信公众号：access_token的接口地址（GET） 限2000（次/天）
	//public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 获取企业号access_token
	public final static String company_access_token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	
	//主动调用：发送消息AccessTokentoken
	public static AccessToken accessToken;
	//主动调用：请求Token的时间
	public static Date access_token_date;
	//Token有效时间，默认是7200秒，每次请求更新，用于判断Token是否超时
	public static long accessTokenInvalidTime = 7200L;
	
	
	
	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret, int type) {
		
		String requestUrl = new String();
		//微信公众号
		//requestUrl =access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		if (type == 1) {
			requestUrl = company_access_token_url.replace("CORPID", appid).replace("CORPSECRET", appsecret);
			System.err.println(requestUrl);
		}
		
		//1.判断access_token是否存在，不存在则直接申请
		//2.判断时间是否过期，过期（>=7200秒）申请，否则不用请求直接返回以后的Token
		if(null==accessToken||"".equals(accessToken)||(new Date().getTime()-access_token_date.getTime())>=(accessTokenInvalidTime-200L)*1000L){
			JSONObject jsonObject = HttpRequestUtil.httpRequest(requestUrl, EnumMethod.GET.name(), null);
			if(jsonObject==null){
				jsonObject = HttpRequestUtil.httpRequest(requestUrl, EnumMethod.GET.name(), null);
			}
			// 如果请求成功
			if (null != jsonObject) {
				try {
					accessToken = new AccessToken();
					//设置全局变量
					accessToken.setToken(jsonObject.getString("access_token"));
					accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
					//更新Token有效时间
					accessTokenInvalidTime=Long.valueOf(jsonObject.getInt("expires_in")+"");
					access_token_date=new Date();
				} catch (JSONException e) {
					accessToken = null;
					// 获取token失败
				}
			}
		}
		
		return accessToken;
	}
	private static Logger log = LoggerFactory.getLogger(WechatAccessToken.class);

	
	
	public static WXjsTicket getWXjsTicket(String accessToken) {
		WXjsTicket wXjsTicket = null;
		String requestUrl= WXURLUtil.JSAPIURL.replace("ACCESS_TOKEN", accessToken);
		// 发起GET请求获取凭证
		JSONObject jsonObject = HttpRequestUtil.httpRequest(requestUrl, "GET", null);
		System.out.println("CommonUtil.java 调用了一次getWXjsTicket接口");
		if (null != jsonObject) {
			try {
				wXjsTicket = new WXjsTicket();
				wXjsTicket.setJsTicket(jsonObject.getString("ticket"));
				wXjsTicket.setJsTicketExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				wXjsTicket = null;
				// 获取wXjsTicket失败
				log.error("获取wXjsTicket失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return wXjsTicket;
	}
	
	

}