package com.es.sql_session;

public class DefaultSqlSession implements SqlSession{

	@Override
	public String print(String s) {
		System.out.println("string:"+s);
		return s;
		
	}

}
