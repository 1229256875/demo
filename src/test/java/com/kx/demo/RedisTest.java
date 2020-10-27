package com.kx.demo;

import com.kx.demo.tt.dao.redis.Ress;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/10/9 1:26 下午
 */

@Slf4j
@SpringBootTest
public class RedisTest {


    @Autowired
    private Ress ress;



    @Test
    public void tt(){
        ress.save();

        log.debug("asdads");
        System.out.println(ress.get());
    }

}
