package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/login"})
public class Myfilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("11111创建了=========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("11111拦截到=====");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("111111放行=====");
    }

    @Override
    public void destroy() {
        System.out.println("11111凉了==========");
    }
}
