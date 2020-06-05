package com.es.test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.es.class_loader.SubClass;
import com.es.common.util.MD5;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ClassLoaderTest {

	public static void main(String[] args) {
		String value = SubClass.value;
		
		Timestamp create_timestamp = Timestamp.valueOf("2019-9-6 11:10:10");
		System.out.println(create_timestamp);
		String group_name ="1,2,3,";
		group_name = group_name.substring(0, group_name.length()-1);
		System.out.println(group_name);
		
		String json_str = "[{\"nickname\":\"安宥真\",\"avatar\":\"http://192.168.173.22:9090/api/get?filename=e3191a89-0351-4311-a41b-a4ce82e0b4b1\",\"account\":\"anyujin2003\"},{\"nickname\":\"曺柔理\",\"avatar\":\"http://192.168.173.22:9090/api/get?filename=89ab9d31-8e29-4ac5-ae77-ac40d210de69\",\"account\":\"joyuri2001\"}]";
		List<Map> parseArray = JSONArray.parseArray(json_str,Map.class);
		System.out.println(parseArray);
		Gson gson = new Gson();
		List<Map<String,Object>> fromJson = gson.fromJson(json_str, new TypeToken<List<Map<String,Object>>>(){}.getType());
		System.out.println(fromJson);
	}
}
