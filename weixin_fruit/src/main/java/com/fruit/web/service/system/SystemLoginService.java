package com.fruit.web.service.system;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.SystemLoginLog;


public interface SystemLoginService  extends IBaseDao<SystemLoginLog, Integer> {

	public List<Map<String, Object>> select();
	
	public List<Map<String, Object>> selectByDate();

	public Map<String, Object> actDataArray(String type);
	
}
