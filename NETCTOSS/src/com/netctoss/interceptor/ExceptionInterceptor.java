package com.netctoss.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Created by tan on 2017/2/9.
 */
public class ExceptionInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        try {
            return actionInvocation.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            //  处理异常，报错时转向统一的错误页面
            return "error";
        }
    }
}
