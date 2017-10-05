package com.fruit.web.service.system.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.core.form.MapWapper;
import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.web.utils.MapUtils;
import com.fruit.core.web.utils.ResultVO;
import com.fruit.web.mapper.system.SystemIconMapper;
import com.fruit.web.model.SystemIcon;
import com.fruit.web.service.system.SystemIconService;

@Service
public class SystemIconServiceImpl extends BaseDao<SystemIcon, Integer> implements SystemIconService {

	@Autowired
	private SystemIconMapper systemIconMapper;

	@Override
	public List<Map<String, Object>> loadIcon() {
		return systemIconMapper.loadIcon();
	}

	@Override
	public ResultVO addicon(MapWapper<String, String> map) {
		try {
			SystemIcon icon = new SystemIcon();
			MapUtils.toObject(icon, map.toMap());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultVO delIcon(Integer id) {

		return null;
	}
	
	
}
