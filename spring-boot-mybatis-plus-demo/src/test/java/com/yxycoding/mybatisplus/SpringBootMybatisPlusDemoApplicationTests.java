package com.yxycoding.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxycoding.mybatisplus.demo.generatorext.mapper.UserRoleRelMapper;
import com.yxycoding.mybatisplus.demo.user.service.IOrmUserService;
import com.yxycoding.mybatisplus.demo.user.service.impl.OrmUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootMybatisPlusDemoApplicationTests {

	@Autowired
	IOrmUserService iOrmUserService;
	@Test
	public void contextLoads() {
//		Map<String, Object> map = iOrmUserService.getMap(null);
//		System.out.println("");
	}


	@Autowired
	UserRoleRelMapper userRoleRelMapper;

	@Test
	public void testMy(){
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("a.id",1);
		List list = userRoleRelMapper.qryUserRoleRel(queryWrapper);

		System.out.println("");
	}

}
