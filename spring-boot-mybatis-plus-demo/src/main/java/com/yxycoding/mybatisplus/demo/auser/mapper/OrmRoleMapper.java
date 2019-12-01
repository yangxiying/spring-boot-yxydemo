package com.yxycoding.mybatisplus.demo.auser.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yxycoding.mybatisplus.demo.auser.entity.OrmRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表 Mapper 接口
 * </p>
 *
 * @author yangxy
 * @since 2019-11-23
 */
public interface OrmRoleMapper extends BaseMapper<OrmRole> {
    List selecttest();

    List selecttest2(@Param(Constants.WRAPPER) Wrapper<OrmRole> userWrapper);
}
