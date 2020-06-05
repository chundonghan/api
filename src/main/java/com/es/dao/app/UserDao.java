package com.es.dao.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper/* 代替mybatis xml文件  */
public interface UserDao {
	
	/**
	 * #获取用户信息
	 * @param params
	 * @return
	 */
	Map<String,Object> getUser(Map<String,Object> params);

	
	/**
	 * #角色列表
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getRoleList(Map<String,Object> params);
}
