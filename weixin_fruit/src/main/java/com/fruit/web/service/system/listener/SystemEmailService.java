package com.fruit.web.service.system.listener;

import com.fruit.core.persistence.IBaseDao;
import com.fruit.web.model.Mail;

public interface SystemEmailService extends IBaseDao<Mail, Integer> {

	public void send(String title,String content,String toAddress,String path,String type);
}
