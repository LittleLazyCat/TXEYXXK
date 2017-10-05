package com.fruit.web.service.shop;

import java.util.List;
import java.util.Map;

import com.fruit.web.weixin.model.WeixinShopCart;

public interface WeixinShopCartService {

	public List<Map<String,Object>> loadShopCartByAccountId(String accountId);
	
	public List<WeixinShopCart> getShopCartByGoodsId(String goodsId);
}
