package com.fruit.web.service.customerservice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.mapper.customerservice.CustomerServiceMapper;
import com.fruit.web.service.customerservice.CustomerServiceService;

@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Autowired
	private CustomerServiceMapper serviceMapper;

	@Override
	public List<Map<String, Object>> selectCustomerService() {
		return serviceMapper.selectCustomerService();
	}
}
