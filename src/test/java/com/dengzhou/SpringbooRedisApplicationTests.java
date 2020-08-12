package com.dengzhou;

import com.dengzhou.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbooRedisApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate<Object,User> empRedisTemplate;

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().append("name","dengzhou");
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        User user = new User(1,"denz","beidou");
        redisTemplate.opsForValue().set("user-01",user);
        empRedisTemplate.opsForValue().set("user_new",user);
    }

}
