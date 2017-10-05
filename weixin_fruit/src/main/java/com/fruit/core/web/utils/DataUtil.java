package com.fruit.core.web.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.http.HttpServletRequest;

public class DataUtil {

	public static byte[] getBytesFromObject(Object obj) throws IOException {
		byte[] bytes = null;
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			bytes = bo.toByteArray();
		} finally {
			if (bo != null) {
				bo.close();
			}
			if (oo != null) {
				oo.close();
			}
		}
		return bytes;
	}

	public static Object getObjectFromByteArray(byte[] bytes) throws IOException, ClassNotFoundException {
		Object obj = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			if (bytes == null) {
				return null;
			}
			bi = new ByteArrayInputStream(bytes);
			oi = new ObjectInputStream(bi);
			obj = oi.readObject();
		} finally {
			if (bi != null) {
				bi.close();
			}
			if (oi != null) {
				oi.close();
			}
		}
		return obj;
	}

	private static final String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";

	public static String getIpAddr(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr(); // 先获取ip
		String x;
		if ((x = request.getHeader(HEADER_X_FORWARDED_FOR)) != null) {// 加入存在这个头，可以判断是有进过代理的
			remoteAddr = x;
			int idx = remoteAddr.indexOf(','); // 获取第一个,的下标
			if (idx > -1) {
				remoteAddr = remoteAddr.substring(0, idx);// 拿到第一个IP地址就是真实的IP地址
			}
		}
		return remoteAddr;
	}
}
