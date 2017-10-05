package com.fruit.web.service.system.listener.impl;

import org.springframework.stereotype.Service;

import com.fruit.core.persistence.convention.BaseDao;
import com.fruit.core.web.utils.SystemMail;
import com.fruit.web.model.Mail;
import com.fruit.web.service.system.listener.SystemEmailService;


@Service
public class SystemEmailServiceImpl extends BaseDao<Mail, Integer> implements SystemEmailService {

	@Override
	public void send(String title, String content, String toAddress, String path, String type) {
		if(type.equals("0")) {
			SystemMail.getInstance().sendText(title, content, toAddress);
		} else if(type.equals("1")) {
			SystemMail.getInstance().sendHTML(title, content, toAddress, path);
		}
	}

}
