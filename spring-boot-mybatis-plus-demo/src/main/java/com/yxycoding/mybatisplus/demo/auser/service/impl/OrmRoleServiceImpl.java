package com.yxycoding.mybatisplus.demo.auser.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yxycoding.mybatisplus.demo.auser.entity.OrmRole;
import com.yxycoding.mybatisplus.demo.auser.mapper.OrmRoleMapper;
import com.yxycoding.mybatisplus.demo.auser.service.IOrmRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表 服务实现类
 * </p>
 *
 * @author yangxy
 * @since 2019-11-23
 */
@Service
public class OrmRoleServiceImpl extends ServiceImpl<OrmRoleMapper, OrmRole> implements IOrmRoleService {

    public List selecttest(){
        List selecttest = this.baseMapper.selecttest();
        return selecttest;
    }

    @Override
    public List selecttest2(Wrapper wrapper) {
        List list = this.baseMapper.selecttest2(wrapper);
        return null;
    }
}
