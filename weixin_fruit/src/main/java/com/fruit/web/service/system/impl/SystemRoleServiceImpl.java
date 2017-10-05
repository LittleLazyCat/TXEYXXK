package com.fruit.web.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.SystemRole;
import com.fruit.web.service.system.SystemRoleService;


@Service
public class SystemRoleServiceImpl extends BaseDao<SystemRole, Integer> implements SystemRoleService {

	@Override
	public List<Map<String, Object>> getUserRoles(String userid) {
		return sqlSessionTemplate.selectList(getMapperMethodId("getUserRoles"),userid);
	}

	@Override
	public List<Map<String, Object>> getRolePermissions(String id) {
		return sqlSessionTemplate.selectList(getMapperMethodId("getRolePermissions"),id);
	}

	@Override
	public void deleteRolePermission(String roleId) {
		sqlSessionTemplate.delete(getMapperMethodId("deleteRolePermission"),roleId);
	}

}
