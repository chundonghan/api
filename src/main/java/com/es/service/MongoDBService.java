package com.es.service;

import java.io.InputStream;
import java.util.Map;

public interface MongoDBService {

	void uploadFile(InputStream content,Map<String,Object> params);
	
	InputStream downloadFile(String filename) throws Exception ;
}
