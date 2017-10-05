package com.fruit.web.service.system;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.Permission;

public interface SystemPermissionService extends IBaseDao<Permission, Integer> {

	public List<Map<String, Object>> permissionList(String currentUserId);
	
	public List<Map<String, Object>> getUserPermission(String roleId);
	
	public List<Map<String, Object>> permissionAllList();
}
