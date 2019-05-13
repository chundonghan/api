package com.es.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.es.interceptor.MyInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	/**
	 * 	解决ajax跨域问题
	 * 	
	 */
	/*@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT")
				.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
						"Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
	}*/
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login/page").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
	
	// 国际化拦截器
	private LocaleChangeInterceptor lci = null;

	// 国际化解析器
	@Bean(name = "localeResolver")
	public LocaleResolver initLocaleResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return slr;
	}

	// 创建国际化拦截器
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		if (lci != null) {
			return lci;
		}
		lci = new LocaleChangeInterceptor();
		// 设置参数名
		lci.setParamName("language");
		return lci;
	}
	
	
	// 
	@Bean
	public HandlerInterceptor getMyInterceptor(){
        return new MyInterceptor();
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 通过prehandle方法对请求的国际化区域参数进行修改
		registry.addInterceptor(localeChangeInterceptor());
		InterceptorRegistration ir = registry.addInterceptor(getMyInterceptor());
		ir.addPathPatterns("/test");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
