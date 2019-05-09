package com.es.dao.ums;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper/* 代替mybatis xml文件  */
@Component
public interface UserDao {
	
	/**
	 * 登录
	 * @param params
	 * @return
	 */
	Map<String,Object> login(Map<String,Object> params);
	
	/**
	 * 系统列表
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getSystemList(Map<String,Object> params);
}
