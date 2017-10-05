package com.fruit.web.controller.account;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.BaseController;
import com.fruit.web.service.account.WeixinAccountService;

/**
 * 公众号管理
 * 
 * @author jzx
 * @date 2016-09-21 16:29:44 星期三
 *
 */
@Controller
@RequestMapping("/weixinAccountController")
public class WeixinAccountController extends BaseController {

	@Resource
	private WeixinAccountService accountService;
	
	/**
	 * 微信公众帐号信息列表 页面跳转
	 */
	@RequestMapping(value = "weixinAccount", method = RequestMethod.GET)
	public ModelAndView weixinAccount() {
		setAttr("data", accountService.loadAccountByUserName("")); // 暂时为空
		return new ModelAndView("account/accountList");
	}
}
