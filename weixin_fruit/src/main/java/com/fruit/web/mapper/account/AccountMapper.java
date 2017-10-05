package com.fruit.web.mapper.account;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface AccountMapper {

	@Select("SELECT * FROM weixin_account ")
	public List<Map<String, Object>> loadAccountByUserName();
}
