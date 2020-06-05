package com.es.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

@Configuration
public class RedisConfig {
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.jedis.pool.max-active}")
	private int maxTotal;
	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;
	@Value("${spring.redis.jedis.pool.max-wait}")
	private int maxWaitMillis;
	@Bean
	public JedisShardInfo jedisShardInfo() {
		JedisShardInfo jedisShardInfo = new JedisShardInfo(this.host,this.port);
		return jedisShardInfo;
	}
	
	@Bean 
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(maxTotal);
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setTestOnBorrow(true);
		return jedisPoolConfig;
	}
	
	@Bean
	public ShardedJedisPool shardedJedisPool() {
		List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>();
		jedisShardInfoList.add(jedisShardInfo());
		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig(),jedisShardInfoList);
		return shardedJedisPool;
	}
	
}
