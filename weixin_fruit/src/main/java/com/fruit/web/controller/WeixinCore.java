package com.fruit.web.controller;


import java.lang.reflect.ParameterizedType;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import com.fruit.core.web.utils.ActionRequest;

/**
 * @author jzx
 * @date 2016-9-13
 * @desc 微信核心控制器
 */
public class WeixinCore<T> extends WeiXinController<T> {

	@Override
	public String getPara(String name) {
		try {
			return ServletRequestUtils.getStringParameter(getRequest(), name);
		} catch (ServletRequestBindingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public T getModel(Class<T> modelClass) {
		return ActionRequest.getModel(modelClass, getRequest());
	}

	@Override
	public T getModel(Class<T> modelClass, String modelName) {
		return ActionRequest.getModel(modelClass, modelName, getRequest());
	}

	public T getModels() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class modelClass = (Class) pt.getActualTypeArguments()[0];
		return (T) getModel(modelClass);
	}
}
