package com.jeesite.modules.data;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MultipleDataSourceSetup {


    public void setHisDataSource() {
        MultipleDataSource.setDataSourceKey("hisDataSource");
    }


    public void setTestDataSource() {
        MultipleDataSource.setDataSourceKey("testDataSource");
    }


    public void setEmrDataSource() {
        MultipleDataSource.setDataSourceKey("emrDataSource");
    }



    public void setDataSource() {
        MultipleDataSource.setDataSourceKey("dataSource");
    }



//    @Around("execution(* com.jeesite.modules.cms.web.HeartController.heart*())")
//    public Object HeartDataSource(ProceedingJoinPoint jp) throws Throwable {
//        MultipleDataSource.setDataSourceKey("hisServerDataSource");
//        Object object =  jp.proceed();
//        MultipleDataSource.setDataSourceKey("dataSource");
//        return object;
//    }


    //    @Around("execution(* com.jeesite.modules.txey.dao.PatientDao.getPatient(..))")
//    public Object Change(ProceedingJoinPoint jp) throws Throwable {
//        MultipleDataSource.setDataSourceKey("hisDataSource");
//        Object object = jp.proceed();
//        MultipleDataSource.setDataSourceKey("dataSource");
//        System.out.println(MultipleDataSource.getDataSourceKey());
//        System.out.println("切換數據源啊，數據源！");
//        return object;
//    }


}