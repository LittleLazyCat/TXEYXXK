package com.fruit.web.service.shop.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.mapper.shop.WeixinShopGoodsMapper;
import com.fruit.web.service.shop.WeixinShopCartService;
import com.fruit.web.service.shop.WeixinShopGoodsService;
import com.fruit.web.weixin.model.WeixinShopCart;
import com.fruit.web.weixin.model.WeixinShopGoods;

@Service
public class WeixinShopGoodsServiceImpl extends BaseDao<WeixinShopGoods, String> implements WeixinShopGoodsService {

	@Autowired
	private WeixinShopCartService weixinShopCartService;
	@Autowired
	private WeixinShopGoodsMapper weixinShopGoodsMapper;
	
	@Override
	public List<Map<String, Object>> loadGoodsByAccountId(String accountId) {
		return weixinShopGoodsMapper.loadGoodsByAccountId(accountId);
	}

	@Override
	public List<WeixinShopGoods> loadGoodsByCategory(String categoryId) {
		return weixinShopGoodsMapper.loadGoodsByCategory(categoryId);
	}

	@Override
	public void delGoodsById(String id) {
		weixinShopGoodsMapper.delGoodsById(id);
	}

	@Override
	public ResultVO delGoods(String id) {
		ResultVO resultVO = new ResultVO(true);
		List<WeixinShopCart> goods = weixinShopCartService.getShopCartByGoodsId(id);
		if(!goods.isEmpty()) {
			resultVO.setOk(false);
			resultVO.setMsg("购物车存在商品不能删除");
		} else {
			delGoodsById(id);
		}
		return resultVO;
	}

	@Override
	public ResultVO addGoods(WeixinShopGoods goods) {
		ResultVO resultVO = new ResultVO(true);
		create(goods);
		resultVO.setMsg("添加成功");
		return resultVO;
	}

	@Override
	public ResultVO updGoods(WeixinShopGoods goods) {
		ResultVO resultVO = new ResultVO(true);
		update(goods);
		resultVO.setMsg("修改成功");
		return resultVO;
	}

}
