package com.fruit.web.controller.system;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fruit.web.controller.BaseController;
import com.fruit.web.service.system.SystemHomeService;
import com.fruit.web.service.system.SystemPermissionService;

/**
 * 首页
 * 
 * @author jzx
 * @date 2016-9-12
 * 
 */
@Controller
@RequestMapping("system")
public class SystemHomeController extends BaseController {

	@Autowired
	private SystemHomeService systemHomeService;
	@Autowired
	private SystemPermissionService permissionService;

	/**
	 * 用户主页
	 */
	@RequiresAuthentication
	@RequestMapping(value = "/home")
	public String home(ModelMap model) {
		List<Map<String, Object>> data = permissionService.permissionList(getCurrentUser().getId().toString());
		model.addAttribute("data", data);
		return "index/index";
	}

	/**
	 * 跳转到欢迎页
	 */
	@RequiresAuthentication
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		Map<String, Object> view = systemHomeService.welcome();
		model.addAllAttributes(view);
		return "index/welcome";
	}
}
