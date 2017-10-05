package com.fruit.web.service.system.count;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.SystemLog;

public interface SystemLogService extends IBaseDao<SystemLog, Integer> {

	public void cleanLogByDate();


}
