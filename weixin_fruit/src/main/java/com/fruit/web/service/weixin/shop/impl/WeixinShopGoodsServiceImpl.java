package com.fruit.web.service.weixin.shop.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.mapper.weixin.shop.WeixinShopCategoryMapper;
import com.fruit.web.mapper.weixin.shop.WeixinShopGoodsMapper;
import com.fruit.web.service.weixin.shop.WeixinShopGoodsService;

@Service("weixin_shopGoodsServiceImpl")
public class WeixinShopGoodsServiceImpl implements WeixinShopGoodsService {

	@Autowired
	private WeixinShopGoodsMapper shopGoodsMapper;
	@Autowired
	private WeixinShopCategoryMapper shopCategoryMapper;
	
	@Override
	public List<Map<String, Object>> list() {
		List<Map<String, Object>> data = shopCategoryMapper.list();
		for(Map<String, Object> m : data) {
			List<Map<String, Object>> goods = shopGoodsMapper.listByCategoryId(m.get("id").toString());
			m.put("goods", goods);
		}
		return data;
	}

}
