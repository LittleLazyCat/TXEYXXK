package com.fruit.web.service.system.listener.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.web.mapper.system.listener.SystemCornMappper;
import com.fruit.web.service.system.listener.SystemCornService;

@Service
public class SystemCornServiceImpl implements SystemCornService {

	@Autowired
	private SystemCornMappper cornMapper;

	@Override
	public List<Map<String, Object>> loadCorn() {
		return cornMapper.loadCorn();
	}

	@Override
	public void removeCorn(String id) {
		cornMapper.removeCorn(id);
	}

	@Override
	public void addCorn(String name, String corn) {
		cornMapper.addCorn(name, corn);
	}
}
