package com.es.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.dao.AppDao;
import com.es.service.AppService;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	private  AppDao appDao;
	@Override
	public List<String> getAllAccounts() {
		return appDao.getAllAccounts();
	}

}
