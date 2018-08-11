/**
 * FileName: 	 UserDetailsService.java
 * @Description: 用户认证业务层实现类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月7日 上午10:00:52 
 **/

package com.jinlong.system.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 用户认证业务层实现类
 * @author:	肖学进
 * @date: 2018年7月7日 上午10:00:52
 */
@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("登陆用户名：" + username);
		// 根据用户名查找用户信息
		// 根据查找的用户信息判断用户是否被冻结
		String password = passwordEncoder.encode("1234");
		logger.info("数据库密码是：" + password);
		return new User(username, passwordEncoder.encode("1234"),
				true, // 可用
				true, // 用户没过期
				true, // 密码没过期
				true, // 没被锁定
				AuthorityUtils.createAuthorityList("USER"));
	
//		return new User(username, passwordEncoder.encode("1234"), AuthorityUtils.createAuthorityList("USER"));
	}

}
