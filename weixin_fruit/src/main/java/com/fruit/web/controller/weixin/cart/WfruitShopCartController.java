package com.fruit.web.controller.weixin.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.WeixinCore;
import com.fruit.web.weixin.model.common.Wxuser;

/**
 * 购物车
 * 
 * @author jzx
 * @date 2016-09-28 13:46:40 星期三
 *
 */
@Controller
@RequestMapping("/wfruitShopCartController")
public class WfruitShopCartController extends WeixinCore<Object> {

	/**
	 * 微信主页面跳转 页面数据初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gocart", method = RequestMethod.GET)
	public ModelAndView goShop(Wxuser wxuser) {
		return new ModelAndView("weixin/cart/shopcar");
	}
}
