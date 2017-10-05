package com.fruit.web.controller.weixin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruit.web.controller.WeixinCore;
import com.fruit.web.service.weixin.WeixinAccountService;
import com.fruit.web.weixin.model.WeixinAccount;
import com.fruit.web.weixin.utils.SignUtil;

/**
 * 参考微信开发文档
 * @author jzx
 * @date 2016-9-18 11:05:37 星期日
 */
@Controller
@RequestMapping("/wechatController")
public class WechatController extends WeixinCore<Object> {
	
	@Autowired
	private WeixinAccountService weixinAccountService;
	
	/**
	 * 微信接入验证，处理接入
	 * @param request
	 * @param response
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	@RequestMapping(value="wechat", method = RequestMethod.GET)
	public void wechatGet(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "signature") String signature,
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "nonce") String nonce,
			@RequestParam(value = "echostr") String echostr) {

		List<WeixinAccount> weixinAccountEntities = weixinAccountService.queryByList(null);
		for (WeixinAccount account : weixinAccountEntities) {
			if (SignUtil.checkSignature(account.getAccounttoken(), signature,
					timestamp, nonce)) {
				try {
					response.getWriter().print(echostr);
					break;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
