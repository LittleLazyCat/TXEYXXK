package com.kp.qy.web;

import com.kp.qy.aes.AesException;
import com.kp.qy.aes.WXBizMsgCrypt;
import com.kp.qy.util.Constants;
import com.txey.qytxl.model.Employee;
import com.txey.qytxl.service.CoreService;
import com.txey.qytxl.service.mybatis.DeptService;
import com.txey.qytxl.service.mybatis.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 注解方式打开链接
 */
@Controller
public class CoreController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DeptService deptService;

    private String token = Constants.TOKEN;
    private String encodingAESKey = Constants.encodingAESKey;
    private String corpId = Constants.CORPID;


    @RequestMapping(value = {"/CoreServlet.html"}, method = RequestMethod.GET)
    public void coreJoinGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 微信加密签名
        String msg_signature = request.getParameter("msg_signature");
        System.out.println("msg_signature:" + msg_signature);
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        System.out.println("timestamp:" + timestamp);
        // 随机数
        String nonce = request.getParameter("nonce");
        System.out.println("nonce:" + nonce);
        // 随机字符串
        String echostr = request.getParameter("echostr");
        System.out.println("echostr:" + echostr);

        System.out.println("request=" + request.getRequestURL());

        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        String result = null;
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);

            // 需要返回的明文
            result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
            System.out.println("result:" + result);

        } catch (AesException e) {
            // 验证URL失败，错误原因请查看异常
            e.printStackTrace();
        }
        if (result == null) {
            result = token;
        }

        out.print(result);
        out.flush();
        out.close();
    }

    @RequestMapping(value = {"/CoreServlet.html"}, method = RequestMethod.POST)
    public void coreJoinPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 微信加密签名
        String msg_signature = request.getParameter("msg_signature");
        System.out.println("msg_signature: " + msg_signature);

        // 时间戳
        String timestamp = request.getParameter("timestamp");
        System.out.println("timestamp: " + timestamp);

        // 随机数
        String nonce = request.getParameter("nonce");
        System.out.println("nonce: " + nonce);

        // 从请求中读取整个post数据
        try {
            ServletInputStream in = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String sReqData = "";
            String itemStr = "";
            while (null != (itemStr = reader.readLine())) {
                sReqData += itemStr;
            }
            String msg = "";
            WXBizMsgCrypt wxcpt = null;
            try {
                wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
                // 解密消息
                msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, sReqData);
            } catch (AesException e) {
                e.printStackTrace();
            }
            System.out.println("msg= " + msg);


            // 调用核心业务类接收消息、处理消息，可以自行修改代码，以便符合实际开发需

            CoreService.processRequest(msg, employeeService, deptService, request, response, wxcpt, timestamp, nonce);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //修改用户信息
    @RequestMapping(value = {"/UserInfo.html"}, method = RequestMethod.GET)
    public ModelAndView loadUserInfo(HttpServletRequest request) throws IOException {
        String userAgent = request.getHeader("User-Agent");
        if(-1==userAgent.indexOf("MicroMessenger")){
            return  new ModelAndView("safePage");
        }else{
            // 微信加密签名
            String ygbh = request.getParameter("userBh");
            Employee employee = employeeService.findEmpByYgbh(ygbh);
            request.setAttribute("ygxm", employee.getYgxm());
            request.setAttribute("ksmc", employee.getKsmc());
            //request.setAttribute("ygxb", employee.getYgxb());
            request.setAttribute("ygbh",ygbh);

            if (null == employee.getSjch()) {
                request.setAttribute("sjch", "");
            } else {
                request.setAttribute("sjch", employee.getSjch());
            }
            if (null == employee.getXnw()) {
                request.setAttribute("xnw", "");
            } else {
                request.setAttribute("xnw", employee.getXnw());
            }
            return new ModelAndView("index");
        }

    }


    @RequestMapping(value = {"/updateEmp.html"}, method = RequestMethod.POST)
    public ModelAndView updateUserInfo(HttpServletRequest request) throws IOException {
        Employee employee = new Employee();
        employee.setYgbh(request.getParameter("ygbh"));
        //String ygxb = request.getParameter("ygxb");
        //employee.setYgxb(Integer.parseInt(ygxb));
        employee.setSjch(request.getParameter("sjch"));
        employee.setXnw(request.getParameter("xnw"));
        System.out.println(employee);
        try{
            employeeService.updateEmp(employee);
            return new ModelAndView("Success");
        }catch (Exception e){

            e.printStackTrace();
            return new ModelAndView("Failure");
        }
    }






    //测试网站是否正常运行
    @RequestMapping(value = {"/help.html"})
    public ModelAndView helpPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return new ModelAndView("helpPage");
    }





    //测试网站是否正常运行
    @RequestMapping(value = {"/test.html"})
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return new ModelAndView("test");
    }


}
