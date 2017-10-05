package com.fruit.web.service.system;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.SystemRole;

public interface SystemRoleService extends IBaseDao<SystemRole, Integer>  {

	public List<Map<String, Object>> getUserRoles(String userid);
	
	public List<Map<String, Object>> getRolePermissions(String id);
	
	public void deleteRolePermission(String roleId);
}
