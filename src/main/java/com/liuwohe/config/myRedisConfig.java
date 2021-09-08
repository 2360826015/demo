package com.liuwohe.config;

import com.liuwohe.entity.EmployeeEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;


@Configuration
public class myRedisConfig {
    @Bean
    public RedisTemplate<Object, EmployeeEntity> empTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, EmployeeEntity> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<EmployeeEntity> empSer = new Jackson2JsonRedisSerializer<EmployeeEntity>(EmployeeEntity.class);
        template.setDefaultSerializer(empSer);
        return template;
    }
    /*@Bean
    public RedisCacheManager empCacheManger(RedisTemplate<Object, EmployeeEntity> empTemplate){
        RedisCacheManager redisManager = new RedisCacheManager(empTemplate);

        return  redisManager;
    }*/
}
