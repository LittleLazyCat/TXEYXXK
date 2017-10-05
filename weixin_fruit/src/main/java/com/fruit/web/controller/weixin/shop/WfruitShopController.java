package com.fruit.web.controller.weixin.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.WeixinCore;
import com.fruit.web.weixin.model.common.Wxuser;

/**
 * 
 * @author jzx
 * @date 2016-09-28 13:57:35 星期三
 * 
 */
@Controller
@RequestMapping("/wfruitShopController")
public class WfruitShopController extends WeixinCore<Object> {

	/**
	 * 微信主页面跳转 页面数据初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goshop", method = RequestMethod.GET)
	public ModelAndView goShop(Wxuser wxuser) {
		
		return new ModelAndView("weixin/shop/shop");
	}
}
