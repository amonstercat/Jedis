package com.lzc.study;

import com.lzc.study.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Map;

@SpringBootTest
class JedisApplicationTests {
    private Jedis jedis;

    @BeforeEach
    public void setup() {
      //  jedis = new Jedis("192.168.115.128", 6379);
        jedis= JedisConnectionFactory.getJedis();
        jedis.select(0);
    }

    @Test
    void testString() {
        //存入数据
        String result = jedis.setex("name",500,"kevindurant");
        System.out.println(result);
        //获取数据
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash()
    {
        jedis.hset("kane","country","England");
        jedis.hset("kane","sex","male");
       Map<String,String> map= jedis.hgetAll("mbappe");
        System.out.println(map);
    }
     @AfterEach
    void teardown()
     {
         if(jedis!=null)
         {
             jedis.close();
         }
     }
}
