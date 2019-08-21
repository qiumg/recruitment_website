//package com.website.client.config;
//
//
//import com.website.client.intercepter.LoginIntercepter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//public class DefaultConfig implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("register");
//    }
//
//    // 将拦截器注册到拦截器队列中
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截其他界面
//        registry.addInterceptor(new LoginIntercepter())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static/**","/","/login","/login.html","/register","/register.html");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/static/**").addResourceLocations("classpath:/resources/static/");
//        registry.addResourceHandler("/resources/templates/**").addResourceLocations("classpath:/resources/templates/");
//    }
//
//}
