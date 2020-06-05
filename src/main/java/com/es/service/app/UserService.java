package com.es.service.app;

import java.util.Map;

public interface UserService {
	/**
	 * 获取用户信息
	 * @param params
	 * @return
	 */
	Map<String,Object> getUserInfo(Map<String,Object> params);
}
