package com.es.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;


/**
 *  #拦截器流程图: 
 *                 ┌──────────────┐
 *       S────────>┤ preHandle方法    │
 *                 └───────┬──────┘ 
 *                         ↓
 *              ┌──────────┴─────────┐      ┌───────┐      ┌─────────────────────┐ 
 *       ┌───N──┤  preHandle返回 true  ├──Y──>│  处理器   ├─────>┤  postHandle返回 true  │
 *       │      └────────────────────┘      └───────┘      └──────────┬──────────┘ 
 *       ↓      ┌────────────────────┐      ┌─────────┐               │
 *       E<─────┤ afterCompletion方法    ├<─────┤  视图处理     ├<──────────────┘
 *              └────────────────────┘      └─────────┘
 * @author Handc
 *
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	
	//@Autowired
	//private AppService appService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// request.getRequestDispatcher("/index.jsp").include(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type,X-Requested-With, accept, Origin, Access-Control-Request-Method, Access-Control-Request-Headers");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT");
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		Map<String,String> map = new HashMap<>();
		map.put("code", "1");
		writer.append(JSONUtils.toJSONString(map));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
