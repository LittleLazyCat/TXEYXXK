package com.kp.qy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kp.qy.pojo.resp.TextMessage; 
import com.kp.qy.util.MessageUtil;
import com.txey.qytxl.model.Employee;
import com.txey.qytxl.service.mybatis.EmployeeService;

/**
 * 处理微信发来的信息
 * 
 * @author Alex Jones
 *
 */

public class CoreService {

	public static String processRequest(String msg,EmployeeService employeeService) {
		String respMessage = null;

		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！请联系http://blog.csdn.net/u014520797/article/details/49722335";

			System.out.println("process_msg_XML=" + msg);

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(msg);

			// System.out.println("Event==" + requestMap.get("Event"));

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			System.out.println("fromUserName: " + fromUserName);

			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			System.out.println("toUserName: " + toUserName);

			// 消息类型
			String msgType = requestMap.get("MsgType");
			System.out.println("msgType: " + msgType);

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			// textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT)) {
				String content = requestMap.get("Content");
				System.out.println("Content: " + content);
				
				//查询得到员工信息
				List<Employee> employeeList = new ArrayList<Employee>();

				try {
					employeeList = employeeService.findEmpByName(content);
				} catch (Exception e) {
					e.printStackTrace();
				}
				respContent = "您正在查询的是\"";
				if (0 == employeeList.size()) {
					respContent +=  content + "\",找不到任何您查找的信息，请再试试？";

				} else if (1 == employeeList.size()) {

					respContent +=  content + "\"\r\n"+"人员搜索结果：\r\n" ;
					for (Employee el : employeeList) {
						if(null==el.getXnw())
						{
							el.setXnw("无");
						}
						respContent +=  "姓名：" + el.getYgxm() + "\r\n" +"科室：" + el.getKsmc() + "\r\n" + "手机：" + el.getSjch() + "\r\n"
								+ "虚拟网：" + el.getXnw() + "\r\n";

					}
				}else if (1 < employeeList.size() && 8 >=employeeList.size()) {
					respContent +=  content + "\"\r\n"+"人员搜索结果：\r\n" ;
					for (Employee el : employeeList) {
						if(null==el.getXnw())
						{
							el.setXnw("无");
						}
						respContent +=  "姓名：" + el.getYgxm() + "\r\n" + "科室：" + el.getKsmc() + "\r\n" + "手机：" + el.getSjch() + "\r\n"
								+ "虚拟网：" + el.getXnw() + "\r\n" + "---------------------------------"+ "\r\n";

					}
				}else if (8 < employeeList.size()) {
					respContent +=  content +  "\",数据过多，请输入更精确的查询信息！";
				}

			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "py提示：您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "py提示：您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "py提示：您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "py提示：您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = "";// requestMap.get("Event");

				// 自定义菜单点击事件
				if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					// String eventKey = requestMap.get("EventKey");
					// System.out.println("EventKey=" + eventKey);
					// respContent = "py提示：您点击的菜单KEY是" + eventKey;
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			respMessage = "有异常了。。。";
		}
		return respMessage;
	}

}
