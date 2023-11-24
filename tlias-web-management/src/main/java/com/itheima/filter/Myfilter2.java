package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/depts/*"})
public class Myfilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("222222创建了=========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("222222拦截到=====");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("22222放行=====");
    }

    @Override
    public void destroy() {
        System.out.println("22222凉了==========");
    }
}
