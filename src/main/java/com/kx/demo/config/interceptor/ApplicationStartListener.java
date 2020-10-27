package com.kx.demo.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/6 11:25 上午
 */
@Slf4j
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null ) {

        }
    }
}
