package com.es.config.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;  //  未登陆时返回 JSON 格式的数据给前端（否则为 html）

    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;  // 登录成功返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;  //  登录失败返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    AjaxLogoutSuccessHandler  logoutSuccessHandler;  // 注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）

    @Autowired
    AjaxAccessDeniedHandler accessDeniedHandler;    // 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）
    
    @Autowired
    SelfAuthenticationProvider selfAuthenticationProvider;
    
    @Autowired  
    AuthenticationTokenFilter authenticationTokenFilter;
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 密码编码器
		// PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(salt);
		//auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		auth.authenticationProvider(selfAuthenticationProvider);
	}
	
	@Bean
	SelfUsernamePasswordAuthenticationFilter selfUsernamePasswordAuthenticationFilter() throws Exception {
		SelfUsernamePasswordAuthenticationFilter filter = new SelfUsernamePasswordAuthenticationFilter();
	    filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
	    filter.setAuthenticationFailureHandler(authenticationFailureHandler);
	    //filter.setFilterProcessesUrl("/login");

	    //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
	    filter.setAuthenticationManager(authenticationManagerBean());
	    return filter;
	}
	/**
	 * 设置访问权限和登录方式
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .cors().and()
		 .csrf().disable()
         .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
         
         .and()
         .antMatcher("/**").authorizeRequests()
         .antMatchers("/","/upload","/get", "/login**").permitAll()
         .anyRequest()
         .authenticated()// 其他 url 需要身份认证
         
         .and()
         .formLogin()  //开启登录
         //.successHandler(authenticationSuccessHandler) // 登录成功
         //.failureHandler(authenticationFailureHandler) // 登录失败
         .loginPage("/")
         .and()
         .logout()
         .logoutSuccessHandler(logoutSuccessHandler)
         .permitAll();

		 http.exceptionHandling()
		 
		 .accessDeniedHandler(accessDeniedHandler); // 无权访问 JSON 格式的数据
		 
		 http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
		 
		 http.addFilterAt(selfUsernamePasswordAuthenticationFilter(),
				    UsernamePasswordAuthenticationFilter.class);
	}
}
