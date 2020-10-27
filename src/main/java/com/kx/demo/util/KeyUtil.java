package com.kx.demo.util;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/6/24 2:53 上午
 */
public class KeyUtil {


    public static String getKeys() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return className + "." + methodName;
    }
}
