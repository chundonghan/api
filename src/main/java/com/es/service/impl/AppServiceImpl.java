package com.es.service.impl;

import java.util.List;
import java.util.Map;

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
	@Override
	public void save(Map<String,String> map) {
		
	}

}
