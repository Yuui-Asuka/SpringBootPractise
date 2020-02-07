package com.YuuiAsuka.app1.filter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//标记一个类为filter，被spring进行扫描
@WebFilter(urlPatterns = "/api/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    //初始化，启动容器的时候
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("init filter");
    }
    //进入请求过滤器的时候，请求被拦截的时候调用
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String userName = request.getParameter("username");
        if("YuuiAsuka".equals(userName)){
         filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //filter适合非前后端分离的任务
            response.sendRedirect("/filter.html");
            return;
        }

    }
    //在容器被销毁的时候调用
    @Override
    public void destroy() {
    System.out.println("destroy filter");
    }
}
