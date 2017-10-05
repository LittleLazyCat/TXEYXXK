package com.fruit.web.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.Permission;
import com.fruit.web.service.system.SystemMenuService;
import com.google.common.collect.Lists;

@Service
public class SystemMenuServiceImpl extends BaseDao<Permission, String> implements SystemMenuService {

	@Override
	public List<Map<String, Object>> select() {
		return sqlSessionTemplate.selectList(getMapperMethodId("select"));
	}

	@Override
	public List<Map<String, Object>> selectSubMenu(String pid) {
		return sqlSessionTemplate.selectList(getMapperMethodId("selectSubMenu"),pid);
	}
	
	@Override
	public List<Map<String, Object>> selectPermCode() {
		return sqlSessionTemplate.selectList(getMapperMethodId("selectPermCode"));
	}

	@Override
	public List<Map<String, Object>> treeBiz(List<Map<String, Object>> menu) {
		List<Map<String,Object>> coll = Lists.newArrayList();
		for(int i =0 ; i< menu.size(); i++) {
			Map<String,Object> m = menu.get(i);
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", m.get("ID"));
			param.put("pId", m.get("PID"));
			param.put("name", m.get("NAME"));
			param.put("open", true);
			coll.add(param);
			List<Map<String, Object>> sub = selectSubMenu(m.get("ID").toString());
			for(int j =0; j< sub.size(); j++) {
				Map<String,Object> s = sub.get(j);
				Map<String,Object> param2 = new HashMap<String,Object>();
				param2.put("id", s.get("ID"));
				param2.put("pId", s.get("PID"));
				param2.put("name", s.get("NAME"));
				param2.put("open", true);
				coll.add(param2);
			}
		}
		return coll;
	}

	@Override
	public List<Map<String, Object>> tree2Biz(List<Map<String, Object>> permission) {
		List<Map<String,Object>> coll = Lists.newArrayList();
		for(int i =0 ; i< permission.size(); i++) {
			Map<String,Object> m = permission.get(i);
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", m.get("id"));
			param.put("pId", m.get("pid"));
			param.put("name", m.get("name"));
			param.put("open", true);
			coll.add(param);
		}
		return coll;
	}


}
