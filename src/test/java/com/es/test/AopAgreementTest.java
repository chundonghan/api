package com.es.test;

import com.es.aop_agreement.HelloService;
import com.es.aop_agreement.HelloServiceImpl;
import com.es.aop_agreement.MyInterceptor;
import com.es.aop_agreement.ProxyBean;

public class AopAgreementTest {
	/**
	 * 测试aop约定
	 */
	private static void testAopAgreement() {
		HelloService  helloService = new HelloServiceImpl();
		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.sayHello("han");
		System.out.println("\n########name is null!########\n");
		proxy.sayHello(null);
	}
	
	public static void main(String[] args) {
		testAopAgreement();
	}
}
