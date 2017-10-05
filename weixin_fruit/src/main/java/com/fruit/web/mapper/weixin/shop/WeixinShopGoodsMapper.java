package com.fruit.web.mapper.weixin.shop;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("weixin_weixinShopGoodsMapper")
public interface WeixinShopGoodsMapper {

	public List<Map<String, Object>> list();
	
	public List<Map<String, Object>> listByCategoryId(String id);
}
