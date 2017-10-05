package com.fruit.web.service.system.count.impl;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.mapper.system.count.SystemLogMapper;
import com.fruit.web.model.SystemLog;
import com.fruit.web.service.system.count.SystemLogService;

@Service
public class SystemLogServiceImpl extends BaseDao<SystemLog, Integer> implements SystemLogService {

	@Autowired
	private SystemLogMapper systemLogMapper;
	
	@Override
	public void cleanLogByDate() {
		// come on
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -5);
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DAY_OF_MONTH, -2);
		systemLogMapper.cleanLogByDate(format(c.getTime()), format(c2.getTime()));
	}
	
	private String format(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
