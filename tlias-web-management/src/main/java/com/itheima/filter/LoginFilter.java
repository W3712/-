package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.MyJwt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter {

    @Autowired
    private MyJwt myJwt;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        转为HTTP请求
        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        获取路径
        String requestURI = request.getRequestURI();
//        跟url最后的字符做判断,满足Login就放行
        if(requestURI.endsWith("/login")){
//            放行
            filterChain.doFilter(request,servletResponse);
            return;
        }
        try {
//            判断token是否合法
            myJwt.parseToken(request.getHeader("token"));
            return;
        }catch (Exception e){
//            响应错误信息
            Result error = Result.error("NOT_LOGIN");
            servletResponse.getWriter().println(JSONObject.toJSON(error));
            return;
        }
    }
}
