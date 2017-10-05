package com.fruit.web.controller.weixin.talk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fruit.web.controller.WeixinCore;
import com.fruit.web.weixin.model.common.Wxuser;

@Controller
@RequestMapping("/wfruitTalkController")
public class WfruitTalkController extends WeixinCore<Object> {

	
	/**
	 * 微信主页面跳转 页面数据初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gotalk", method = RequestMethod.GET)
	public String goTalk(Wxuser wxuser) {
		return "weixin/talk/talk";
	}
	
	
	/**
	 * 微信主页面跳转 页面数据初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gocontent", method = RequestMethod.GET)
	public String goContent(Wxuser wxuser) {
		return "weixin/talk/talkcon";
	}
}
