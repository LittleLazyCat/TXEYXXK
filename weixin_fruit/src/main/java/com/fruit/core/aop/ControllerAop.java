package com.fruit.core.aop;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fruit.core.annotation.LoginCase;
import com.fruit.core.utils.Printer;
import com.fruit.web.controller.BaseController;
import com.fruit.web.model.SystemLog;
import com.fruit.web.service.system.count.SystemLogService;

/**
 * @author jzx
 * @date 2016-9-14 controller 执行记录
 * @update 2016-12-27 14:36:24
 */
@Component
@Aspect
public class ControllerAop extends BaseController {

	@Autowired
	private SystemLogService systemLogService;
	
	@Pointcut("execution(* com.fruit.web.controller..*(..))")
	public void makeOneCake() {
	}

	@Before("makeOneCake()")
	public void before(JoinPoint joinPoint) {
	}

	@After("makeOneCake()")
	public void after(JoinPoint joinPoint) {
	}

	@AfterReturning("makeOneCake()")
	public void afterReturn(JoinPoint joinPoint) {
	}

	@AfterThrowing(pointcut = "makeOneCake()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
	}

	private Set<String> buildExcludedMethodName() {
		Set<String> excludedMethodName = new HashSet<String>();
		Method[] methods = BaseController.class.getMethods();
		for (Method m : methods) {
				excludedMethodName.add(m.getName());
		}
		return excludedMethodName;
	}
	
	  
	@Around(value = "makeOneCake()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		long startTime = System.currentTimeMillis();
		Object object = joinPoint.proceed();
		long endTime = System.currentTimeMillis();

		Set<String> excludedMethodName = buildExcludedMethodName();
		
		
		if (!excludedMethodName.contains(methodName)) {
			
			System.out.println("\t\t\t" + joinPoint.getTarget().getClass().getGenericSuperclass().getClass().getName());
			
			Method[] methods = joinPoint.getTarget().getClass().getMethods();
			
			for(Method m : methods) {
				if(m.getName().equals(methodName)) {
					LoginCase loginCase = m.getAnnotation(LoginCase.class);
					if(loginCase != null) {
						Printer.info("系统默认的用户名和密码分别是" + loginCase.username()  + "\t" + loginCase.password());
						break;
					}
				}
			}
			SystemLog system = new SystemLog();
			system.setIp(getIPaddr());
			if(getCurrentUser()!=null)
			system.setName(getCurrentUser().getName());
			system.setClss(targetName);
			system.setMethod(methodName);
			system.setTime((endTime - startTime) + "");
			systemLogService.create(system);
		}
		return object;
	}
}
