package com.fruit.web.service.fans;

import java.util.List;
import java.util.Map;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.weixin.model.WeiXinUserInfo;

public interface WeixinFansService extends IBaseDao<WeiXinUserInfo, String> {

	public List<Map<String,Object>> list();

	public ResultVO getWeiXinUserInfoList(String string, String string2);

	public WeiXinUserInfo getWeiXinUserInfo(String openid, String string);

}
