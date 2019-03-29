package com.es.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration/*java配置文件注解 代替xml配置*/
@ComponentScan(basePackages= {"com.es.*"})/*扫描:默认扫描AppConfig所在的当前包和其子包*/
@MapperScan(basePackages = "com.es.dao")/*mybatis 扫描mapper*/
public class AppConfig {

}
