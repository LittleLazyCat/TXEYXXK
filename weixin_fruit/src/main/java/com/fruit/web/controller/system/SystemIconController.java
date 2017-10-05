package com.fruit.web.controller.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.core.annotation.FormModel;
import com.fruit.core.form.MapWapper;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.controller.BaseController;
import com.fruit.web.service.system.SystemIconService;

/**
 * 系统图标的管理
 * 
 * @author jzx
 * @date 2016-9-22 9:38:31 星期四
 * 
 */
@Controller
@RequestMapping("system")
public class SystemIconController extends BaseController {

	@Resource
	private SystemIconService systemIconService;

	/**
	 * 主页
	 */
	@RequestMapping(value = "/icon")
	public String icon(ModelMap model) {
		model.addAttribute("data", systemIconService.loadIcon());
		return "icon/icon-list";
	}

	/**
	 * 添加图标
	 */
	@RequestMapping(value = "/addicon", method = RequestMethod.POST)
	public @ResponseBody 
			ResultVO addIcon(@FormModel("map") MapWapper<String, String> map) {
		return systemIconService.addicon(map);
	}

	/**
	 * 删除图标
	 */
	@RequestMapping(value = "/delicon/{id}")
	public @ResponseBody 
			ResultVO delIcon(@PathVariable Integer id) {
		return systemIconService.delIcon(id);
	}

	/**
	 * 跳转到添加页面
	 */
	@RequestMapping(value = "/toAddicon")
	public String toAddicon(ModelMap model) {
		return "icon/icon-add";
	}
}
