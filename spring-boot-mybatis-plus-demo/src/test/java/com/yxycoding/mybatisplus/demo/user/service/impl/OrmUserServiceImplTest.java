package com.yxycoding.mybatisplus.demo.user.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.yxycoding.mybatisplus.demo.user.entity.OrmUser;
import com.yxycoding.mybatisplus.demo.user.service.IOrmUserService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrmUserServiceImplTest {

    @Autowired
    IOrmUserService iOrmUserService;
    @Test
    public void test1() throws Exception{
        Map<String, Object> map = iOrmUserService.getMap(null);
        List<OrmUser> ormUsers = iOrmUserService.getBaseMapper().selectList(null);
        System.out.println("");
    }

    @Test
    public void testSaveList() {
        List<OrmUser> userList = Lists.newArrayList();
        for (int i = 4; i < 14; i++) {
            String salt = IdUtil.fastSimpleUUID();
            OrmUser user = new OrmUser().setName("testSave" + i).setPassword(SecureUtil.md5("123456" + salt)).setSalt(salt).setEmail("testSave" + i + "@xkcoding.com")
                    .setPhoneNumber("1730000000" + i).setStatus(1).setLastLoginTime(new DateTime()).setCreateTime(new DateTime()).setLastUpdateTime(new DateTime());
            userList.add(user);
        }
        boolean batch = iOrmUserService.saveBatch(userList);
        Assert.assertTrue(batch);
        List<Integer> ids = userList.stream().map(OrmUser::getId).collect(Collectors.toList());
        log.debug("【userList#ids】= {}", ids);

        iOrmUserService.getBaseMapper().selectPage()
    }

}