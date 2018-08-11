///**
// * FileName: 	 SecurityConfig.java
// * @Description: 系统后台认证配置类
// * 
// * All rights Reserved, Designed By Jinlong
// * Copyright:	Copyright(C) 2018-2019
// * Company   	Jinlong.
// * @author:		肖学进
// * @version		V1.0 
// * CreateDate: 	2018年6月14日 下午4:52:11 
// **/
//
//package com.jinlong.system.web.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author:	系统后台认证配置类
// * @date: 2018年6月14日 下午4:52:11
// */
//@Configuration
//@EnableWebSecurity // 注解，开启Spring Security的功能
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	/* 
//	 * 用户登陆拦截和跳转
//	 * (non-Javadoc)
//	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
//	 */
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//          // TODO Auto-generated method stub
//          //super.configure(http);
//          http
//          		// 定义哪些URL需要保护，那些URL不需要被保护
//          		.authorizeRequests()
//          			.antMatchers("/", "/loginExit/login").permitAll() // permitAll()表示这个不需要验证
//          			.anyRequest().authenticated() 
//          			.and()
//          		// 表单登录，
//                .formLogin()
//                	.loginPage("/login.jsp")	// 定义当前用户登陆的时候，跳转的登录页面
//                	.loginProcessingUrl("/loginExit/login/form")
//                	.failureUrl("/loginExit/login-error").permitAll()	// 登录失败页面
//                	.and()
//                .logout().permitAll();
//          http.csrf().disable();            
//    }
//	
//	/**
//	 * 配置可以登陆的用户信息
//	 * @param auth
//	 * @throws Exception
//	 */
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//          auth
//                .inMemoryAuthentication()
//                      .withUser("admin").password("123456").roles("USER");
//          
//    }
//	
//	/* 
//	 * 配置可以登陆的用户信息
//	 * (non-Javadoc)
//	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
//	 */
//	/*@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//          auth
//          .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER")
//                .and()
//                .withUser("test").password("test123").roles("ADMIN");
//    }*/
//
//}
