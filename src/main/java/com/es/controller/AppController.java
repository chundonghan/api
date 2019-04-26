package com.es.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.es.service.AppService;
import com.es.service.MongoDBService;

@RestController
public class AppController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppService appService;

	@Autowired
	private MongoDBService mongoDBService;

	@RequestMapping(value = "/app", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> getAllAccounts() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "es");
		appService.save(map);
		return appService.getAllAccounts();
	}

	@PostMapping("/upload")
	public Map<String, Object> upload(MultipartFile file) throws IOException {
		Map<String, Object> ret = new HashMap<>();
		String fileName = file.getOriginalFilename();
		String file_type;
		Map<String, Object> params = new HashMap<>();
		params.put("contentType", file.getContentType());
		mongoDBService.uploadFile(file.getInputStream(), params);
		ret.put("code", "0");
		ret.put("msg", "上传成功");
		return ret;
	}

	/**
	 * 
	 * @param filename 对应mongodb中filename字段,在关系型数据库中为主键
	 * @param type 0:查看 1:下载
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/get")
	public void get(String filename,String type,HttpServletResponse response) throws Exception {
		
		if("1".equals(type)) {
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
		}
		IOUtils.copy(mongoDBService.downloadFile(filename),response.getOutputStream());
	}
}
