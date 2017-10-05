package com.fruit.web.controller.system;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruit.core.annotation.LoginCase;
import com.fruit.web.controller.BaseController;

/**
 * 登录页
 * 
 * @author jzx
 */
@Controller
@RequestMapping("system")
public class SystemLoginController extends BaseController {

	/**
	 * 跳转登录页
	 */
	@LoginCase
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view() {
		return "system/login";
	}

	/**
	 * 提交登录
	 * 
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password,
			@RequestParam(value = "rememberMe", defaultValue = "0") int rememberMe, ModelMap model) {
		String ret = "system/login";

		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return ret;
		}

		AuthenticationToken token = createToken(username, password);
		if (token == null) {
			model.put("message", "用户名或密码错误");
			return ret;
		}

		if (rememberMe == 1) {
			((UsernamePasswordToken) token).setRememberMe(true);
		}

		try {
			SecurityUtils.getSubject().login(token);

			ret = "redirect:/system/home";

		} catch (AuthenticationException e) {
			if (e instanceof UnknownAccountException) {
				model.put("message", "用户不存在");
			} else if (e instanceof LockedAccountException) {
				model.put("message", "用户被禁用");
			} else {
				model.put("message", "用户认证失败");
			}
		}
		return ret;
	}
}
