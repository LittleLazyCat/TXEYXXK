package com.fruit.web.controller.weixin.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fruit.web.weixin.model.common.Wxuser;

/**
 * 
 * @author jzx
 * @date 2016-09-29 14:21:11 星期四
 *
 * 提前祝大家国庆快乐。
 */
@Controller
@RequestMapping("/wfruitRegisterController")
public class WfruitRegisterController {

	/**
	 * 微信主页面跳转 页面数据初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String goShop(Wxuser wxuser) {
//		String code = getPara("code");
//		String newAccessToken = null;
//		String tempopenid = getAttrSessionToStr("openid");
//		try {
//			String openid = tempopenid == null ? WeixinUtil.getOpenIdByCode(code) : tempopenid;
//			newAccessToken = weixinAccountService.getAccessToken();
//			wxuser = JwUserAPI.getWxuser(newAccessToken, openid);
//			List<OrderUserInfo> lsits = orderUserInfoService.queryByList(null);
//			OrderUserInfo orderUserInfo = lsits != null && lsits.size() > 0 ? lsits.get(0) : null;
//			if (StrKit.nonNull(orderUserInfo)) {
//				setAttrSession("orderUserInfo", orderUserInfo);
//			} else {
//				orderUserInfo = new OrderUserInfo();
//				orderUserInfo.setOpenid(openid);
//				orderUserInfo.setCity(wxuser.getCity());
//				orderUserInfo.setCountry(wxuser.getCountry());
//				orderUserInfo.setEffectiveflag("0");
//				orderUserInfoService.create(orderUserInfo);
//			}
//			setAttrSession("openid", openid);
//			setAttrSession("orderUserInfo", orderUserInfo);
//			
//		} catch (WexinReqException e) {
//			e.printStackTrace();
//		}
		return "weixin/reg/reg";
	}
}
