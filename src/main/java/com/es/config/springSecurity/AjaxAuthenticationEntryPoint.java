package com.es.config.springSecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
/**
 * 未登录
 * @author handch
 *
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		AjaxResponseBody responseBody = new AjaxResponseBody();
		responseBody.setStatus("000");
		responseBody.setMsg("无访问权限，请先登录");
		response.getWriter().write(JSON.toJSONString(responseBody));

	}
}
