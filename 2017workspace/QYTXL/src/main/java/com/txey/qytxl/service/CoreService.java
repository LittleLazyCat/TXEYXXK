package com.txey.qytxl.service;

import com.kp.qy.aes.AesException;
import com.kp.qy.aes.WXBizMsgCrypt;
import com.kp.qy.pojo.resp.TextMessage;
import com.kp.qy.util.Constants;
import com.kp.qy.util.MessageUtil;
import com.kp.qy.util.SendMessage;
import com.txey.qytxl.model.Dept;
import com.txey.qytxl.model.Employee;
import com.txey.qytxl.service.mybatis.DeptService;
import com.txey.qytxl.service.mybatis.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处理微信发来的信息
 *
 * @author Alex Jones
 */

public class CoreService {
    public static String reqUser;
    public static List<Dept> reqDeptList;
    public static String reqContent;


    public static void processRequest(String msg, EmployeeService employeeService, DeptService deptService, final HttpServletRequest request,
                                      HttpServletResponse response, WXBizMsgCrypt wxcpt, String timestamp, String nonce) {
        String respMessage = null;
        //员工列表
        List<Employee> employeeList = new ArrayList<Employee>();
        //部门列表
        List<Dept> deptList = new ArrayList<Dept>();


        try {
            // 默认返回的文本消息内容
            String respContent = "有问题请拨8711，谢谢！";

            System.out.println("process_msg_XML=" + msg);

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(msg);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            reqUser = fromUserName;
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

            // 文本消息，若有其他信息可以自行添加判断语句
            if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT)) {
                String content = requestMap.get("Content");
                System.out.println("Content: " + content);
                reqContent = content;

                // 查询得到员工信息，以及部门信息
                try {
                    employeeList = employeeService.findEmpByName(content);
                    deptList = deptService.findDeptByName(content);
                    reqDeptList = deptList;

                } catch (Exception e) {
                    e.printStackTrace();
                }


                //有员工，无部门信息
                if (employeeList.size() > 0 && deptList.size() == 0) {
                    respContent = CoreService.employeeMsg(employeeList, content);

                }//无员工，有部门信息
                else if (employeeList.size() == 0 && deptList.size() > 0) {
                    respContent = CoreService.deptMsg(deptList, content);

                }//无员工，无部门信息
                else if (employeeList.size() == 0 && deptList.size() == 0) {
                    respContent = "您正在查询的是\"";
                    respContent += content + "\",找不到任何您查找的信息，请再试试？";

                }

                //有员工，有部门信息
                if (employeeList.size() > 0 && deptList.size() > 0) {
                    respContent = CoreService.employeeMsg(employeeList, content);

                    Thread t = new Thread(new Runnable() {

                        public void run() {
                            System.out.println("开始执行线程。。。");
                            System.out.println("进入等待状态。。。");
                            synchronized (this) {
                                try {
                                    this.wait(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            try {
                                SendMessage.Send_msg(reqUser, "", "", MessageUtil.RESP_MESSAGE_TYPE_TEXT, Constants.AGENTID, CoreService.deptMsg(reqDeptList, reqContent));
                            } catch (Exception e) {
                                e.printStackTrace();

                            }
                            finally {
                                SendMessage.Send_msg(reqUser, "", "", MessageUtil.RESP_MESSAGE_TYPE_TEXT, Constants.AGENTID, "请输入汉字进一步查询！");
                            }

                            System.out.println("线程结束。。。");
                        }
                    });
                    t.start();

                }

            }// 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                //如果是接收菜单跳转页面事件则不需要响应

                // 事件类型
                String eventType = requestMap.get("Event");

                // 自定义菜单点击事件
                if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应
                    String eventKey = requestMap.get("EventKey");
                    System.out.println("EventKey=" + eventKey);
                    if (eventKey.equalsIgnoreCase("UserInfo")) {
                        Employee employee = employeeService.findEmpByYgbh(fromUserName);
                        respContent = CoreService.empInfo(employee);
                        System.out.println(respContent);
                    }
                }
                if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_VIEW)) {
                    respContent = "";
                }
            }

            textMessage.setContent(respContent);
            respMessage = MessageUtil.textMessageToXml(textMessage);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            respMessage = "有异常了。。。";
        }


        String encryptMsg;
        try {
            // 加密回复消息
            encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
            //请求响应
            PrintWriter out = response.getWriter();
            out.print(encryptMsg);
            out.flush();
            out.close();
        } catch (AesException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static String employeeMsg(List<Employee> employeeList, String content) {
        String respContent = "您正在查询的是：";
        if (0 == employeeList.size()) {
            respContent += content + ",找不到任何您查找的信息，请再试试？";

        } else if (1 <= employeeList.size() && 5 >= employeeList.size()) {
            respContent += content + "\r\n" + "人员搜索结果：\r\n";
            for (Employee el : employeeList) {
                if (null == el.getXnw()) {
                    el.setXnw("无");
                }
                respContent += "姓名：" + el.getYgxm() + "\r\n" + "科室：" + el.getKsmc() + "\r\n" + "手机："
                        + el.getSjch() + "\r\n" + "虚拟网：" + el.getXnw() + "\r\n";
                if (1 < employeeList.size()) {
                    respContent += "---------------------------------" + "\r\n";
                }
            }
        } else if (5 < employeeList.size()) {
            respContent += content + "\r\n数据过多，请输入更精确的人员查询信息！";
        }
        return respContent;
    }

    public static String deptMsg(List<Dept> deptList, String content) {
        String respContent = "您正在查询的是：";
        if (0 == deptList.size()) {
            respContent += content + ",找不到任何您查找的信息，请再试试？";

        } else if (1 <= deptList.size() && 6 >= deptList.size()) {

            respContent += content + "\r\n" + "科室搜索结果：\r\n";
            for (Dept dept : deptList) {
                if (dept.getDxdh().length() < 4) {
                    dept.setDxdh("无");
                }
                if (dept.getYddh().length() < 4) {
                    dept.setYddh("无");
                }
                respContent += "科室名称：" + dept.getKsmc() + "\r\n" + "电信电话：" + dept.getDxdh() + "\r\n" + "移动电话："
                        + dept.getYddh() + "\r\n";
                if (1 < deptList.size()) {
                    respContent += "---------------------------------" + "\r\n";
                }
            }
        } else if (6 < deptList.size()) {
            respContent += content + "\r\n数据过多，请输入更精确的科室查询信息！";
        }
        return respContent;
    }


    public static String empInfo(Employee employee) {
        String respContent;
        if (null == employee.getSjch()) {
            employee.setSjch("无");
        }
        if (null == employee.getXnw()) {
            employee.setXnw("无");
        }
        respContent = "姓名：" + employee.getYgxm() + "\r\n" + "科室：" + employee.getKsmc() + "\r\n" + "手机："
                + employee.getSjch() + "\r\n" + "虚拟网：" + employee.getXnw() + "\r\n" + "<a href ='" + Constants.webUrl + "/UserInfo.html?userBh=" + employee.getYgbh() + "'>点击修改个人信息</a>";
        return respContent;

    }

}
