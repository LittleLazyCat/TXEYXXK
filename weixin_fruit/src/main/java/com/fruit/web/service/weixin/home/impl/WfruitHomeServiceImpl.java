package com.fruit.web.service.weixin.home.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.service.weixin.OrderUserInfoService;
import com.fruit.web.service.weixin.home.WfruitHomeService;
import com.fruit.web.weixin.model.OrderUserInfo;

@Service
public class WfruitHomeServiceImpl implements WfruitHomeService {

	@Autowired
	private OrderUserInfoService orderUserInfoService;
	
	@Override
	public void addOrderUserInfo() {
	}

	@Override
	public OrderUserInfo getOrderUserInfo(String openid) {
		OrderUserInfo orderUserInfo = new OrderUserInfo();
		orderUserInfo.setOpenid(openid);
		List<OrderUserInfo> lsits = orderUserInfoService.queryByObject(orderUserInfo);
		orderUserInfo = lsits != null && lsits.size() > 0 ? lsits.get(0) : null;
		return orderUserInfo;
	}

}
