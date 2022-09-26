package com.cn.zlp.shipping.mgt.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig2 implements WebMvcConfigurer {
    @Autowired
    HandlerMethodArgumentResolver requestArgumentResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        System.out.println("nihao ya22222");
        resolvers.add(requestArgumentResolver);

    }
}

