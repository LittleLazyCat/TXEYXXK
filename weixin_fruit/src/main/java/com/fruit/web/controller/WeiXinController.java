package com.fruit.web.controller;

/**
 * 微信核心控制器类
 * @author jzx
 * @date 2016-09-05 11:00 星期一
 */
public abstract class WeiXinController<T> extends BaseController {

	public abstract String getPara(String name);
	
	public abstract  T getModel(Class<T> modelClass);
	
	public abstract  T getModel(Class<T> modelClass, String modelName);
	
}
