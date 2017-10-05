package com.fruit.web.quartz.system;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.fruit.web.service.system.count.SystemLogService;

/**
 * 首页清除
 * 
 * @author jzx
 * @date 2016-09-12 10:08:14 
 */
public class SystemMethodQuartz implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		SystemLogService systemLogService = (SystemLogService) wac.getBean(SystemLogService.class);
		systemLogService.cleanLogByDate();
	}

}
