package com.es.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper/* 代替mybatis xml文件  */
@Component
public interface AppDao {
	//@Select("SELECT account FROM chat_account WHERE enable_flag = '1'")
	List<String> getAllAccounts();
}
