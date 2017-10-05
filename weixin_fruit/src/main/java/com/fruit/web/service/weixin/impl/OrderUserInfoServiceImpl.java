package com.fruit.web.service.weixin.impl;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.service.weixin.OrderUserInfoService;
import com.fruit.web.weixin.model.OrderUserInfo;

@Service
public class OrderUserInfoServiceImpl extends BaseDao<OrderUserInfo, String> implements OrderUserInfoService {

}
