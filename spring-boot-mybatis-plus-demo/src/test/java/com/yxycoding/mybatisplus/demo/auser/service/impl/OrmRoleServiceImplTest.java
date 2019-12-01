package com.yxycoding.mybatisplus.demo.auser.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.yxycoding.mybatisplus.demo.auser.entity.OrmRole;
import com.yxycoding.mybatisplus.demo.auser.service.IOrmRoleService;
import com.yxycoding.mybatisplus.demo.user.entity.OrmUser;
import com.yxycoding.mybatisplus.demo.user.service.IOrmUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
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

        OrmRole ormRole = new OrmRole().setName(null);

        List<OrmRole> ormRoles = iOrmRoleService.list(new QueryWrapper<OrmRole>(ormRole));
        iOrmRoleService.selecttest();
        System.out.println("");

        QueryWrapper<OrmRole> ormRoleQueryWrapper = new QueryWrapper<>();
        ormRoleQueryWrapper.eq("a.id",null);
//
        List list = iOrmRoleService.selecttest2(ormRoleQueryWrapper);

        System.out.println(""+list.size());
    }
}