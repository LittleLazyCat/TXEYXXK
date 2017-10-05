package com.fruit.web.service.weixin;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.weixin.model.WeixinAccount;

public interface WeixinAccountService extends IBaseDao<WeixinAccount, String> {

	public String getAccessToken();

	public String createMenu(String accessToken,String menu);

}
