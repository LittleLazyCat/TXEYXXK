package com.fruit.web.controller.system.count;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.SystemLog;
import com.fruit.web.service.system.count.SystemLogService;

/**
 * @author jzx
 * @date 2016-09-27
 */
@Controller
@RequestMapping("method")
public class SystemCountMethodController extends BaseController {

	@Autowired
	private SystemLogService systemLogService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("count/method_log");
		List<SystemLog> systemLog = systemLogService.queryByList(null);
		model.addObject("data", systemLog);
		return model;
	}
}
