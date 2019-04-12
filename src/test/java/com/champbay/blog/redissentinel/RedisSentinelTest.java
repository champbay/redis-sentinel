package com.champbay.blog.redissentinel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedissentinelApplication.class)
public class RedisSentinelTest {
	
	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	
	@Test
	public void testInsertMany() {
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
