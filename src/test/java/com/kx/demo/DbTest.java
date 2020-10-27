package com.kx.demo;

import com.kx.demo.tt.dao.OneMapper;
import com.kx.demo.tt.pojo.One;
import com.kx.demo.tt.service.IOneService;
import com.kx.demo.tt.service.impl.OneServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/10/7 12:55 上午
 */

@SpringBootTest
public class DbTest {


    @Autowired
    private OneMapper oneMapper;

    @Autowired
    private IOneService oneService;

    @Test
    public void tt() {


        List<One> list = oneService.list();


        List<One> ones = oneMapper.selectData();


        System.out.println();

    }

    @Test
    public void insert() {
        List<String> strings = Arrays.asList("zxc", "xcv");
        List<One> collect = strings.stream()
                .map(One::new)
                .collect(Collectors.toList());

//        int insert = oneMapper.insert();
//        boolean b = oneService.saveBatch(collect);

//        oneService.save(new One());

        oneMapper.selectData();

        System.out.println();

    }
}
