package com.zhaolg5.singleton.userinfo.common;

import com.zhaolg5.singleton.userinfo.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author : lingangzhao
 * @date : 2019/2/2 19:21
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private CommonInterceptor commonInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/*");
    }
}
