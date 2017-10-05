package com.fruit.web.controller.weixin.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.web.controller.WeixinCore;
import com.fruit.web.service.weixin.OrderUserInfoService;
import com.fruit.web.service.weixin.WeixinAccountService;
import com.fruit.web.service.weixin.home.WfruitHomeService;
import com.fruit.web.service.weixin.shop.WeixinShopGoodsService;
import com.fruit.web.weixin.api.wxuser.user.JwUserAPI;
import com.fruit.web.weixin.core.exceptionm.WexinReqException;
import com.fruit.web.weixin.core.utils.WeixinUtil;
import com.fruit.web.weixin.model.OrderUserInfo;
import com.fruit.web.weixin.model.common.Wxuser;

/**
 * @author jzx
 * @date 2016-9-19 12:01:17 星期一
 * @desc 微信首页
 */
@Controller
@RequestMapping("/wfruitHomeController")
public class WfruitHomeController extends WeixinCore<Object> {

	@Autowired
	private WeixinAccountService weixinAccountService;
	@Autowired
	private OrderUserInfoService orderUserInfoService;
	@Autowired
	private WeixinShopGoodsService shopGoodsService;
	@Autowired
	private WfruitHomeService wfruitHomeService;

	/**
	 * 微信主页面跳转 页面数据初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gohome", method = RequestMethod.GET)
	public ModelAndView home() {
		try {
			String code = getPara("code");
			String tempopenid = (String) getAttrSession("openid");
			String openid = tempopenid == null ? WeixinUtil.getOpenIdByCode(code) : tempopenid;
			String newAccessToken = weixinAccountService.getAccessToken();
			Wxuser wxuser = JwUserAPI.getWxuser(newAccessToken, openid);
			OrderUserInfo orderUserInfo = wfruitHomeService.getOrderUserInfo(openid);
			if (orderUserInfo == null) {
				orderUserInfo = new OrderUserInfo();
				orderUserInfo.setOpenid(openid);
				orderUserInfo.setCity(wxuser.getCity());
				orderUserInfo.setCountry(wxuser.getCountry());
				orderUserInfo.setEffectiveflag("0");
				orderUserInfoService.create(orderUserInfo);
			}
			setAttrSession("openid", openid);
			setAttr("data", shopGoodsService.list());
			setAttrSession("orderUserInfo", orderUserInfo);
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		return new ModelAndView("weixin/index");
	}

}
