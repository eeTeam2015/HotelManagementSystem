package com.studentcui.hotel.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new ManagerInterceptor()).addPathPatterns("/**").excludePathPatterns("/book","/login","/login.action","/**/*.js","/**/*.css","/**/*.jpg");
        registry.addInterceptor(new ManagerInterceptor()).addPathPatterns("/room1","/room2","/room3","/room4","/room5");
    }
}
