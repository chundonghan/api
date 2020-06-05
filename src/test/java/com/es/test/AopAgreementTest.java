package com.es.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import com.es.aop_agreement.HelloService;
import com.es.aop_agreement.HelloServiceImpl;
import com.es.aop_agreement.MyInterceptor;
import com.es.aop_agreement.ProxyBean;

public class AopAgreementTest {
	/**
	 * 测试aop约定
	 */
	private static void testAopAgreement() {
		HelloService helloService = new HelloServiceImpl();
		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.sayHello("han");
		System.out.println("\n########name is null!########\n");
		proxy.sayHello(null);
	}

	public static void main(String[] args) {
//		testAopAgreement();
		//PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("es");
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String p1 = passwordEncoder.encode( "1");
		System.out.println(p1);
		HashMap<String, Object> map = new HashMap<>();
		ConcurrentHashMap<String, Object> cmap;
	}
}
