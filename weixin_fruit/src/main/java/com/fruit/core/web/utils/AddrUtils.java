package com.fruit.core.web.utils;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.StatusLine;
import org.apache.commons.httpclient.methods.GetMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AddrUtils {

	public static final String LOCATION = "http://api.map.baidu.com/location/ip?ak=cTYtHPV1spdnWgFSeKfXqjTh&coor=bd09ll&ip=";

	public static JSONObject requestGet(String url) {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			client.executeMethod(method);
			StatusLine statusLine = method.getStatusLine();
			String responseBody = method.getResponseBodyAsString();
			if (statusLine.getStatusCode() == 200) {
				JSONObject jsonObject = JSON.parseObject(responseBody);
				return jsonObject;
			}
		} catch (Exception e) {
			
		} finally {
            if (method != null) {
                method.releaseConnection();
            }
        }
		return null;
	}

	/**
	 * 根据IP 查询城市信息
	 * 
	 * @param ip
	 * @return
	 */
	public static String getCity(String ip) {
		String baiduUrl = "http://api.map.baidu.com/location/ip?ak=cTYtHPV1spdnWgFSeKfXqjTh&coor=bd09ll&ip=" + ip;
		JSONObject jsonObject = requestGet(baiduUrl);
		JSONObject contentJsonObject = jsonObject.getJSONObject("content");
		if (contentJsonObject != null) {
			JSONObject address_detailJsonObject = contentJsonObject.getJSONObject("address_detail");
			if (address_detailJsonObject != null) {
				String city = address_detailJsonObject.getString("city"); // 成功拿到城市信息
				return city;
			}
		}
		return null;
	}
}
