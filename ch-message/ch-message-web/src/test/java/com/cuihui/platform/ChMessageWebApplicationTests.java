package com.cuihui.platform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChMessageWebApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void redisTemplateSet(){
        redisTemplate.opsForValue().set("testRedis","测试你好啊");
        String value = (String) redisTemplate.opsForValue().get("testRedis");
        System.out.println("redis key testRedis value is " + value);
    }

    @Test
    public void templateSet(){
        template.opsForValue().set("testRedis2","你好啊2");
        String value = template.opsForValue().get("testRedis2");
        System.out.println("redis key testRedis2 value is " + value);
    }

    @Test
    public void jedisClusterSet(){
        jedisCluster.set("testRedis3","你好啊3");
        String value = jedisCluster.get("testRedis3");
        System.out.println("redis key testRedis3 value is " + value);
    }

}
