package com.kx.demo.config.config;

import com.kx.demo.config.interceptor.SecurityOcmsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/10/24 9:16 上午
 */
@Configuration
@ComponentScan("com.kx.demo")
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean
    SecurityOcmsInterceptor securityOcmsInterceptor() {
        return new SecurityOcmsInterceptor();
    }

    @Override
    //注册拦截器,并添加拦截规则和排除规则
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityOcmsInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/index","/error", "/api/login", "/api/register");
    }

}
