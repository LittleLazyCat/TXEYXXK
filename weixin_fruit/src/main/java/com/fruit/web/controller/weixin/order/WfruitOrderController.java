package com.fruit.web.controller.weixin.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/wfruitOrderController")
public class WfruitOrderController {

	@RequestMapping(value = "weixinOrder")
	public ModelAndView weixinContent(ModelMap map) {
		return new ModelAndView("weixin/order/order");
	}
}
