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
import com.fruit.web.weixin.model.WeixinShopCategory;

/**
 * 
 * @author jzx
 * @date 2016-09-20 14:04:46 星期二
 * @desc 微信分类管理
 */
@Controller
@RequestMapping({ "/weixinShopCategoryController" })
public class WeixinShopCategoryController extends BaseController {

	@Resource
	private WeixinShopCategoryService shopCategoryService;

	@RequestMapping(value = "weixinShopCart")
	public ModelAndView weixinShopCart(HttpServletRequest request) {
		setAttr("data", shopCategoryService.queryByList(null));
		return new ModelAndView("shop/category/shopCategoryList");
	}

	@RequestMapping(value = "/addCategory")
	public @ResponseBody 
				ResultVO addCategory(WeixinShopCategory category,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		fileName = StrKit.random(8) + ".jpg";
		file.transferTo(new File(Global.getConfig("upload_cate") + fileName));
		category.setImgurl(fileName);
		return shopCategoryService.addCategory(category);
	}
	
	
	@RequestMapping(value = "/updCategory")
	public @ResponseBody 
				ResultVO updCategory(WeixinShopCategory category,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model) throws IllegalStateException, IOException {
		if(file!=null) {
			String fileName = file.getOriginalFilename();
			fileName = StrKit.random(8)+ ".jpg";
			file.transferTo(new File(Global.getConfig("upload_cate") + fileName));
			category.setImgurl(fileName);
		}
		return shopCategoryService.updCategory(category);
	}

	/**
	 * 商品分类删除
	 */
	@RequestMapping(value = "delCategory/{id}")
	public @ResponseBody 
				ResultVO delCategory(@PathVariable String id) {
		return shopCategoryService.delCategory(id);
	}

	/**
	 * 跳转到商品分类添加页面
	 */
	@RequestMapping(value = "toAddCategory")
	public String toAddCategory(HttpServletRequest request) {
		return "shop/category/addShopCategory";
	}
	
	@RequestMapping(value = "toUpdCategory")
	public String toUpdCategory(HttpServletRequest request) {
		setAttr("data", shopCategoryService.findById(getPara("id")));
		return "shop/category/updShopCategory";
	}
}
