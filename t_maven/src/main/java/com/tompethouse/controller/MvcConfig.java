package com.tompethouse.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/appointment").setViewName("appointment");
        registry.addViewController("/profileTest").setViewName("profileTest");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //refuse access if not login
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/profile","/appointment","/welcome");
    }

}

