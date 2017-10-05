package com.fruit.web.controller.shop;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.service.shop.WeixinShopCartService;

/**
 * 购买-购物车管理
 * 
 * @author jzx
 * @date 2016-9-21 15:16:47
 *
 */
@Controller
@RequestMapping({ "/weixinShopCartController" })
public class WeixinShopCartController extends BaseController {

	@Resource
	private WeixinShopCartService shopCartService;
	
	@RequestMapping(value = "weixinShopCart")
	public ModelAndView weixinShopCart(ModelMap map) {
		map.put("data", shopCartService.loadShopCartByAccountId(""));
		return new ModelAndView("shop/cart/shopCartList");
	}
}
