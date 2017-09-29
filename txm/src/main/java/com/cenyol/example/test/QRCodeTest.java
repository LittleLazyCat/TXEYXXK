package com.cenyol.example.test;

import com.cenyol.example.utils.QRCodeUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class QRCodeTest {

	public static void main(String[] args) {
		String text = "http://www.baidu.com";
		String yundanhao = "403034892688";
		String myId="432828197407193013";
		//Logo
		// QRCodeUtil.encode(text, null, "e:\\", true);
		//
		// QRCodeUtil.encode(text, "e:\\csdn.jpg", "e:\\", true);
		//

		/*try {
			QRCodeUtil.encode(text, "e:\\hwm.jpg", "e:\\", true);
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// try {
		// System.out.println(QRCodeUtil.decode("e:\\92542777.jpg"));
		// System.out.println("");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			QRCodeUtil.getBarcodeWriteFile(myId, 200, 10, new File("id.png"));
			System.out.println("一维码生成");
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
//		try {
//			System.out.println(QRCodeUtil.decode("id.png"));
//			System.out.println("");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
