package com.cenyol.example.controller;

import com.cenyol.example.model.CodeEntity;
import com.cenyol.example.model.UserEntity;
import com.cenyol.example.model.aspectj.Performance;
import com.cenyol.example.model.aspectj.PerformanceImpl;
import com.cenyol.example.repository.UserRepository;
import com.cenyol.example.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sjj on 2015/10/24 0024.
 */
@Controller
public class MainController {

    // 自动装配
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private CoreService coreService;

    // 首页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public String result(HttpServletRequest request, HttpServletResponse response) throws IOException {


        //获得系统路径
        String pathName = request.getSession().getServletContext().getRealPath("");

        System.out.println(pathName);

        // 获得初始的标识码
        String myId = request.getParameter("uuid");

        //去掉末尾字符
        myId = myId.substring(0,myId.length()-1);

        //分成5组条形码
        List<CodeEntity> codeEntityList1 = coreService.generateCodeList(myId,1,pathName);
        List<CodeEntity> codeEntityList2 = coreService.generateCodeList(myId,2,pathName);
        List<CodeEntity> codeEntityList3 = coreService.generateCodeList(myId,3,pathName);
        List<CodeEntity> codeEntityList4 = coreService.generateCodeList(myId,4,pathName);
        List<CodeEntity> codeEntityList5 = coreService.generateCodeList(myId,5,pathName);


        //生成条形码并返回文件信息
        //String imageName = coreService.generateQRCode(myId,pathName);


        //添加信息到前端
        //request.setAttribute("imageName", imageName);
        request.setAttribute("code1",codeEntityList1);
        request.setAttribute("code2",codeEntityList2);
        request.setAttribute("code3",codeEntityList3);
        request.setAttribute("code4",codeEntityList4);
        request.setAttribute("code5",codeEntityList5);


        return "result";
    }


    // 用户管理
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap modelMap) {
        // 找到user表里面的所有记录
        List<UserEntity> userEntityList = userRepository.findAll();

        // 将所有的记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userEntityList);

        // 返回pages目录下的userManage.jsp
        return "userManage";
    }

    // 添加用户表单页面
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    // 添加用户处理
    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {
        // 向数据库添加一个用户
        //userRepository.save(userEntity);

        // 向数据库添加一个用户，并将内存中缓存区的数据刷新，立即写入数据库，之后才可以进行访问读取
        userRepository.saveAndFlush(userEntity);

        // 返回重定向页面
        return "redirect:/users";
    }

    // 查看用户详细信息
    // @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    // 例如：访问 localhost:8080/showUser/1 ，将匹配 userId = 1
    @RequestMapping(value = "/showUser/{userId}", method = RequestMethod.GET)
    public String showUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {
        UserEntity userEntity = userRepository.findOne(userId);
        modelMap.addAttribute("user", userEntity);
        return "userDetail";
    }

    // 更新用户信息页面
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {
        UserEntity userEntity = userRepository.findOne(userId);
        modelMap.addAttribute("user", userEntity);
        return "updateUser";
    }

    // 处理用户修改请求
    @RequestMapping(value = "/updateUserPost", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("user") UserEntity userEntity) {
        userRepository.updateUser(
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getId()
        );
        return "redirect:/users";
    }

    // 删除用户
    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") Integer userId) {
        // 删除id为userId的用户
        userRepository.delete(userId);
        // 立即刷新数据库
        userRepository.flush();
        return "redirect:/users";
    }
}