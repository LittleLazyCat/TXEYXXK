package com.fruit.web.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.fruit.web.model.SystemUser;



public class UserUtil {
	
	
	/**
	 * 获取当前用户session
	 * @return session
	 */
	public static Session getSession(){
		Session session =SecurityUtils.getSubject().getSession();
		return session;
	}
	
	/**
	 * 获取当前用户httpsession
	 * @return httpsession
	 */
	public static Session getHttpSession(){
		Session session =SecurityUtils.getSubject().getSession();
		return session;
	}
	
	/**
	 * 获取当前用户对象
	 * @return user
	 */
	public static SystemUser getCurrentUser(){
		Session session =SecurityUtils.getSubject().getSession();
		if(null!=session){
			return (SystemUser) session.getAttribute("user");
		}else{
			return null;
		}
		
	}
}
 