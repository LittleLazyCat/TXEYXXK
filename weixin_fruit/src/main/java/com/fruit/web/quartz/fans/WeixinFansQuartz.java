package com.fruit.web.quartz.fans;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.fruit.web.service.fans.WeixinFansService;
import com.fruit.web.weixin.core.utils.WeixinUtil;
import com.fruit.web.weixin.model.WeiXinUserInfo;

public class WeixinFansQuartz implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		WeixinFansService fansService = wac.getBean(WeixinFansService.class);
		List<WeiXinUserInfo> list = fansService.queryByList(null);
		for (WeiXinUserInfo u : list) {
			WeiXinUserInfo weiXinUserInfo = u;
			WeiXinUserInfo temp = fansService.getWeiXinUserInfo(weiXinUserInfo.getOpenid(), "");
			if (temp == null)continue;
			weiXinUserInfo.setCity(temp.getCity());
			weiXinUserInfo.setCountry(temp.getCountry());
			weiXinUserInfo.setHeadimgurl(temp.getHeadimgurl());
			String nickName = WeixinUtil.encode(temp.getNickname().getBytes());
			weiXinUserInfo.setNickname(nickName);
			weiXinUserInfo.setRemark(temp.getRemark());
			weiXinUserInfo.setOpenid(temp.getOpenid());
			weiXinUserInfo.setProvince(temp.getProvince());
			weiXinUserInfo.setSex(temp.getSex());
			weiXinUserInfo.setSubscribe(temp.getSubscribe());
			weiXinUserInfo.setSubscribetime(temp.getSubscribetime());
			weiXinUserInfo.setAddtime(new java.sql.Date(new java.util.Date().getTime()));
			fansService.update(weiXinUserInfo);
		}
	}

}
