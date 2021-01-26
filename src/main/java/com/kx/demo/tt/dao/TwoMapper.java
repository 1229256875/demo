package com.kx.demo.tt.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.kx.demo.tt.pojo.Two;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kx
 * @since 2020-10-07
 */
@DS("slave")
@Repository
public interface TwoMapper extends BaseMapper<Two> {


    @Select("select * from tb_tow")
    List<Two> select();


}
