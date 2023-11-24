package com.itheima.configuration;

import com.itheima.intercepter.MyIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyIntercepterConfiguration implements WebMvcConfigurer {
    @Autowired
    private MyIntercepter myIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

       registry.addInterceptor(myIntercepter).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
