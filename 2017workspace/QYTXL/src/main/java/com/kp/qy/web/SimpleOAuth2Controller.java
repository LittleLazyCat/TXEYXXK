package com.kp.qy.web;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kp.qy.pojo.AccessToken;
import com.kp.qy.util.Constants;
import com.kp.qy.util.QiYeUtil;
import com.kp.qy.util.Result;

/**
 * 单纯实现OAuth2验证，不使用注解及拦截器
 *
 */
@Controller
public class SimpleOAuth2Controller {
	/**
	 * 拼接网页授权链接
	 * 此处步骤也可以用页面链接代替
	 * @return
	 */
	@RequestMapping(value = { "/oauth2wx.do" })
	public String Oauth2API(HttpServletRequest request){
		//获取项目域名
		String reqUrl =request.getLocalAddr();
		//拼接微信回调地址
		String backUrl ="http://" + reqUrl + "/oauth2me.do";
		String redirect_uri = "";
		try {
			redirect_uri = java.net.URLEncoder.encode(backUrl, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + Constants.CORPID + "&redirect_uri=" + redirect_uri
				+ "&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		return "redirect:" + oauth2Url;
	}
	
	/**
	 * 授权回调请求处理
	 * @return
	 */
	@RequestMapping(value = { "/oauth2me.do" })
	public String oAuth2Url(HttpServletRequest request, @RequestParam String code){
		AccessToken accessToken = QiYeUtil.getAccessToken(Constants.CORPID, Constants.SECRET);
		HttpSession session = request.getSession();
		if (accessToken != null && accessToken.getToken() != null) {
			String Userid = getMemberGuidByCode(accessToken.getToken(), code, Constants.AGENTID);
			if (Userid != null) {
				session.setAttribute("UserId", Userid);
			}
		}
		// 这里简单处理,存储到session中
		return "user";
	}
	
	/**
	 * 调用接口获取用户信息
	 * 
	 * @param token
	 * @param code
	 * @param agentId
	 * @return
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public String getMemberGuidByCode(String token, String code, int agentId) {
		System.out.println("code==" + code + "\ntoken=" + token + "\nagentid=" + agentId);
		Result<String> result = QiYeUtil.oAuth2GetUserByCode(token, code, agentId);
		System.out.println("result=" + result);
		if (result.getErrcode() == "0") {
			if (result.getObj() != null) {
				// 此处可以通过微信授权用code还钱的Userid查询自己本地服务器中的数据
				return result.getObj();
			}
		}
		return "";
	}
}
