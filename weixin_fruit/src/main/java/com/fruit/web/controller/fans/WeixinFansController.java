package com.fruit.web.controller.fans;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.controller.BaseController;
import com.fruit.web.service.fans.WeixinFansService;


@Controller
@RequestMapping("/weixinFansController")
public class WeixinFansController extends BaseController {

	@Autowired
	private WeixinFansService fansService;
	
	@RequestMapping(value = "list")
	public ModelAndView list(ModelMap map) {
		map.put("data", fansService.list());
		return new ModelAndView("fans/fans_list");
	}
	
	
	@RequestMapping(value = "samefans")
	public @ResponseBody
					ResultVO sameFans() {
		ResultVO resultVO;
		List<Map<String, Object>> templist = fansService.list();
		if (templist != null && templist.size() > 0) {
			resultVO = fansService.getWeiXinUserInfoList(templist.get(0).get("")+"", "");
		} else {
			resultVO = fansService.getWeiXinUserInfoList("0", "");
		}
		return resultVO;
	}
}
