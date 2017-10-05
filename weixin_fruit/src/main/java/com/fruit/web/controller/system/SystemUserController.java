package com.fruit.web.controller.system;


import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.core.web.utils.Bundle;
import com.fruit.core.web.utils.MD5;
import com.fruit.web.controller.BaseController;
import com.fruit.web.model.SystemRole;
import com.fruit.web.model.SystemUser;
import com.fruit.web.model.SystemUserRole;
import com.fruit.web.service.system.SystemRoleService;
import com.fruit.web.service.system.SystemUserRoleService;
import com.fruit.web.service.system.SystemUserService;
import com.google.common.collect.Lists;

/**
 * 系统用户管理
 * 
 * @author jzx
 * @date 2017-9-13
 * 
 */
@Controller
@RequestMapping("/system/user")
public class SystemUserController extends BaseController {

	@Autowired
	private SystemUserService systemUserService;
	@Autowired
	private SystemRoleService systemRoleService;
	@Autowired
	private SystemUserRoleService systemUserRoleService;
	

	/**
	 * 查询用户列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView selectUser(Model model) {
		model.addAttribute("data", systemUserService.selectUser());
		return new ModelAndView("user/user_list");
	}

	/**
	 * 添加用户
	 */
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(SystemUser user) {
		user.setPassword(MD5.encodeString(user.getPassword()));
		systemUserService.create(user);
		return "redirect:/system/user/list";
	}
	
	 /**
     * 删除用户 
     */
    @RequiresPermissions("sys:user:delete")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
    	systemUserService.removeById(parseInt(id));
    	return "redirect:/system/user/list";
    }
    
    /**
     * 添加用户角色
     */
    @RequestMapping(value = "addUserRole" , method = { RequestMethod.POST, RequestMethod.GET })  
    public String addUserRole(SystemUserRole systemRole) {
    	String user_id = getPara("user_id");
    	String [] role_id = getParaValues("role_id");
    	
    	systemRole.setUserId(parseInt(user_id));
    	systemUserRoleService.remove(systemRole);
    	
    	for(int i =0 ; i< role_id.length; i++) {
    		systemRole.setRoleId(parseInt(role_id[i]));
    		systemUserRoleService.create(systemRole);
    	}
    	return "redirect:/system/user/list";
    }  
 

    /**
     * 跳转到设置角色页面
     */
    @RequestMapping(value = "toRole/{id}", method = RequestMethod.GET)
    public ModelAndView toRole(@PathVariable String id,ModelMap map) {
    	List<Map<String, Object>> self_role = systemRoleService.getUserRoles(id); // 用户拥有角色
    	List<Map<String, Object>> all_role = Lists.newArrayList(); // 所有角色
    	
    	for(SystemRole role : systemRoleService.queryByList(null)) {
    		Map<String, Object> roleMap = convertObj2Map(role);
    		all_role.add(roleMap);
    	}

    	for (Map<String, Object> all : all_role) {
    		all.put("point", 0);
			for (Map<String,Object> self : self_role) {
				if(Bundle.convStr(self.get("ID")).equals(Bundle.convStr(all.get("id")))) {
					all.put("point", 1);
				}
			}
		}
    	map.put("id", id);
    	map.put("all",all_role);
    	return new ModelAndView("user/user_role",map);
    }
    
    
	/**
	 * 跳转到添加用户页面
	 */
	@RequiresPermissions("sys:user:add")
	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
	public ModelAndView toAddUser() {
		return new ModelAndView("user/user_add");
	}
}
