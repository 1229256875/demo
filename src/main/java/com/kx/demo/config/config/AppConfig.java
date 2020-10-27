package com.kx.demo.config.config;

import com.kx.demo.config.interceptor.ApplicationStartListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author caogj
 * @create 2019-
 */
@Configuration
public class AppConfig {




    /**
     * 监视器
     *
     * @return
     */
    @Bean
    public ApplicationStartListener applicationStartListener() {
        return new ApplicationStartListener();
    }

}
