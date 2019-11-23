package com.yxycoding.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yxycoding.mybatisplus.demo.**.mapper")
public class SpringBootMybatisPlusDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisPlusDemoApplication.class, args);
	}

}
