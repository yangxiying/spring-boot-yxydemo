package com.yxycoding.mybatisplus.demo.generatorext.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.yxycoding.mybatisplus.demo.generatorext.entity.UserRoleRel;

import java.util.List;

/**
 * <p>
 * 用户和对应角色一个sql查询出来
 * </p>
 *
 * @package:  com.yxycoding.mybatisplus.demo.generatorext.mapper
 * @description: 用户和对应角色一个sql查询出来
 * @author: yangxya
 * @date: Created in 2019-12-01 18:51:27
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangxya
 */
//@Component
public interface UserRoleRelMapper extends BaseMapper<UserRoleRel> {

    List<UserRoleRel> qryUserRoleRel(@Param(Constants.WRAPPER) Wrapper<UserRoleRel> userWrapper);
}