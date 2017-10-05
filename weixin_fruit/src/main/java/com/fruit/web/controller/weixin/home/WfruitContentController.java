package com.fruit.web.controller.weixin.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.WeixinCore;
import com.fruit.web.service.shop.WeixinShopCategoryService;
import com.fruit.web.service.shop.WeixinShopGoodsService;
import com.fruit.web.weixin.model.WeixinShopCategory;
import com.fruit.web.weixin.model.WeixinShopGoods;

@Controller
@RequestMapping("/wfruitContentController")
public class WfruitContentController extends WeixinCore<Object> {

	@Autowired
	private WeixinShopGoodsService goodsService;
	@Autowired
	private WeixinShopCategoryService categoryService;
	
	@RequestMapping(value = "weixinContent")
	public ModelAndView weixinContent(ModelMap map) {
		WeixinShopGoods goods = goodsService.findById(getPara("id"));
		WeixinShopCategory category = categoryService.findById(goods.getCategoryId().toString());
		map.put("goods",goods);
		map.put("category", category);
		return new ModelAndView("weixin/content");
	}
}
