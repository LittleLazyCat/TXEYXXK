package com.fruit.web.service.system.listener;

import java.util.List;
import java.util.Map;

public interface SystemCornService {

	public List<Map<String,Object>> loadCorn();
	
	public void removeCorn(String id);
	
	public void addCorn(String name,String corn);
}
