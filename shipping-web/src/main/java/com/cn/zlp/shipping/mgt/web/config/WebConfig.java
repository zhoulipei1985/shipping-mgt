package com.cn.zlp.shipping.mgt.web.config;

import com.cn.zlp.security.common.resolvers.ResponseResultResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    HandlerMethodArgumentResolver requestArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        System.out.println("nihao ya");
        resolvers.add(requestArgumentResolver);

    }
}



