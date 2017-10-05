package com.fruit.core.web.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class WeatherUtils {
	
	public static JSONObject getWeatherInfo(String data) {
		JSONObject jsonObject = JSONObject.parseObject(data);
		// 请求失败
		if(jsonObject.getString("status").equals("302")) {
			return null;
		} 
		// 请求成功
		else if(jsonObject.getString("status").equals("success")) {
			JSONArray jsonArray = jsonObject.getJSONArray("results"); // 可以获取未来4天天气，我们只需要当天
			JSONObject weatherData = jsonArray.getJSONObject(0).getJSONArray("weather_data").getJSONObject(0);
			return weatherData;
		}
		return null;
	}

	public static String getWeatherInform(String cityName) {
		// 百度天气API
		String baiduUrl = "";
		StringBuffer strBuf;
		try {
			baiduUrl = "http://api.map.baidu.com/telematics/v3/weather?location=" + URLEncoder.encode(cityName, "utf-8")
					+ "&output=json&ak=W69oaDTCfuGwzNwmtVvgWfGH";
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		strBuf = new StringBuffer();
		try {
			URL url = new URL(baiduUrl);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));// 转码。
			String line = null;
			while ((line = reader.readLine()) != null)
				strBuf.append(line + " ");
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
}
