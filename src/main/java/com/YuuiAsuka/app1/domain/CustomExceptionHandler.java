package com.YuuiAsuka.app1.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

//一个全局错误捕获类
@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    Object handleException(Exception e, HttpServletRequest request){
        LOG.error("url {} msg {}",request.getRequestURL(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        map.put("getUrl", request.getRequestURL());
        return map;
    }

    @ExceptionHandler(value = MyException.class)
    Object myException(MyException e, HttpServletRequest request){
        //进行页面跳转
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg", e.getMessage());
//        return modelAndView;

        //返回错误页面的json数据，由前端判断加载什么数据
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg", e.getMessage());
        map.put("getUrl" , request.getRequestURL());
        return map;
    }
}
