package com.fruit.web.controller.system;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.Permission;
import com.fruit.web.model.SystemRolePermission;
import com.fruit.web.service.system.SystemIconService;
import com.fruit.web.service.system.SystemMenuService;
import com.fruit.web.service.system.SystemPermissionService;
import com.fruit.web.service.system.SystemRolePermissionService;

/**
 * 菜单管理
 * 
 * @author jzx
 * @date 2016.6.18
 */
@Controller
@RequestMapping("/permission")
public class SystemMenuController extends BaseController {

	@Autowired
	private SystemRolePermissionService rolePermissionService;
	@Autowired
	private SystemMenuService systemMenuService;
	@Autowired
	private SystemPermissionService permissionService;
	@Resource
	private SystemIconService systemIconService;
	
	/**
	 * 获取权限列表
	 */
	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(ModelMap map) {
		map.put("dataMenu", systemMenuService.select());
		return "admin/menu_list";
	}

	/**
	 * tree 菜单
	 */
	@RequestMapping(value = "tree", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Map<String, Object>> tree() throws IOException {
		List<Map<String, Object>> menu = systemMenuService.select();
		return systemMenuService.treeBiz(menu);
	}

	/**
	 * 第二层tree
	 */
	@RequestMapping(value = "tree/{pid}", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Map<String, Object>> tree2(@PathVariable String pid) throws IOException {
		List<Map<String, Object>> permission = systemMenuService.selectSubMenu(pid);
		return systemMenuService.tree2Biz(permission);
	}

	/**
	 * 添加子菜单
	 */
	@RequiresPermissions("sys:subperm:add")
	@RequestMapping(value = "/addSubMenu", method = RequestMethod.POST)
	public String addSubMenu(Permission permission) {
		systemMenuService.create(permission);
		return "redirect:/permission/list";
	}
	
	/**
	 * 修改主菜单
	 */
	@RequestMapping(value = "/updateMenu", method = { RequestMethod.POST})
	public ModelAndView updateMenu(Permission permission) {
		permissionService.update(permission);
		return new ModelAndView("redirect:/permission/list");
	}

	/**
	 * 获取子菜单列表
	 */
	@RequestMapping(value = "submenu/{pid}", method = { RequestMethod.POST, RequestMethod.GET })
	public String submenu(@PathVariable String pid, ModelMap map) {
		map.put("pid", pid);
		map.put("dataMenu", systemMenuService.selectSubMenu(pid));
		return "admin/submenu_list";
	}

	/**
	 * 修改子菜单
	 */
	@RequiresPermissions("sys:subperm:update")
	@RequestMapping(value = "/updateSubMenu", method = RequestMethod.POST)
	public String updateSubMenu(Permission permission) {
		systemMenuService.update(permission);
		return "redirect:/permission/list";
	}

	/**
	 * 删除子菜单
	 */
	@RequiresPermissions("sys:subperm:delete")
	@RequestMapping(value = "delsubmenu/{sid}/{pid}", method = { RequestMethod.POST, RequestMethod.GET })
	public String delsubmenu(@PathVariable String sid, @PathVariable String pid) throws IOException {
		// 先删除关联表
		SystemRolePermission rolePermission = new SystemRolePermission();
		rolePermission.setPermissionId(Integer.valueOf(sid));
		rolePermissionService.remove(rolePermission);

		// 在删除主表
		systemMenuService.removeById(sid);

		return "redirect:/permission/submenu/" + pid;
	}

	/**
	 * 添加主菜单
	 */
	@RequiresPermissions("sys:perm:add")
	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public String addMenu(Permission permission) {
		systemMenuService.create(permission);
		return "redirect:/permission/list";
	}
	
	/**
	 * 删除主菜单
	 */
	@RequestMapping(value = "delmenu/{pid}" , method = { RequestMethod.POST, RequestMethod.GET })
	public String delmenu(@PathVariable String pid) {
		Map<String,Object> menu = convertObj2Map(permissionService.findById(parseInt(pid)));
		List<Map<String,Object>> subMenu =  systemMenuService.selectSubMenu(pid);
		
		if(subMenu.isEmpty() || !subMenu.isEmpty()) {
			SystemRolePermission systemRolePermission = new SystemRolePermission();
			systemRolePermission.setPermissionId(parseInt(menu.get("id")+""));
			rolePermissionService.remove(systemRolePermission);
		}
		
		if(subMenu.isEmpty()) {
			permissionService.removeById(parseInt(menu.get("id") + ""));
		}
		
		if(!subMenu.isEmpty()) {
			for(Map<String,Object> s : subMenu) {
				permissionService.removeById(parseInt(s.get("id") + ""));
			}
		}
		return "redirect:/permission/list";
	}

	/**
	 * 跳转到添加菜单页面
	 */
	@RequestMapping(value = "/toAddMenu", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toAddMenu(HttpServletRequest request) {
		setAttr("data", systemIconService.loadIcon());
		return new ModelAndView("admin/menu_add");
	}
	
	/**
	 * 跳转到编辑菜单页面
	 */
	@RequestMapping(value = "/toEditMenu/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toEditMenu(@PathVariable String id) {
		Map<String,Object> permission = convertObj2Map(permissionService.findById(Integer.parseInt(id)));
		ModelMap model = new ModelMap("data",permission);
		model.put("id", id);
		setAttr("data2", systemIconService.loadIcon());
		return new ModelAndView("admin/menu_update",model);
	}

	/**
	 * 跳转到添加子菜单页面
	 */
	@RequestMapping(value = "/toAddSubMenu/{pid}", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toAddSubMenu(@PathVariable String pid) {
		return new ModelAndView("admin/submenu_add", "pid", pid);
	}

	/**
	 * 跳转到编辑子菜单页面
	 */
	@RequestMapping(value = "/toEditSubMenu/{id}/{pid}", method = { RequestMethod.POST, RequestMethod.GET })
	public String toEditSubMenu(@PathVariable String id, @PathVariable String pid, ModelMap map) {
		Permission permission = systemMenuService.findById(id);
		map.put("id", id);
		map.put("pid", pid);
		map.addAllAttributes(convertObj2Map(permission));
		return "admin/submenu_update";
	}
}
