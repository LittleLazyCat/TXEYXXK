package com.fruit.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.SystemUser;
import com.fruit.web.service.system.SystemUserService;

/**
 * 修改密码
 * 
 * @author jzx 
 * @date 2016-9-12 14:05:53
 * 
 */
@Controller
@RequestMapping("system")
public class SystemForgetController extends BaseController {

	@Autowired
	private SystemUserService systemUserService;
	
	/**
	 * 跳转到修改密码页面
	 */
	@RequestMapping(value = "/forget" , method = RequestMethod.GET)
	public ModelAndView toUpdatePwd() {
		ModelAndView modelAndView = new ModelAndView("admin/admin_pwd");
		modelAndView.addObject("user", getCurrentUser());
		return modelAndView;
	}
	
	/**
	 * 修改登录密码
	 */
	@RequestMapping(value = "/forgetpwd" , method = RequestMethod.POST)
	public String updatePwd(SystemUser user) {
		systemUserService.update(user);
		return "redirect:/system/logout";
	}
}
