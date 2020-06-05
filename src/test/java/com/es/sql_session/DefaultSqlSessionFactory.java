package com.es.sql_session;

public class DefaultSqlSessionFactory implements SqlSessionFactory{

	@Override
	public SqlSession openSession() {
		
		return new DefaultSqlSession();
	}

}
