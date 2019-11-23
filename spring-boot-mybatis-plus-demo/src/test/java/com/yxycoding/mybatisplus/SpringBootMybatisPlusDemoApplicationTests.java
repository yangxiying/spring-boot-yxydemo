package com.yxycoding.mybatisplus;

import com.yxycoding.mybatisplus.demo.user.service.IOrmUserService;
import com.yxycoding.mybatisplus.demo.user.service.impl.OrmUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootMybatisPlusDemoApplicationTests {

	@Autowired
	IOrmUserService iOrmUserService;
	@Test
	void contextLoads() {
		Map<String, Object> map = iOrmUserService.getMap(null);
		System.out.println("");
	}

}
