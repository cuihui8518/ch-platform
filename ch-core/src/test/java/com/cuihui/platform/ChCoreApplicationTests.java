package com.cuihui.platform;

import com.cuihui.platform.controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChCoreApplicationTests {

    private MockMvc mvc;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private JedisCluster jedisCluster;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void redisTemplateSet(){
        redisTemplate.opsForValue().set("testRedis","测试你好啊");
        String value = (String) redisTemplate.opsForValue().get("testRedis");
        System.out.println("redis key testRedis value is " + value);
    }

    @Test
    public void templateSet(){
        template.opsForValue().set("testRedis5","你好啊2");
        String value = template.opsForValue().get("testRedis2");
        System.out.println("redis key testRedis2 value is " + value);
    }

    @Test
    public void jedisClusterSet(){
        jedisCluster.set("testRedis4","你好啊3");
        String value = jedisCluster.get("testRedis3");
        System.out.println("redis key testRedis3 value is " + value);
    }
}
