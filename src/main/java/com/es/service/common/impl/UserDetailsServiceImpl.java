package com.es.service.common.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.es.dao.app.UserDao;
import com.es.dao.redis.RedisDao;

/**
 * UserDetailsService接口实现类,定义用户服务类 通过该接口获取用户信息
 * 
 * @author Handc
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/**
	 * 根据用户名称 获取用户信息以及角色
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		Map<String, Object> userMap = userDao.getUser(params);
		if (userMap != null) {
			BigInteger userId = (BigInteger) userMap.get("user_id");
			String password = (String) userMap.get("passwd");
			params.clear();
			params.put("user_id", userId);
			String account = (String) userMap.get("account");
			List<Map<String, Object>> roleList = userDao.getRoleList(params);
			return getUserDetails(account, password, roleList);
		}

		return null;
	}

	private UserDetails getUserDetails(String username, String password, List<Map<String, Object>> roleList) {
		// 权限列表
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		//
		GrantedAuthority grantedAuthority = null;
		for (Map<String, Object> roleMap : roleList) {
			grantedAuthority = new SimpleGrantedAuthority((String) roleMap.get("role_code"));
			grantedAuthorityList.add(grantedAuthority);
		}
		// 创建UserDetails对象 设置用户名 密码 参数
		UserDetails userDetails = new User(username, password, grantedAuthorityList);
		return userDetails;
	}
}
