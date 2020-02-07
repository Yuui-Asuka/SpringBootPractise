package com.YuuiAsuka.app1.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//具体拦截器的业务类
public class SecondIntercepter implements HandlerInterceptor {

    //进入controller方法之前， 做登录校验，查数据库等
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SecondPreHandler");
//        String token = request.getParameter("access_token");
//        response.getWriter().print("fail");
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    //调用controller之后，试图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("SecondPostHandler");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //整个完成之后，用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("SecondAfterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
