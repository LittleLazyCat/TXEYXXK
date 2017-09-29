package com.kp.qy.util;

import com.txey.qytxl.model.Dept;
import com.txey.qytxl.service.CoreService;
import com.txey.qytxl.service.mybatis.DeptService;
import net.sf.json.JSONObject;

import java.util.List;

/** 
 * @author: py
 * @version:2016年12月31日 上午8:48:29 
 * com.kp.qy.util.TestSendMes.java
 * @Desc 
 */
public class SendMessage {
//  发送消息  
public static String SEND_MSG_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";  
     

public static void main(String[] args) {
    //应用ID，账号，部门为""，标签为""，消息类型，内容
    //部门不为""，标签不为""，将会给该部门的每个成员发送消息
    DeptService deptService = new DeptService();
    List<Dept> deptList = deptService.findDeptByName("xj");
    String respContent = CoreService.deptMsg(deptList,"xj");
    Send_msg("M028","","","text",Constants.AGENTID,respContent);

}
  
/**
 * @date 2016年12月31日上午10:05:07
 * @param touser 成员ID列表
 * @param toparty 部门ID列表
 * @param totag 标签ID列表
 * @param msgtype 消息类型，此时固定为：text （支持消息型应用跟主页型应用）
 * @param agentid 企业应用的id，整型。可在应用的设置页面查看
 * @param content 消息内容，最长不超过2048个字节，注意：主页型应用推送的文本消息在微信端最多只显示20个字（包含中英文）
 * @return int 表示是否是保密消息，0表示否，1表示是，默认0
 * @Des: 主动发送文字给企业用户 
 */
public static int Send_msg(String  touser,String toparty,String totag,String msgtype,int agentid,String content){  
    int errCode=0;  
    //拼接请求地址  
    String requestUrl=SEND_MSG_URL.replace("ACCESS_TOKEN",  WechatAccessToken.getAccessToken(Constants.CORPID, Constants.SECRET,1).getToken());  
    //需要提交的数据  
//    String postJson = "{\"agentid\":\"%s\",\"touser\":\"%s\",\"toparty\":\"[1,%s]\",\"totag\":\"%s\",\"msgtype\":\"text\",\"%s\":{\"content\":\"%s\"},\"safe\":\"0\"}";      
//    String postJson = "{\"agentid\":\"%s\",\"touser\":\"%s\",\"toparty\":\"%s\",\"totag\":\"%s\",\"msgtype\":\"text\",\"%s\":{\"content\":\"%s\"},\"safe\":\"0\"}";      
    String postJson = "{\"agentid\":%s,\"touser\": \"%s\",\"toparty\": \"%s\",\"totag\": \"%s\","+
     "\"msgtype\":\"%s\",\"text\": {\"content\": \"%s\"},\"safe\":0}";
    String outputStr=String.format(postJson,agentid,touser,toparty,totag,msgtype,content);  
    System.out.println(outputStr);  
    //创建成员  
    JSONObject jsonObject=HttpRequestUtil.httpRequest(requestUrl, "POST", outputStr);  
    if(null!=jsonObject){  
        System.out.println(jsonObject.toString()+"=====");  
//          int errcode = jsonObject.getInt("errcode");  
//          errCode=jsonObject.getInt("errcode");  
              
    }  
    return errCode;  
}  
}
