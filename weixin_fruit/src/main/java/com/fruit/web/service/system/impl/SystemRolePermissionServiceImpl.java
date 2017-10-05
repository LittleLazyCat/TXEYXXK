package com.fruit.web.service.system.impl;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.SystemRolePermission;
import com.fruit.web.service.system.SystemRolePermissionService;


@Service
public class SystemRolePermissionServiceImpl extends BaseDao<SystemRolePermission, Integer> implements SystemRolePermissionService {

}
