package com.es.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Value("${system.user.password.salt}")
	private String salt;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 密码编码器
		// PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(salt);
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	/**
	 * 设置访问权限和登录方式
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 限定签名后的权限
		http
				// 关闭csrf过滤器(跨站点请求伪造)
				// .csrf().disable()
				// 限定通过签名的请求
				.authorizeRequests()
				// 限定请求赋予ROLE_USER或者ROLE_ADMIN
				// .antMatchers("").hasAnyRole("USER","ADMIN")
				/**
				 * 	使用安全渠道,限定为https请求 
				 * .requiresChannel().antMatchers("/ums/**").requiresSecure()
				 * 	不使用 https 请求 
				 * .requiresChannel().antMatchers("/ums/**").requiresInsecure()
				 */
				// 限定 /ums/ 下所有请求权限赋予角色ROLE_ADMIN
				.antMatchers("/ums/**").access("hasRole('USER')")
				.antMatchers("/login/page").permitAll()
				.antMatchers("/hall/**").access("hasRole('USER')")
				// .anyRequest().authenticated()
				// 通过签名后可以访问任何请求
				// 其他路径允许签名后访问
//				.anyRequest().permitAll()
				// 对于没有配置权限的其他请求允许匿名访问
				// .and().anonymous()
				// 使用记住我的功能
				// .and().rememberMe().tokenValiditySeconds(86400).key("remember-me-key")
				// 登录页面配置
				.and().formLogin().loginPage("/login/page").defaultSuccessUrl("/hall/index").failureUrl("/login/page?error").permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login/page");
				// 启用http基础验证
				//.and().httpBasic();
	}
}
