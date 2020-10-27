package com.kx.demo.tt.service;

import com.kx.demo.tt.dao.OneMapper;
import com.kx.demo.tt.pojo.One;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kx
 * @since 2020-10-07
 */
public interface IOneService extends IService<One> {


    Object select();

}
