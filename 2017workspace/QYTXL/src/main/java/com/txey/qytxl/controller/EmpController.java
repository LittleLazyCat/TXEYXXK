package com.txey.qytxl.controller;

import com.txey.qytxl.service.mybatis.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*
* 注解方式打开链接
* */
@Controller
public class EmpController {
    @Autowired
    EmployeeService employeeService;

}
