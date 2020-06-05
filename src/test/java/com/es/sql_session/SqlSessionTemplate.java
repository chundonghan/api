package com.es.sql_session;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SqlSessionTemplate implements SqlSession {

	private final SqlSessionFactory sqlSessionFactory;
	private final SqlSession sqlSessionProxy;

	
	public SqlSessionFactory getSqlSessionFactory() {
	    return this.sqlSessionFactory;
	  }
	public SqlSessionTemplate() {
		this.sqlSessionFactory = new DefaultSqlSessionFactory();
		this.sqlSessionProxy = (SqlSession) Proxy.newProxyInstance(SqlSessionTemplate.class.getClassLoader(),
				new Class[] { SqlSession.class }, new SqlSessionInterceptor());
	}
	@Override
	public String print(String s) {
		return this.sqlSessionProxy.print(s);

	}
	private class SqlSessionInterceptor implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			SqlSession sqlSession = new DefaultSqlSession();
			System.out.println("in");
			Object result = method.invoke(sqlSession, args);
			return result;
		}
		
	}
	
	public static void main(String[] args) {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate();
		sqlSessionTemplate.print("ewq");
		sqlSessionTemplate.print("dsa");
		//sqlSessionTemplate.getSqlSessionFactory().openSession().print("asd");
		
	}
}
