package com.example.demo.redis;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	/*
	 * 注意，存储的类需要实现序列化
	 * 即加上implements Serializable
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		/*
		 * 将对象以json的形式序列化
		 * redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class)); 
		 * 将对象以toString形式序列化
		 * redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		 */
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class)); 
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}

}