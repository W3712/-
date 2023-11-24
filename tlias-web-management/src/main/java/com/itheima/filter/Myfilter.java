package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"})
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("创建了=========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("拦截到=====");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行=====");
    }

    @Override
    public void destroy() {
        System.out.println("凉了==========");
    }
}
