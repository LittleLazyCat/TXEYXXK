package com.fruit.core.db;

import com.fruit.core.web.utils.Base64;
import com.fruit.core.web.utils.Bundle;

/**
 * 群里之前有个人问了这个问题
 * 
 * 写这个类的目的加密数据库 用户名和密码避免明文出现
 * 
 * @date 2016-7-19 14:14:12 星期二
 * @author jzx
 * 
 * 以下所有代码都来源于2.0项目，下载地址
 * https://git.oschina.net/lookseaeveryday/lkv2.0
 */
public class EncryptPropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {

	private EncryptPropertyPlaceholderConfigurer() {}
	
	private static EncryptPropertyPlaceholderConfigurer instances = new EncryptPropertyPlaceholderConfigurer();
	
	public static EncryptPropertyPlaceholderConfigurer getInstances() {
		return instances;
	}
	
	public String[] getEncryptPropNames() {
		return encryptPropNames;
	}
	
	public void setEncryptPropNames(String[] encryptPropNames) {
		this.encryptPropNames = encryptPropNames;
	}
	
	// db.properties
	private String[] encryptPropNames = {"db.username","db.password"};
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if(isEncryptProp(propertyName)) {
			return Bundle.convUTF8(Base64.decryptBASE64(propertyValue),"utf-8");
		} else {
			return propertyValue;
		}
	}

	private boolean isEncryptProp(String propertyName) {
		for(String encryptPropName : encryptPropNames) {
			if(encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
