package com.fruit.web.weixin.core.exceptionm;

/**
 * 常规异常信息
 */
public class WexinReqException extends Exception {

	private static final long serialVersionUID = 1L;

	public WexinReqException(String message){
		super(message);
	}
	
	public WexinReqException(Throwable cause)
	{
		super(cause);
	}
	
	public WexinReqException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
