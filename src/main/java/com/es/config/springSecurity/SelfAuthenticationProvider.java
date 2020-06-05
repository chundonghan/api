package com.es.config.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class SelfAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String username = (String) authentication.getPrincipal();
	        String password = (String) authentication.getCredentials(); 
	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	        if(userDetails == null) {
	        	 throw new BadCredentialsException("账号不存在，请重新登陆！");
	        }
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        if (!bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
	            throw new BadCredentialsException("账号密码不正确，请重新登陆！");
	        }
	        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
