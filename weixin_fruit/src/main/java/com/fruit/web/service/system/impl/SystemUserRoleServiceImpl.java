package com.fruit.web.service.system.impl;


import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.SystemUserRole;
import com.fruit.web.service.system.SystemUserRoleService;

@Service
public class SystemUserRoleServiceImpl extends BaseDao<SystemUserRole, Integer> implements SystemUserRoleService {

}
