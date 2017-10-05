package com.fruit.web.service.shop.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.mapper.shop.WeixinShopCartMapper;
import com.fruit.web.service.shop.WeixinShopCartService;
import com.fruit.web.weixin.model.WeixinShopCart;

@Service
public class WeixinShopCartServiceImpl implements WeixinShopCartService {

	@Autowired
	private WeixinShopCartMapper shopCartMapper;
	
	@Override
	public List<Map<String, Object>> loadShopCartByAccountId(String accountId) {
		return shopCartMapper.loadShopCartByAccountId(accountId);
	}

	@Override
	public List<WeixinShopCart> getShopCartByGoodsId(String goodsId) {
		return shopCartMapper.getShopCartByGoodsId(goodsId);
	}

}
