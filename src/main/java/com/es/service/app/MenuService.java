package com.es.service.app;

import java.util.List;
import java.util.Map;

public interface MenuService {

	/**
	 * 封装菜单列表
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getMenus(Map<String,Object> params);
}
