package com.fruit.web.service.shop;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.weixin.model.WeixinShopGoods;

public interface WeixinShopGoodsService extends IBaseDao<WeixinShopGoods, String> {

	public List<Map<String,Object>> loadGoodsByAccountId(String accountId);
	
	public List<WeixinShopGoods> loadGoodsByCategory(String categoryId);
	
	public void delGoodsById(String id);

	public ResultVO delGoods(String id);

	public ResultVO addGoods(WeixinShopGoods goods);

	public ResultVO updGoods(WeixinShopGoods goods);
}
