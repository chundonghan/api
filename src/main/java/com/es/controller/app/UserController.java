package com.es.controller.app;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.es.dao.redis.RedisDao;
import com.es.service.app.UserService;


@RestController
@CrossOrigin //解决ajax跨域问题
public class UserController extends BaseController{

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private RedisDao redisDao;
	@Autowired
	private UserService userService;
	
	@PostMapping("/userinfo")
	public Map<String,Object> userinfo(@RequestHeader(value="token",defaultValue="") String token){
		Map<String,Object> retMap = new HashMap<String,Object>();
		String username = redisDao.get(token);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		
		retMap = userService.getUserInfo(params);
		
		return retMap;
	}
	
}
