package com.es.config.springSecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		AjaxResponseBody responseBody = new AjaxResponseBody();
		responseBody.setStatus("100");
		responseBody.setMsg("注销成功");
		response.getWriter().write(JSON.toJSONString(responseBody));

	}

}
