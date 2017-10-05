package com.fruit.web.controller.system.count;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.web.controller.BaseController;
import com.fruit.web.service.system.SystemLoginService;

/**
 * 系统访问统计
 * 
 * @date 2016-09-14
 * @author jzx
 */
@Controller
@RequestMapping("/logcount")
public class SystemCountVisitController extends BaseController {

	@Autowired
	private SystemLoginService systemLoginService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "/count/visit_list";
	}

	/**
	 * 系统访问个数 --数据图
	 */
	@RequestMapping(value = "/actDataArray", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Map<String, Object> actDataArray(@RequestParam String type) {
		return systemLoginService.actDataArray(type);
	}
}
