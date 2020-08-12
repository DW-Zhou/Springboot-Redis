package com.dengzhou.config;

import com.dengzhou.bean.User;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisConfig {

    @Bean
   // @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, User> empRedisTemplate(RedisConnectionFactory connectionFactory) throws UnknownException {
        RedisTemplate<Object,User> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        Jackson2JsonRedisSerializer<User> se = new Jackson2JsonRedisSerializer<User>(User.class);
        redisTemplate.setDefaultSerializer(se);
        return redisTemplate;
    }
    @Primary
    @Bean
    public RedisCacheManager deptManager(RedisTemplate<Object,User> redisTemplate){
        return null;
    }
}
