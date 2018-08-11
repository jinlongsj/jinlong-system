package com.jinlong.system.model.enums.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 用户状态枚举类
 * @author:	肖学进
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserState implements Serializable {
	
	/**
	 * 未激活
	 */
	notActive(1, "未激活"),
	
	/**
	 * 已激活
	 */
	alreadyActivated(2, "已激活"),
	
	/**
	 * 锁定用户
	 */
	lockUser(3, "锁定用户"),
	
	/**
	 * 注销用户
	 */
	logoffUser(4, "注销用户");
	
	/**
	 * ID 
	 */
	private Integer value;
	
	/**
	 * 名称
	 */
	private String name;

}
