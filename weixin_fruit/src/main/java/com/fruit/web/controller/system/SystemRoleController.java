package com.fruit.web.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.SystemRole;
import com.fruit.web.model.SystemRolePermission;
import com.fruit.web.service.system.SystemMenuService;
import com.fruit.web.service.system.SystemPermissionService;
import com.fruit.web.service.system.SystemRolePermissionService;
import com.fruit.web.service.system.SystemRoleService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 角色管理
 * 
 * @author jzx 
 * @date 2016/1/28 
 * 
 */
@Controller  
@RequestMapping("/role") 
public class SystemRoleController extends BaseController {

	@Autowired
	private SystemRoleService roleService;
	@Autowired
	private SystemRolePermissionService rolePermissionService;
	@Autowired
	private SystemMenuService systemMenuService;
	@Autowired
	private SystemPermissionService systemPermissionService;
	
	/**
     * 查询用角色列表
     */
    @RequestMapping(value = "list" , method = RequestMethod.GET)  
    public String selectRole(ModelMap map) {
    	List<SystemRole> data = roleService.queryByList(null);
    	map.put("data", data);
    	return "admin/role_list";
    }
    
    /**
     * 添加角色
     */
    @RequestMapping(value = "addRole" , method = RequestMethod.POST)
    public String addRole(SystemRole systemRole) {
    	systemRole.setName(getPara("name"));
    	systemRole.setRoleCode(getPara("name"));
    	systemRole.setDescription(getPara("desc"));
    	
    	Integer role_id = roleService.create(systemRole);
    	String[] check = getParaValues("check"); // 获取选中的菜单
    	
    	for(int i =0 ; i< check.length; i++) {
    		SystemRolePermission permission = new SystemRolePermission();
    		permission.setRoleId(role_id);
    		permission.setPermissionId(parseInt(check[i]));
    		rolePermissionService.create(permission);
    	}
    	return "redirect:/role/list";
    }
    
    /**
     * 修改角色
     */
    @RequestMapping(value = "updateRole" , method = RequestMethod.POST)
    public String updateRole(SystemRole role) {
    	role.setRoleCode(role.getName());
    	role.setId(getParaToInt("id"));
    	roleService.update(role);
    	
    	roleService.deleteRolePermission(role.getId().toString());
    	
    	String[] check = getParaValues("check"); // 获取选中的菜单 
    	
    	List<SystemRolePermission> batch = Lists.newArrayList();
    	
    	for(int i =0 ; i< check.length; i++) {
    		SystemRolePermission permission = new SystemRolePermission();
    		permission.setRoleId(role.getId());
    		permission.setPermissionId(parseInt(check[i]));
    		batch.add(permission);
    	}
    	rolePermissionService.createOfBatch(batch);
    	return "redirect:/role/list";
    }
    
    /**
 	 * 跳转到添加角色页面
 	 */
     @RequestMapping(value = "toAddRole" , method = RequestMethod.GET)  
     public ModelAndView toAddRole(ModelMap map) {
     	List<Map<String,Object>> all = systemPermissionService.permissionAllList();
     	map.put("all", all);
     	return new ModelAndView("admin/role_add",map);
     }
    
    /**
     * 跳转到修改角色页面
     */
    @RequestMapping(value = "toUpdateRole/{id}" , method = RequestMethod.GET)
    public ModelAndView toUpdateRole(@PathVariable String id) {
    	Map<String,Object> maps = Maps.newHashMap();
    	
    	List<Map<String,Object>> check = roleService.getRolePermissions(id);
    	
    	// 1)获取所有菜单
    	List<Map<String,Object>> allMenu = systemMenuService.select();
    	// 2)获取所有子菜单
    	for (Map<String, Object> a : allMenu) {
    		for (Map<String, Object> c : check) {
    			if(String.valueOf(a.get("ID")).equals(String.valueOf(c.get("ID")))) {
    				a.put("menu", true);
    			}
    		}
    		List<Map<String,Object>> subMenu = systemMenuService.selectSubMenu(a.get("ID").toString());
    		
    		// 3)获取所有功能
    		for(Map<String,Object> b : subMenu) {
    			for (Map<String, Object> c : check) {
        			if(String.valueOf(b.get("ID")).equals(String.valueOf(c.get("ID")))) {
        				b.put("submenu", true);
        			}
        		}
    			List<Map<String,Object>> funMenu = systemMenuService.selectSubMenu(b.get("ID").toString());
    			for(Map<String,Object> f : funMenu) {
        			for (Map<String, Object> c : check) {
            			if(String.valueOf(f.get("ID")).equals(String.valueOf(c.get("ID")))) {
            				f.put("funmenu", true);
            			}
            		}
    			}
    			b.put("funMenu", funMenu);
    		}
    		a.put("subMenu", subMenu);
		}
    	maps.put("role", roleService.findById(parseInt(id)));
    	maps.put("check", check);
    	maps.put("allMenu", allMenu);
    	return new ModelAndView("admin/role_update",maps);
    }
}
