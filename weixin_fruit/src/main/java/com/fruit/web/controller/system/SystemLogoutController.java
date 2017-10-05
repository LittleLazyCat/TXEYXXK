package com.fruit.web.controller.system;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruit.web.controller.BaseController;

/**
 * @author langhsu
 *
 */
@Controller
@RequestMapping("system")
public class SystemLogoutController extends BaseController {

	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/system/login";
	}

}
