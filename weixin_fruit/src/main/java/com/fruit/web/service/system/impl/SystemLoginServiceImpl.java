package com.fruit.web.service.system.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.web.utils.DateUtils;
import com.fruit.core.web.utils.HighCharts;
import com.fruit.web.mapper.system.count.SystemLoginMapper;
import com.fruit.web.model.SystemLoginLog;
import com.fruit.web.service.system.SystemLoginService;

@Service
public class SystemLoginServiceImpl  extends BaseDao<SystemLoginLog, Integer> implements SystemLoginService {

	@Autowired
	SystemLoginMapper loginMapper;
	
	@Override
	public List<Map<String, Object>> select() {
		return sqlSessionTemplate.selectList(getMapperMethodId("select"));
	}
	
	@Override
	public List<Map<String, Object>> selectByDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.MONTH, 1);
		return loginMapper.selectBetweenCount(format(c.getTime()), format(c2.getTime()));
	}
	
	private  String format(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	@Override
	public Map<String, Object> actDataArray(String type) {
		Map<String, Object> result = null;
		if (type.equals("days")) {
			List<Map<String, Object>> data = loginMapper.selectNowCount(DateUtils.getNowTime());
			result = HighCharts.daysArray(data);
		} else if (type.equals("week")) {
			String[] date = DateUtils.getStartEnd();
			List<Map<String, Object>> data = loginMapper.selectBetweenCount(date[0],date[1]);
			result = HighCharts.weekArray(data);
		}
		return result;
	}

	


}
