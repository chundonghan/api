package com.es.config.springSecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.es.common.util.MD5;
import com.es.dao.redis.RedisDao;
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	@Autowired
	private RedisDao redisDao;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String name = authentication.getName();
		String token = MD5.md5(name);
		redisDao.set(token, name, 30*60);//半个小时
		response.setContentType("application/json;charset=utf-8");
        AjaxResponseBody responseBody = new AjaxResponseBody();
        responseBody.setStatus("200");
        responseBody.setMsg("登录成功");
        responseBody.setToken(token);
        response.getWriter().write(JSON.toJSONString(responseBody));
		
	}

}
