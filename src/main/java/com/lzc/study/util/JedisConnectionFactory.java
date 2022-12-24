package com.lzc.study.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private  static  final JedisPool jedispool;
    static {
        //配置连接池
        JedisPoolConfig  jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMinIdle(0);
        //创建连接池对象
        jedispool=new JedisPool(jedisPoolConfig,"192.168.115.128",6379,1000);
    }

    public  static Jedis getJedis()
    {
        return  jedispool.getResource();
    }
}
