package com.txey.qytxl.utils;

import org.apache.commons.codec.binary.Base64; 

public class DESUtils {
	/** 
	 * 解密 
	 *  
	 * @param pwd 
	 * @return 
	 * @see [类、类#方法、类#成员] 
	 */  
	@SuppressWarnings("static-access")
	public static String decodeStr(String pwd)  
	{  
	    Base64 base64 = new Base64();  
	    byte[] debytes = base64.decodeBase64(new String(pwd).getBytes());  
	    return new String(debytes);  
	}  
	  
	/** 
	 * 加密 
	 *  
	 * @param pwd 
	 * @return 
	 * @see [类、类#方法、类#成员] 
	 */  
	@SuppressWarnings("static-access")
	public static String encodeStr(String pwd)  
	{  
	    Base64 base64 = new Base64();  
	    byte[] enbytes = base64.encodeBase64Chunked(pwd.getBytes());  
	    return new String(enbytes);  
	}

	public static void main(String[] args) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://rm-uf6ebto8l74947413.mysql.rds.aliyuncs.com:3306/xxk?useUnicode=true&characterEncoding=utf8";
		String username = "root";//iwell_txsdermyy
		String password = "";
		// System.out.println("username = " + getEncryptString(username));
		// System.out.println("password = " + getEncryptString(password));
		// System.out.println(getDecryptString("7nU0iYq5ejbpAwYcAA6x8Q=="));
		System.out.println("username = " + encodeStr(username));
		System.out.println("password = " + encodeStr(password));
		System.out.println("driver = " + encodeStr(driver));
		System.out.println("url = " + encodeStr(url));
		System.out.println(decodeStr("aXdlbGxfdHhzZGVybXl5"));

	}
}
