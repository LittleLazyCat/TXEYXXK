package com.fruit.web.controller.system.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruit.web.controller.BaseController;
import com.fruit.web.service.system.listener.SystemCornService;

/**
 * quartz corn 表达式维护
 * @author jzx
 * @date 2016-9-23 10:32:47
 *
 */
@Controller
@RequestMapping("/systemCornController")
public class SystemCornController extends BaseController {

	@Autowired
	private SystemCornService systemCornService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "/list")
	public String list(ModelMap map) {
		map.addAttribute("data", systemCornService.loadCorn());
		return "listener/corn_list";
	}
	
	/**
	 * 跳转到表达式添加页面
	 */
	@RequestMapping(value = "/addCorn",method = RequestMethod.POST)
	public String addCorn(@RequestParam String desc,
						  @RequestParam String corn) {
		systemCornService.addCorn(desc, corn);
		return "redirect:/systemCornController/list";
	}
	
	/**
	 * 表达式删除
	 */
	@RequestMapping(value = "delCorn/{id}") 
	public String delCorn(@PathVariable String id) {
		systemCornService.removeCorn(id);
		return "redirect:/systemCornController/list";
	}
	
	/**
	 * 跳转到表达式添加页面
	 */
	@RequestMapping(value = "/toAddCorn")
	public String toAddCorn(ModelMap map) {
		return "listener/corn_add";
	}
}
