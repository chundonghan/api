package com.es.service.app.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.dao.app.UserDao;
import com.es.service.app.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> getUserInfo(Map<String, Object> params) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> user = userDao.getUser(params);
		retMap.put("user_id", user.get("user_id"));
		retMap.put("account", user.get("account"));
		retMap.put("email", user.get("email"));
		retMap.put("avatar", user.get("avatar"));
		return retMap;
	}

}
