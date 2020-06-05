package com.es.dao.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDao {

	/**
	 * 根据用户获取菜单列表
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getMenus(Map<String,Object> params);
}
