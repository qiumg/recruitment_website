package com.website.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class DefaultConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("login");

    }


//    // 定义一个区域改变的拦截器  并注册到spring 容器中
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor(){
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("l");
//        return localeChangeInterceptor;
//    }
//    // 将拦截器注册到拦截器队列中
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/asserts/**","/index.html","/user/login");
//    }
}
