package com.fruit.web.shiro.realm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.model.SystemUser;
import com.fruit.web.service.system.SystemPermissionService;
import com.fruit.web.service.system.SystemRoleService;
import com.fruit.web.service.system.SystemUserService;

@Service
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private SystemUserService userService;
	@Autowired
	private SystemRoleService roleService;
	@Autowired
	private SystemPermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String currentUsername = (String) super.getAvailablePrincipal(principals);
		List<String> roleList = new ArrayList<String>();
		List<String> permissionList = new ArrayList<String>();
		// //从数据库中获取当前登录用户的详细信息
		SystemUser user = userService.getUserInfo(currentUsername);
		if (null != user) {
			List<Map<String, Object>> roles = roleService.getUserRoles(user.getId().toString());
			// 实体类User中包含有用户角色的实体类信息
			if (null != roles && roles.size() > 0) {
				// 获取当前登录用户的角色
				for (Map<String, Object> role : roles) {
					roleList.add(role.get("NAME") + "");
					// 实体类Role中包含有角色权限的实体类信息
					List<Map<String, Object>> permission = permissionService
							.getUserPermission(role.get("ID").toString());
					if (null != permission && permission.size() > 0) {
						// 获取权限
						for (Map<String, Object> pmss : permission) {
							if (!StringUtils.isEmpty(pmss.get("PERM_CODE") + "")) {
								permissionList.add(pmss.get("PERM_CODE") + "");
							}
						}
					}
				}
			}
		}
		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.addRoles(roleList);
		simpleAuthorInfo.addStringPermissions(permissionList);
		return simpleAuthorInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if (token.getPassword().toString() != null && token.getUsername() != null) {
			if (userService.checkLogin(token.getUsername(), String.valueOf(token.getPassword()))) {
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(token.getUsername(),
						String.valueOf(token.getPassword()), this.getName());
				SystemUser user = userService.getUserInfo(token.getUsername());
				this.setSession("user", user);
				return authcInfo;
			}
		}
		return null;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}
}