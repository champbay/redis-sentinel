package com.champbay.blog.redissentinel;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedissentinelApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RedissentinelApplication.class, args);
		
		RedisTemplate<String,String> redisTemplate = (RedisTemplate<String, String>) ctx.getBean("redisTemplate");
		
		for(int i=0;i<100000;i++) {
			try {
				redisTemplate.boundValueOps("test-" + i).set("" + i);
				
				System.out.println("test-" + i);
				
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
