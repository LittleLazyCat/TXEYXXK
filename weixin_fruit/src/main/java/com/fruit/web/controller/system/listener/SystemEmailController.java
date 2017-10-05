package com.fruit.web.controller.system.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fruit.web.controller.BaseController;
import com.fruit.web.model.Mail;
import com.fruit.web.model.MailLog;
import com.fruit.web.service.system.listener.SystemEmailLogService;
import com.fruit.web.service.system.listener.SystemEmailService;


/**
 * 系统邮件管理
 * @author jzx
 * @date 2016-09-14
 */
@Controller
@RequestMapping("/email")
public class SystemEmailController extends BaseController {

	@Autowired
	private SystemEmailService systemEmailService;
	@Autowired
	private SystemEmailLogService systemEmailLogService;

	/**
	 * 人员列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap map, Mail mail) {
		List<Mail> list = systemEmailService.queryByObject(mail);
		map.put("data", list);
		return "listener/email_list";
	}
	
	/**
	 * 发送邮件 
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public void send(@RequestParam String type,
					 @RequestParam String path,
					 @RequestParam String title,
					 @RequestParam String content,
					 @RequestParam String toAddress,MailLog mail) {
		systemEmailService.send(title, content, toAddress, path, type);
		
		mail.setMessage(content);
		mail.setAddress(toAddress);
		systemEmailLogService.create(mail);
		
		renderJson200();
	}
	
	/**
	 * 添加邮件人员
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
	public void add(Mail mail) {
		mail.setStatus("1");
		systemEmailService.create(mail);
		renderJson200();
	}

	/**
	 * 删除人员
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.POST, RequestMethod.GET })
	public String delete() {
		systemEmailService.removeById(parseInt(getPara("id")));
		return "redirect:/email/list";
	}
	
	/**
	 * 跳转到发送邮件页面
	 */
	@RequestMapping(value = "/toSend/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	public String toSend(@PathVariable String id, ModelMap map) {
		map.addAllAttributes(convertObj2Map(systemEmailService.findById(parseInt(id))));
		return "listener/email_send";
	}

	/**
	 * 跳转到人员添加页面
	 */
	@RequestMapping(value = "/toAdd", method = { RequestMethod.POST, RequestMethod.GET })
	public String toAdd() {
		return "listener/email_add";
	}
}
