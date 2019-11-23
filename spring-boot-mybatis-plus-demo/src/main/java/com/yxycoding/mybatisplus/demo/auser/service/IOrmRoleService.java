package com.yxycoding.mybatisplus.demo.auser.service;

import com.yxycoding.mybatisplus.demo.auser.entity.OrmRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表 服务类
 * </p>
 *
 * @author yangxy
 * @since 2019-11-23
 */
public interface IOrmRoleService extends IService<OrmRole> {

    int selecttest();
}
