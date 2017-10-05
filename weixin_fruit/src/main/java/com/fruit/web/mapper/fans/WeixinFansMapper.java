package com.fruit.web.mapper.fans;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.fruit.web.weixin.model.WeiXinUserInfo;

public interface WeixinFansMapper {

	@Select("select * from weixin_userinfo")
	public List<Map<String,Object>> list();
	
	@Select("select * from weixin_userinfo where OPENID=#{openId}")
	public WeiXinUserInfo getUserInfoByOpenId(String openId);
	
	@Insert("insert into weixin_userinfo(id,openid,accountid) values(#{id},#{openid},#{accountid})")
	public void addUserInfo(WeiXinUserInfo userInfo);
}
