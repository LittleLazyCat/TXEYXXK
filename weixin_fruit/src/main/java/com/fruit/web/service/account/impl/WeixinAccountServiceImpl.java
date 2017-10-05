package com.fruit.web.service.account.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.mapper.account.AccountMapper;
import com.fruit.web.service.account.WeixinAccountService;

@Service("weixinAccountServiceImpl2")
public class WeixinAccountServiceImpl implements WeixinAccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public List<Map<String, Object>> loadAccountByUserName(String name) {
		return accountMapper.loadAccountByUserName();
	}

}
