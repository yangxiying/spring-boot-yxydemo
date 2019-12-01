package com.yxycoding.mybatisplus.demo.generatorext.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxycoding.mybatisplus.SpringBootMybatisPlusDemoApplication;
import com.yxycoding.mybatisplus.demo.user.service.IOrmUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleRelMapperTest  {


    @Autowired
    UserRoleRelMapper userRoleRelMapper;
    @Test
    public void qryUserRoleRel() {
    }

    @Test
    public void testMy(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("a.id",1);
        List list = userRoleRelMapper.qryUserRoleRel(queryWrapper);

        System.out.println("");
    }
}