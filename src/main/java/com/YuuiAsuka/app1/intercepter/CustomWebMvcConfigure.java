package com.YuuiAsuka.app1.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //把自己的拦截器加进去，对特定路径进行拦截
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");
        registry.addInterceptor(new SecondIntercepter()).addPathPatterns("/api2/*/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
