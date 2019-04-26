package com.es.aspect;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	/**
	 * 定义切点
	 * execution:在执行的时候,拦截里边的正则匹配的方法
	 * *:表示任意
	 * (..):任意参数进行匹配
	 */
	@Pointcut("execution(* com.es.service.impl.*.save*(..))")
	public void pointcut() {

	}
	/**
	 * 前置通知
	 * 获取参数
	 */
	@Before("pointcut() && args(map)")
	public void before(JoinPoint jp,Map<String,String> map) {
		Object[] args = jp.getArgs();
		
		System.out.println("before ......");
	}

	@After("pointcut()")
	public void after() {
		System.out.println("after ......");
	}

	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("afterReturning ......");
	}

	@AfterThrowing("pointcut()")
	public void afterThrowing() {
		System.out.println("afterThrowing ......");
	}
	/**
	 * 取代原有目标对象方法的通知 ,提供调用原有目标对象方法的能力
	 * @param jp
	 * @throws Throwable
	 */
	@Around("pointcut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around before ......");
		jp.proceed();
		System.out.println("around after ......");
	}
}
