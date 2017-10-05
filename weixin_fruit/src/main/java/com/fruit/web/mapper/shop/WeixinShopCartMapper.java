package com.fruit.web.mapper.shop;

import java.util.List;
import java.util.Map;

import com.fruit.web.weixin.model.WeixinShopCart;

public interface WeixinShopCartMapper  {


	public List<Map<String,Object>> loadShopCartByAccountId(String accountId);

	public List<WeixinShopCart> getShopCartByGoodsId(String goodsId);
}
