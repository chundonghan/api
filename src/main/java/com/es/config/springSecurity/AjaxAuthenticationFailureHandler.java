package com.es.config.springSecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
			response.setContentType("application/json;charset=utf-8");
		 	AjaxResponseBody responseBody = new AjaxResponseBody();
	        responseBody.setStatus("400");
	        responseBody.setMsg("账号或密码错误，请重新登录");
	        response.getWriter().write(JSON.toJSONString(responseBody));
		
	}
}
