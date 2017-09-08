package com.thinkgem.jeesite.lzrabbit;

import com.thinkgem.jeesite.test.dao.TestAreaDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MultipleDataSourceAspectAdvice {
    @Around("execution(* com.thinkgem.jeesite.test.dao.TestAreaDao.getArea())")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        if (jp.getTarget() instanceof TestAreaDao) {
            MultipleDataSource.setDataSourceKey("hisServerDataSource");
            MultipleDataSource m = new MultipleDataSource();
            System.out.println(m.determineCurrentLookupKey());
            System.out.println("切換數據源啊，數據源！");
        }

        return jp.proceed();

    }
}
