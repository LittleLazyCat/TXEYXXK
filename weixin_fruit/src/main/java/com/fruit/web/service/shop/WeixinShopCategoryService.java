package com.fruit.web.service.shop;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.weixin.model.WeixinShopCategory;

public interface WeixinShopCategoryService extends IBaseDao<WeixinShopCategory, String> {

	ResultVO delCategory(String id);

	ResultVO addCategory(WeixinShopCategory category);

	ResultVO updCategory(WeixinShopCategory category);

}
