package com.kx.demo.tt.dao.redis;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/10/9 1:23 下午
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/7/13 5:26 下午
 */
@Slf4j
@Component
public class Ress {


    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> attribute;


    private static final String proxy = "0x21da12f8";

    private static final String proxyNumber = "0xffff1111";


    public void save() {
        attribute.set("asdfgh", "1233211234567123123");
    }

    public String get() {
        return attribute.get("asdfgh");
    }

}
