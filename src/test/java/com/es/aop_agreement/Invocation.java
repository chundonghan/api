package com.es.aop_agreement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用类
 * 
 * @author Handc
 *
 */
public class Invocation {
	private Object[] params;
	private Method method;
	private Object target;

	public Invocation(Object target, Method method, Object[] params) {
		this.target = target;
		this.method = method;
		this.params = params;
	}
	/**
	 * 反射方式调用方法
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object proceed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return method.invoke(target, params);
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
