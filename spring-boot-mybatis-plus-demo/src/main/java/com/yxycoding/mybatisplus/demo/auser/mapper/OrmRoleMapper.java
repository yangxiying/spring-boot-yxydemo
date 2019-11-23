package com.yxycoding.mybatisplus.demo.auser.mapper;

import com.yxycoding.mybatisplus.demo.auser.entity.OrmRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表 Mapper 接口
 * </p>
 *
 * @author yangxy
 * @since 2019-11-23
 */
public interface OrmRoleMapper extends BaseMapper<OrmRole> {
    int selecttest();
}
