package com.kx.demo.util;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/18 2:27 下午
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class ApplicaltionUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        if (ApplicaltionUtil.applicationContext == null) {
            ApplicaltionUtil.applicationContext = applicationContext;
            System.out.println("==============================================" +
                    "========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
                    + applicationContext + "==========");
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过类名称获取Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        if (getApplicationContext() == null)
            return null;
        return getApplicationContext().getBean(clazz);
    }
}