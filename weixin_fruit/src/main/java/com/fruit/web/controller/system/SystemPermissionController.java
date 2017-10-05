package com.fruit.web.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.core.web.utils.StrKit;
import com.fruit.web.controller.BaseController;
import com.fruit.web.model.Permission;
import com.fruit.web.model.SystemRolePermission;
import com.fruit.web.service.system.SystemMenuService;
import com.fruit.web.service.system.SystemPermissionService;
import com.fruit.web.service.system.SystemRolePermissionService;

/**
 * 功能权限
 * 
 * @author jzx
 * @date 2016.3.24
 *
 */
@Controller
@RequestMapping("/function")
public class SystemPermissionController extends BaseController {

	@Autowired
	private SystemMenuService systemMenuService;
	@Autowired
	private SystemPermissionService permissionService;
	@Autowired
	private SystemRolePermissionService rolePermissionService;

	/**
	 * 获取功能列表
	 */
	@RequestMapping(value = "list", method = { RequestMethod.GET })
	public ModelAndView permissionList(@RequestParam(defaultValue = "") String id,
			@RequestParam(defaultValue = "") String pid) {
		List<Map<String, Object>> data = null;
		if (StrKit.notEmpty(id)) {
			data = systemMenuService.selectSubMenu(id);
		} else {
			data = systemMenuService.selectPermCode();
		}
		ModelAndView model = new ModelAndView("admin/permission_list");
		model.addObject("id", id);
		model.addObject("pid", pid);
		model.addObject("data", data);
		return model;
	}

	/**
	 * 功能添加
	 */
	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public String add(Permission permission) {
		permissionService.create(permission);
		return "redirect:/function/list";
	}

	/**
	 * 功能修改
	 */
	@RequestMapping(value = "update", method = { RequestMethod.POST })
	public String update(Permission permission) {
		permissionService.update(permission);
		return "redirect:/function/list";
	}

	/**
	 * 功能删除
	 */
	@RequestMapping(value = "delete/{id}/{pid}", method = { RequestMethod.GET })
	public String delete(@PathVariable String id, @PathVariable String pid) {
		// 先删除关联表
		SystemRolePermission rolePermission = new SystemRolePermission();
		rolePermission.setPermissionId(Integer.valueOf(id));
		rolePermissionService.remove(rolePermission);
		permissionService.removeById(parseInt(id));
		return "redirect:/function/list?id=" + pid;
	}

	/**
	 * 跳转到功能添加页面
	 */
	@RequestMapping(value = "toAdd/{id}", method = { RequestMethod.GET })
	public ModelAndView toAdd(@PathVariable String id) {
		ModelAndView view = new ModelAndView("admin/permission_add");
		view.addObject("id", id);
		return view;
	}

	/**
	 * 跳转到功能修改页面
	 */
	@RequestMapping(value = "toUpdate/{id}", method = { RequestMethod.GET })
	public ModelAndView toUpdate(@PathVariable String id) {
		ModelAndView view = new ModelAndView("admin/permission_update");
		Map<String, Object> result = convertObj2Map(permissionService.findById(parseInt(id)));
		view.addObject("id", id);
		view.addObject("data", result);
		return view;
	}
}
