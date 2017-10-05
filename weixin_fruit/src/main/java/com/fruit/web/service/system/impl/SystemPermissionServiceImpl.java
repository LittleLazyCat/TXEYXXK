package com.fruit.web.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.Permission;
import com.fruit.web.service.system.SystemPermissionService;


@Service
public class SystemPermissionServiceImpl extends BaseDao<Permission, Integer>  implements SystemPermissionService {


	@Override
	public List<Map<String, Object>> permissionList(String currentUserId) {
		return sqlSessionTemplate.selectList(getMapperMethodId("permissionList"),currentUserId);
	}

	@Override
	public List<Map<String, Object>> getUserPermission(String roleId) {
		return sqlSessionTemplate.selectList(getMapperMethodId("getUserPermission"),roleId);
	}

	@Override
	public List<Map<String, Object>> permissionAllList() {
		return sqlSessionTemplate.selectList(getMapperMethodId("permissionAllList"));
	}
	
	
}
