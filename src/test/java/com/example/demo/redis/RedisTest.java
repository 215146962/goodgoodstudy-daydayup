package com.example.demo.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired 
	private RedisUtil redisUtil;
	
	
	@Test
	public void set() {
		User user = new User();
		user.age = 7;
		user.name = "小霸王";
		user.sex = "男";
		redisUtil.set("myKey1", user);
		System.out.println(redisUtil.get("myKey1"));
	}

}
