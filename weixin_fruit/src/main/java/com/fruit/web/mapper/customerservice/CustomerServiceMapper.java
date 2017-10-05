package com.fruit.web.mapper.customerservice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface CustomerServiceMapper {

	@Select("SELECT * FROM customer_service ")
	public List<Map<String, Object>> selectCustomerService();
}
