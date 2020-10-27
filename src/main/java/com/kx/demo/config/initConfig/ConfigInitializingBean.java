package com.kx.demo.config.initConfig;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/9/22 2:49 下午
 */

@Configuration
public class ConfigInitializingBean implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }


    @PostConstruct
    public void initSchedule() throws Exception {

    }


}
