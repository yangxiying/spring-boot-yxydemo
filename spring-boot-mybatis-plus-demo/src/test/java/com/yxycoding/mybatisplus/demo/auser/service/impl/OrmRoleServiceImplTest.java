package com.yxycoding.mybatisplus.demo.auser.service.impl;

import com.yxycoding.mybatisplus.demo.auser.entity.OrmRole;
import com.yxycoding.mybatisplus.demo.auser.service.IOrmRoleService;
import com.yxycoding.mybatisplus.demo.user.entity.OrmUser;
import com.yxycoding.mybatisplus.demo.user.service.IOrmUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrmRoleServiceImplTest {

    @Autowired
    IOrmRoleService iOrmRoleService;
    @Test
    public void test1() throws Exception{
        Map<String, Object> map = iOrmRoleService.getMap(null);
        List<OrmRole> ormRoles = iOrmRoleService.getBaseMapper().selectList(null);
        iOrmRoleService.selecttest();
        System.out.println("");
    }
}