package com.fruit.web.mapper.shop;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;

import com.fruit.web.weixin.model.WeixinShopGoods;

public interface WeixinShopGoodsMapper {

	public List<Map<String,Object>> loadGoodsByAccountId(String accountId);

	public List<WeixinShopGoods> loadGoodsByCategory(String categoryId);

	@Delete("delete from weixin_shop_goods where id=#{id}")
	public void delGoodsById(String id);
}
