package com.fruit.web.service.system.listener.impl;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.web.model.MailLog;
import com.fruit.web.service.system.listener.SystemEmailLogService;

@Service
public class SystemEmailLogServiceImpl extends BaseDao<MailLog, Integer> implements SystemEmailLogService {

}
