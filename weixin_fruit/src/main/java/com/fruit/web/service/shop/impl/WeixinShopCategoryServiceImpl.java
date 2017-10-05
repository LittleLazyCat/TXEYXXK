package com.fruit.web.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.service.shop.WeixinShopCategoryService;
import com.fruit.web.service.shop.WeixinShopGoodsService;
import com.fruit.web.weixin.model.WeixinShopCategory;
import com.fruit.web.weixin.model.WeixinShopGoods;

@Service
public class WeixinShopCategoryServiceImpl extends BaseDao<WeixinShopCategory, String> implements WeixinShopCategoryService {

	@Resource
	private WeixinShopGoodsService shopGoodsService;
	
	@Override
	public ResultVO delCategory(String id) {
		ResultVO resultVO = new ResultVO(true);
		List<WeixinShopGoods> goods = shopGoodsService.loadGoodsByCategory(id);
		if(!goods.isEmpty()) {
			resultVO.setOk(false);
			resultVO.setMsg("存在商品不能删除");
		} else {
			boolean flag = removeById(id);
			if(!flag) {
				resultVO.setOk(false);
				resultVO.setMsg("删除失败");
			}
		}
		return resultVO;
	}

	@Override
	public ResultVO addCategory(WeixinShopCategory category) {
		ResultVO resultVo = new ResultVO(true);
		if("".equals(category.getName())) {
			resultVo.setOk(false);
			resultVo.setMsg("分类名称不能为空");
		} else {
			create(category);
			resultVo.setMsg("添加成功");
		}
		return resultVo;
	}

	@Override
	public ResultVO updCategory(WeixinShopCategory category) {
		ResultVO resultVo = new ResultVO(true);
		if("".equals(category.getName())) {
			resultVo.setOk(false);
			resultVo.setMsg("分类名称不能为空");
		} else if("".equals(category.getId())) {
			resultVo.setOk(false);
			resultVo.setMsg("ID不能为空");
		} else {
			update(category);
			resultVo.setMsg("修改成功");
		}
		return resultVo;
	}

}
