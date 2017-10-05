package com.fruit.web.service.system;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.Permission;


public interface SystemMenuService extends IBaseDao<Permission, String> {

	public List<Map<String,Object>> select();
	
	public List<Map<String, Object>> selectSubMenu(String pid);
	
	public List<Map<String, Object>> selectPermCode();
	
	public List<Map<String, Object>> treeBiz(List<Map<String,Object>> menu);
	
	public List<Map<String, Object>> tree2Biz(List<Map<String,Object>> permission);
}
