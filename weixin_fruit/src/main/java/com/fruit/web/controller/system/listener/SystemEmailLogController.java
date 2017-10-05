package com.fruit.web.controller.system.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.service.system.listener.SystemEmailLogService;

/**
 * @author apple
 * @date  2016-7-18 上午
 * 邮件发送记录功能
 */
@Controller
@RequestMapping("/email_log")
public class SystemEmailLogController extends BaseController {

	@Autowired
	private SystemEmailLogService systemEmailLogService;
	
	/**
	 * 查询发送人，收货人，发送内容等信息
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index(ModelAndView view) {
		view.setViewName("listener/email_log");
		view.addObject("data", systemEmailLogService.queryByList(null));
		return view;
	}
}
