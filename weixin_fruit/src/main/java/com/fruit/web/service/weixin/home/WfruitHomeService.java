package com.fruit.web.service.weixin.home;

import com.fruit.web.weixin.model.OrderUserInfo;

public interface WfruitHomeService {

	void addOrderUserInfo();

	OrderUserInfo getOrderUserInfo(String openid);

}
