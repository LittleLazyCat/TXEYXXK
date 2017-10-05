package com.fruit.web.controller.customerservice;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.service.customerservice.CustomerServiceService;

/**   
 * @author jzx
 * @date 2016-9-21 16:03:21 星期三
 */
@Scope("prototype")
@Controller
@RequestMapping("/customerServiceController")
public class WeixinCustomerServiceController {

	@Resource
	private CustomerServiceService serviceService;
	
	/**
	 * 客服管理列表 页面跳转
	 */
	@RequestMapping(value = "customerService", method = RequestMethod.GET)
	public ModelAndView customerService(Model model) {
		model.addAttribute("data", serviceService.selectCustomerService());
		return new ModelAndView("customerservice/customerServiceList");
	}

}
