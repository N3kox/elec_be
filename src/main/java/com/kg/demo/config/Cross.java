package com.kg.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Cross implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").
                allowedOriginPatterns("*"). //允许跨域域名
                allowedMethods("*"). //允许任何方法（post、get等）
                allowedHeaders("*"). //允许任何请求头
                allowCredentials(true). //带cookies信息
                exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //3600秒内不需要再发送预检验请求，可以缓存结果
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/source/term_json/**").addResourceLocations(Static.getTermJsonLocation());
    }
}