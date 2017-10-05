package com.fruit.web.service.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.SystemUser;

public interface SystemUserService extends IBaseDao<SystemUser, Integer> {

	public boolean checkLogin(@Param("username") String name,@Param("password") String password);
	
	public SystemUser getUserInfo(String username);
	
	public List<Map<String,Object>> selectUser();
	
}
