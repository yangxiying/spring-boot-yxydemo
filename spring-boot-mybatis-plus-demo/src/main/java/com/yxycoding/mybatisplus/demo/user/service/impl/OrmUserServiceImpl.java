package com.yxycoding.mybatisplus.demo.user.service.impl;

import com.yxycoding.mybatisplus.demo.user.entity.OrmUser;
import com.yxycoding.mybatisplus.demo.user.mapper.OrmUserMapper;
import com.yxycoding.mybatisplus.demo.user.service.IOrmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表 服务实现类
 * </p>
 *
 * @author yangxy
 * @since 2019-11-23
 */
@Service
public class OrmUserServiceImpl extends ServiceImpl<OrmUserMapper, OrmUser> implements IOrmUserService {

}
