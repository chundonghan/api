package com.es.aop_agreement;
/**
 * 业务接口实现类
 * @author Handc
 *
 */
public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello(String name) {
		if (name == null || "".equals(name.trim())) {
			throw new RuntimeException("parameter is null!");
		}
		System.out.println("hello " + name);
	}

}
