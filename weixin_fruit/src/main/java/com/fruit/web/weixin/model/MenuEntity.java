package com.fruit.web.weixin.model;


import com.fruit.core.persistence.convention.annotation.Column;
import com.fruit.core.persistence.convention.annotation.Table;


@Table(name="weixin_menuentity")
public class MenuEntity extends IdEntity {
	
	private String name;
	@Column(name="menukey")
	private String menuKey;
	private String type;//click or view
	private String url;//如果view url不能为空
	private String msgType;//消息类型，是文本消息还是图文消息
	private String templateId;//模板Id
	private String orders;
	@Column(name="fatherId")
	private String fatherId;
	@Column(name="accountId")
	private String accountId;
	
	@Column(name="fatherid")
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="menukey")
	public String getMenuKey() {
		return menuKey;
	}
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="orders")
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	
	@Column(name="msgtype")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	@Column(name="templateid")
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	@Column(name="accountid")
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
