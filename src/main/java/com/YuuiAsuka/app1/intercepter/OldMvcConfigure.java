package com.YuuiAsuka.app1.intercepter;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OldMvcConfigure extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns().excludePathPatterns();
        super.addInterceptors(registry);
    }
}
