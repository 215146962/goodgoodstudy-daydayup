package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper") // 用户扫描mapper接口
public class GoodgoodstudyDaydayupApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodgoodstudyDaydayupApplication.class, args);
	}

}
