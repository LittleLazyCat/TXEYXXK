package com.bruce.wechat.test;
import com.bruce.wechat.encryption.DESUtils;;
public class Test {

	public static void main(String[] args) {
		
		DESUtils desUtils = new DESUtils();
		String userName = "root";
		userName = desUtils.encodeStr(userName);
		System.out.println(userName);
	}

}
