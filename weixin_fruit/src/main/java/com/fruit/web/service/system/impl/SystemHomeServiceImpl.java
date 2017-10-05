package com.fruit.web.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.service.system.SystemHomeService;
import com.fruit.web.service.system.SystemLoginService;
import com.google.common.collect.Maps;

@Service
public class SystemHomeServiceImpl implements SystemHomeService {

	@Autowired
	private SystemLoginService systemLoginService;
	
	
	@Override
	public Map<String, Object> welcome() {
		Map<String, Object> view = Maps.newHashMap();

		List<Map<String, Object>> size = systemLoginService.select();
		// 首页数据展示没必要展示所有的所以只拿出1月之内的就可以了
		// 2016-09-29 新加入功能
		List<Map<String, Object>> data = systemLoginService.selectByDate();
		
		view.put("data", data);
		view.put("count", size.size());
		view.put("ip", "");
		view.put("last_time", "");

		if (data != null && data.size() > 0) {
			view.put("ip", data.get(0).get("IP"));
			view.put("last_time", data.get(0).get("tim"));
		}
		return view;
	}

}
