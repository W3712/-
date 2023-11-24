package com.itheima.intercepter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.MyJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class MyIntercepter implements HandlerInterceptor {

    public static final ThreadLocal threadLocal = new ThreadLocal();
    @Autowired
    private MyJwt myJwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Map<String, Object> map = myJwt.parseToken(request.getHeader("token"));
            String name = (String) map.get("Username");
            threadLocal.set(name);
            return true;
        }catch (Exception e){
            Result error = Result.error("NOT_LOGIN");
            response.getWriter().println(JSONObject.toJSON(error));
            return false;
        }
    }
}
