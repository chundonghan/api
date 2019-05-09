package com.es.service.ums.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.dao.ums.UserDao;
import com.es.service.ums.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private  UserDao userDao;

	@Override
	public Map<String, Object> login(Map<String, Object> params) {
		Map<String, Object> retMap = new HashMap<>();
		Map<String, Object> userMap = userDao.login(params);
		if(userMap == null) {
			return retMap;
		}
		params = new HashMap<>();
		params.put("user_id", userMap.get("USER_ID"));
		List<Map<String, Object>> systemList = userDao.getSystemList(params);
		
		retMap.put("userMap", userMap);
		retMap.put("systemList", systemList);
		return retMap;
	}
	

}
