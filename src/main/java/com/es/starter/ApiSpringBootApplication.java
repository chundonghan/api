package com.es.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//java注解代替xml文件
@SpringBootApplication(scanBasePackages = "com.es.config")
//开启事务管理
@EnableTransactionManagement
public class ApiSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringBootApplication.class, args);
	}
}
