package com.fruit.web.service.fans.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.persistence.convention.id.UUIDHexGenerator;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.core.web.utils.StrKit;
import com.fruit.web.mapper.fans.WeixinFansMapper;
import com.fruit.web.service.fans.WeixinFansService;
import com.fruit.web.service.weixin.WeixinAccountService;
import com.fruit.web.weixin.core.utils.WeixinUtil;
import com.fruit.web.weixin.model.WeiXinUserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class WeixinFansServiceImpl extends BaseDao<WeiXinUserInfo, String> implements WeixinFansService {

	@Resource
	WeixinFansMapper mapper;
	@Resource
	WeixinAccountService accountService;

	@Override
	public List<Map<String, Object>> list() {
		List<Map<String, Object>> data = mapper.list();
		for (Map<String, Object> d : data) {
			String userName = d.get("NICKNAME") + "";
			if (StrKit.notEmpty(userName)) {
				String nickName = new String(WeixinUtil.decode(userName));
				if (nickName != null && "".equals(nickName.trim())) {
					nickName = "nickName空的";
				}
				d.put("NICKNAME", nickName);
			}
		}
		return data;
	}

	@Override
	public ResultVO getWeiXinUserInfoList(String NEXT_OPENID, String accountId) {
		String accessToken = this.accountService.getAccessToken();
		List<WeiXinUserInfo> lists = new ArrayList<WeiXinUserInfo>();
		if (StrKit.notEmpty(accessToken)) {
			String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
			if (!"0".equals(NEXT_OPENID)) {
				url += "&next_openid=NEXT_OPENID";
			}
			String requestUrl = url.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", NEXT_OPENID);
			while ((NEXT_OPENID != null) && (!"".equals(NEXT_OPENID))) {
				JSONObject jsonObj = WeixinUtil.httpRequest(requestUrl, "GET", "");// 请求
				if (jsonObj != null) {
					Boolean result = Boolean.valueOf(jsonObj.containsKey("errmsg"));
					if (result.booleanValue())
						break;
					NEXT_OPENID = jsonObj.getString("next_openid");
					int count = jsonObj.getInt("count");
					if (count != 0) {
						JSONArray openIdArr = jsonObj.getJSONObject("data").getJSONArray("openid");
						for (int i = 0; i < openIdArr.size(); i++) {
							String openId = openIdArr.get(i).toString();
							WeiXinUserInfo tempobj = mapper.getUserInfoByOpenId(openId);
							if (tempobj == null) {
								WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo();
								weiXinUserInfo.setOpenid(openId);
								weiXinUserInfo.setAccountid(accountId);
								lists.add(weiXinUserInfo);
							}
						}
						accessToken = this.accountService.getAccessToken();
						requestUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN"
								.replace("ACCESS_TOKEN", accessToken) + "&next_openid=" + NEXT_OPENID;
					}
				}
			}
		}
		for (WeiXinUserInfo u : lists) {
			u.setId(UUIDHexGenerator.get());
			mapper.addUserInfo(u);
		}
		ResultVO vo = new ResultVO(true);
		return vo;
	}

	@Override
	public WeiXinUserInfo getWeiXinUserInfo(String openid, String accountId) {
		try {
			String accessToken = accountService.getAccessToken();
			String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN"
					.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
			JSONObject jsonObj = WeixinUtil.httpRequest(requestUrl, "GET",
					requestUrl);
			if (jsonObj != null) {
				String subscribe = jsonObj.getString("subscribe");
				if (subscribe != null && !"0".equals(subscribe)) {
					String open_id = jsonObj.getString("openid");
					String nickname = jsonObj.getString("nickname");
					String remark = jsonObj.getString("remark");
					String sex = jsonObj.getString("sex");
					String city = jsonObj.getString("city");
					String province = jsonObj.getString("province");
					String country = jsonObj.getString("country");
					String headimgurl = jsonObj.getString("headimgurl");
					String subscribetimer = jsonObj.getString("subscribe_time");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date subscribetime = sdf.parse(sdf.format(new Date(Long.parseLong(subscribetimer) * 1000)));
					WeiXinUserInfo userInfo = new WeiXinUserInfo(subscribe, open_id,
							nickname,remark, sex, city, province, country, headimgurl,
							subscribetime);
					return userInfo;
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
