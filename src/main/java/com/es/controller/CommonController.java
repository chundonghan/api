package com.es.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.es.service.common.MongoDBService;
import com.es.service.ums.UserService;

@Controller
@CrossOrigin // 解决ajax跨域问题
public class CommonController {

	private Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private MongoDBService mongoDBService;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginPage(String account, String passwd) {
		return "login";
	}

	@ResponseBody
	@PostMapping("/login")
	public Map<String, Object> login(
			@RequestParam(value = "account", required = false, defaultValue = "") String account, 
			@RequestParam(value = "passwd", required = false, defaultValue = "") String passwd) {
		Map<String, Object> params = new HashMap<>();
		params.put("account", account);
		params.put("passwd", passwd);
		Map<String, Object> retMap = userService.login(params);

		return retMap;
	}

	@ResponseBody
	@PostMapping("/upload")
	public Map<String, Object> upload(MultipartFile file) throws IOException {
		Map<String, Object> ret = new HashMap<>();
		String fileName = file.getOriginalFilename();
		String[] fileNameSplit = fileName.split("\\.");
		String fileType = "";
		if (fileNameSplit.length > 1) {// 文件名后缀
			fileType = fileNameSplit[fileNameSplit.length - 1];
		}
		logger.info("fileName:" + fileName);
		logger.info("fileType:" + fileType);

		Map<String, Object> params = new HashMap<>();
		params.put("contentType", file.getContentType());
		params.put("fileType", fileType);
		mongoDBService.uploadFile(file.getInputStream(), params);
		ret.put("code", "0");
		ret.put("msg", "上传成功");
		return ret;
	}

	/**
	 * 
	 * @param filename 对应mongodb中filename字段,在关系型数据库中为主键
	 * @param type     0:查看 1:下载
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@GetMapping(value = "/get")
	public void get(String filename, String type, HttpServletResponse response) throws Exception {
		// 根据filename查询关系型数据库获取文件类型

		if ("1".equals(type)) {
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
		}
		IOUtils.copy(mongoDBService.downloadFile(filename), response.getOutputStream());
	}
}
