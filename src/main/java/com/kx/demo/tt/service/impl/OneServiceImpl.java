package com.kx.demo.tt.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.kx.demo.tt.pojo.One;
import com.kx.demo.tt.dao.OneMapper;
import com.kx.demo.tt.service.IOneService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kx
 * @since 2020-10-07
 */
@Service
public class OneServiceImpl extends ServiceImpl<OneMapper, One> implements IOneService {

    @Autowired
    private OneMapper onemapper;

    @Override
    public Object select() {
        return onemapper.selectData();
    }
}
