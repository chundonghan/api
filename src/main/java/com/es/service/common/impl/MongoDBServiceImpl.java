package com.es.service.common.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.es.service.common.MongoDBService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class MongoDBServiceImpl implements MongoDBService{
	
	@Autowired
	private GridFsTemplate gridFsTemplate;
	@Autowired
 	private MongoDbFactory mongoDbFactory;
	
	@Override
	public void uploadFile(InputStream content,Map<String, Object> params) {
		String filename = UUID.randomUUID().toString();
		String contentType = (String) params.get("contentType");
		DBObject metaData = new BasicDBObject();
		metaData.put("createdDate", new Date());
		gridFsTemplate.store(content, filename, contentType, metaData);
		
	}

	@Override
	public InputStream downloadFile(String filename) throws Exception {
		GridFSFile gridFSFile = gridFsTemplate
	               .findOne(new Query().addCriteria(Criteria.where("filename").is(filename)));
		GridFSDownloadStream openDownloadStream = GridFSBuckets.create(mongoDbFactory.getDb()).openDownloadStream(gridFSFile.getObjectId());
		GridFsResource gridFsResource=new GridFsResource(gridFSFile,openDownloadStream);
		
		return gridFsResource.getInputStream();
	}

}
