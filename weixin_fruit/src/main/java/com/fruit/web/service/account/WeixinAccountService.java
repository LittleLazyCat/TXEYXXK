package com.fruit.web.service.account;

import java.util.List;
import java.util.Map;

public interface WeixinAccountService {

	public List<Map<String,Object>> loadAccountByUserName(String name);

}
