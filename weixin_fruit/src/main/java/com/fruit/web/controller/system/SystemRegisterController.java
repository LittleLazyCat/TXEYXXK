package com.fruit.web.controller.system;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.SystemUser;
import com.fruit.web.service.system.SystemUserService;


/**
 * 注册管理器 
 * @author zhixin.jia 
 * @date 2017-2-24 20:09:30 
 * @desc QQ群310356826
 */
@Controller
public class SystemRegisterController  extends BaseController {

	@Autowired
	private SystemUserService systemUserService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String view() {
		return "system/register";
	}
	
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	public void addUser() {
		Map<SystemUser,String> map = new TreeMap<SystemUser,String>();
	}
}
