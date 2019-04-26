package com.es.aop_agreement;

import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器接口
 * 
 * @author Handc
 *
 */
/**
 *                        ┌──────around────────┐                      ┌───afterThrowing───┐
 *                       T│                    │                     T│                   │
 * ──>before──>useAround──┤                    ├──>after─>Exception?──┤                   ├──end
 * 					     F│                    │                     F│                   │
 *                        └───────target───────┘                      └──afterReturning───┘
 *                                原有方法
 */
public interface Interceptor {
	// 方法调用前
	public boolean before();

	// 方法调用后
	public void after();

	// 取代原有方法,即通过反射方式调用原有方法,并返回对象
	public Object around(Invocation invocation)
			throws InvocationTargetException, IllegalAccessException, IllegalArgumentException;

	// 返回后 与afterThrowing方法互斥
	public void afterReturning();

	// 异常后与afterReturning方法互斥
	public void afterThrowing();

	// 是否使用around方法替代原有方法
	boolean useAround();

}
