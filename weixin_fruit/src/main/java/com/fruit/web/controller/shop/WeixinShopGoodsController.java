package com.fruit.web.controller.shop;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.core.Global;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.core.web.utils.StrKit;
import com.fruit.web.controller.BaseController;
import com.fruit.web.service.shop.WeixinShopCategoryService;
import com.fruit.web.service.shop.WeixinShopGoodsService;
import com.fruit.web.weixin.model.WeixinShopGoods;

/**
 * 商品管理
 * @author jzx
 * @date 2016-9-21 星期三 14:10：46
 *
 */
@Controller
@RequestMapping({ "/weixinShopGoodsController" })
public class WeixinShopGoodsController extends BaseController {

	@Resource
	private WeixinShopGoodsService shopGoodsService;
	@Resource
	private WeixinShopCategoryService shopCategoryService;
	
	@RequestMapping(value = "weixinShopGoods")
	public ModelAndView weixinShopGoods(ModelMap map) {
		map.put("data",shopGoodsService.loadGoodsByAccountId(""));
		return new ModelAndView("shop/base/shopGoodsList");
	}
	
	@RequestMapping(value = "/addGoods")
	public @ResponseBody 
				ResultVO addGoods(WeixinShopGoods goods,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		fileName = StrKit.random(8)+ ".jpg";
		file.transferTo(new File(Global.getConfig("upload_good") + fileName));
		goods.setTitleImg(fileName);
		return shopGoodsService.addGoods(goods);
	}
	
	@RequestMapping(value = "/updGoods")
	public @ResponseBody 
				ResultVO updGoods(WeixinShopGoods goods,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model) throws IllegalStateException, IOException {
		if(file!=null) {
			String fileName = file.getOriginalFilename();
			fileName = StrKit.random(8) + ".jpg";;
			file.transferTo(new File(Global.getConfig("upload_good") + fileName));
			goods.setTitleImg(fileName);
		}
		return shopGoodsService.updGoods(goods);
	}
	
	@RequestMapping(value = "delGoods/{id}")
	public @ResponseBody 
				ResultVO delGoods(@PathVariable String id) {
		return shopGoodsService.delGoods(id);
	}
	
	@RequestMapping(value = "toAddShopGoods")
	public ModelAndView toAddShopGoods(ModelMap map) {
		map.put("data", shopCategoryService.queryByList(null));
		return new ModelAndView("shop/base/addShopGoods");
	}
	
	@RequestMapping(value = "toUpdShopGoods")
	public ModelAndView toUpdShopGoods(ModelMap map) {
		map.put("data", shopCategoryService.queryByList(null));
		map.put("goods", shopGoodsService.findById(getPara("id")));
		return new ModelAndView("shop/base/updShopGoods");
	}
}
