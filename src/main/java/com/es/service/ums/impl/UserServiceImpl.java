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

	
}
