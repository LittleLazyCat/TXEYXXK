package com.fruit.web.model;

import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;

public class SystemUserRole {
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}