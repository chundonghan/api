package com.es.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;
import com.es.common.util.MD5;
import com.es.config.AppConfig;
import com.es.config.RedisConfig;
import com.es.dao.redis.RedisDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {AppConfig.class,RedisConfig.class})
public class RedisTest {
	@Resource
	private RedisDao redisDao;
	
	@Test
	public void testSet() {
		redisDao.set("es", "1");
		String json_str = "[{\"nickname\":\"安宥真\",\"avatar\":\"http://192.168.173.22:9090/api/get?filename=e3191a89-0351-4311-a41b-a4ce82e0b4b1\",\"account\":\"anyujin2003\"},{\"nickname\":\"曺柔理\",\"avatar\":\"http://192.168.173.22:9090/api/get?filename=89ab9d31-8e29-4ac5-ae77-ac40d210de69\",\"account\":\"joyuri2001\"}]";
		List<Map> parseArray = JSONArray.parseArray(json_str,Map.class);
		System.out.println(parseArray);
		Gson gson = new Gson();
		List<Map<String,Object>> fromJson = gson.fromJson(json_str, new TypeToken<List<Map<String,Object>>>(){}.getType());
		System.out.println(fromJson);
	}

}
