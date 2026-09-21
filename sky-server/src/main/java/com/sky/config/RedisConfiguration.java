package com.sky.config;

import io.lettuce.core.dynamic.RedisCommandFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 * ClassName: RedisConfiguration
 * Package: com.sky.config
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/21 15:13
 * @Version 1.0
 */
@Configuration
@Slf4j
public class RedisConfiguration {
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("RedisTemplate初始化...");
        RedisTemplate redisTemplate = new RedisTemplate();
        //设置redis的连接工厂对象
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置redis的key序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
