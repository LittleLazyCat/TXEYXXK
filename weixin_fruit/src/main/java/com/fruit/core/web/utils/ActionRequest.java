package com.fruit.core.web.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author jzx
 * @date 2016.6.3
 * @desc baseController 工具类
 */
public final class ActionRequest {

	public static String getPara(String name, HttpServletRequest request) {
		return request.getParameter(name);
	}

	public static String getPara(String name, String defaultValue, HttpServletRequest request) {
		String result = request.getParameter(name);
		return result != null && !"".equals(result) ? result : defaultValue;
	}

	public static String[] getParaValues(String name, HttpServletRequest request) {
		return request.getParameterValues(name);
	}

	public static Object getAttr(HttpServletRequest request, String key) {
		return request.getAttribute(key);
	}

	public static Enumeration<String> getAttrs(HttpServletRequest request) {
		return request.getAttributeNames();
	}

	public static void setAttr(HttpServletRequest request, String key, Object value) {
		request.setAttribute(key, value);
	}

	public static void setAttrs(HttpServletRequest request, Map<String, Object> map) {
		for (Map.Entry<String, Object> m : map.entrySet()) {
			request.setAttribute(m.getKey(), m.getValue());
		}
	}

	public static void renderJson(String data, HttpServletResponse response) {
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static <T> T getModel(Class<T> modelClass, HttpServletRequest request) {
		return (T) inject(modelClass, request);
	}
	
	public static <T> T getModel(Class<T> modelClass,String modelName,HttpServletRequest request) {
		return (T) inject(modelClass,modelName, request);
	}

	private static <T> T inject(Class<?> modelClass, HttpServletRequest request) {
		String modelName = null;
		return (T) inject(modelClass, modelName, request);
	}

	private static final <T> T inject(Class<?> modelClass, String modelName, HttpServletRequest request) {
		Object model = null;
		try {
			model = modelClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		injectCommonModel(model, modelName, request, modelClass);
		return (T) model;
	}

	private static final void injectCommonModel(Object model, String modelName, HttpServletRequest request,
			Class<?> modelClass) {
		Method[] methods = modelClass.getMethods();
		// 当modelName为null或者“”时，不添加前缀
		String modelNameAndDot = "";
		if (StrKit.notEmpty(modelName)) {
			modelNameAndDot = modelName + ".";
		}
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("set") == false) // only setter method
				continue;

			Class<?>[] types = method.getParameterTypes();
			if (types.length != 1) // only one parameter
				continue;

			String attrName = methodName.substring(3);
			String value = request.getParameter(modelNameAndDot + StrKit.firstCharToLowerCase(attrName));

			if (value != null) {
				try {
					method.invoke(model, TypeConverter.convert(types[0], value));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
