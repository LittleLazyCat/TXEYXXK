package com.fruit.web.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.SystemUser;
import com.fruit.web.service.system.SystemUserService;


@Service
public class SystemUserServiceImpl extends BaseDao<SystemUser, Integer> implements SystemUserService {
	
	@Override
	public boolean checkLogin(String name, String password) {
		SystemUser systemUser = new SystemUser();
		systemUser.setName(name);
		systemUser.setPassword(password);
		List<SystemUser> system = queryByObject(systemUser);
		if(!system.isEmpty())
			return true;
		else 
			return false;
	}
	
	@Override
	public SystemUser getUserInfo(String username) {
		return sqlSessionTemplate.selectOne(getMapperMethodId("getUserInfo"),username);
	}

	@Override
	public List<Map<String, Object>> selectUser() {
		return sqlSessionTemplate.selectList(getMapperMethodId("selectUser"));
	}
}
