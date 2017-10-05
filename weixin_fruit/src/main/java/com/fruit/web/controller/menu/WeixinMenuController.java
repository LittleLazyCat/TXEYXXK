package com.fruit.web.controller.menu;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.controller.BaseController;
import com.fruit.web.service.menu.WeixinMenuService;
import com.fruit.web.weixin.model.MenuEntity;

/**
 * 微信自定义菜单
 * @author jzx
 * @date 2016-09-21 10:00:00 星期三
 */
@Scope("prototype")
@Controller
@RequestMapping("/menuManagerController")
public class WeixinMenuController extends BaseController {

	@Resource
	private WeixinMenuService weixinMenuService;
	
	@RequestMapping(value = "list")
	public ModelAndView list(ModelMap map) {
		map.put("data", weixinMenuService.list());
		return new ModelAndView("menu/menu_list");
	}
	
	/**
	 * 实现添加微信菜单功能
	 */
	@RequestMapping(value = "/addMenu",method = RequestMethod.POST)
	public @ResponseBody 
			ResultVO addMenu(MenuEntity menuEntity) {
		if(menuEntity.getFatherId().equals("0")) {
			menuEntity.setFatherId(null);
		}
		return weixinMenuService.addMenu(menuEntity);
	}
	
	/**
	 * 实现编辑微信菜单功能
	 */
	@RequestMapping(value = "/editMenu",method = RequestMethod.POST)
	public @ResponseBody 
			ResultVO editMenu(MenuEntity menuEntity) {
		if(menuEntity.getFatherId().equals("0")) {
			menuEntity.setFatherId(null);
		}
		return weixinMenuService.editMenu(menuEntity);
	}
	
	/**
	 * 同步微信菜单
	 */
	@RequestMapping(value = "/sameMenu")
	public @ResponseBody 
			ResultVO sameMenu() {
		return weixinMenuService.sameMenu();
	}
	
	/**
	 * 删除菜单
	 */
	@RequestMapping(value = "delMenu/{id}")
	public @ResponseBody 
			ResultVO delMenu(@PathVariable String id) {
		return weixinMenuService.delMenu(id);
	}
	
	/**
	 * 跳转到微信菜单添加页面
	 */
	@RequestMapping(value = "toAddMenu")
	public String toAddMenu(ModelMap map) {
		map.put("data", weixinMenuService.list());
		return "menu/menu_add";
	}
	/**
	 * 跳转到微信菜单修改页面
	 */
	@RequestMapping(value = "toEditMenu/{id}")
	public String toEditMenu(@PathVariable String id,ModelMap map) {
		map.put("data", weixinMenuService.list());
		map.put("obj", weixinMenuService.loadObjById(id));
		return "menu/menu_update";
	}
}
