package com.es.service;

import java.util.List;
import java.util.Map;

public interface AppService {
	List<String> getAllAccounts();
	
	void save(Map<String,String> map);
}
