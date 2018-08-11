/**
 * FileName: 	 RoleState.java
 * @Description: 角色状态枚举类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月8日 上午10:24:18 
 **/

package com.jinlong.system.model.enums.role;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 角色状态枚举类
 * @author:	肖学进
 * @date: 2018年6月8日 上午10:24:18
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RoleState implements Serializable {
	
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
	lockRole(3, "锁定角色"),
	
	/**
	 * 注销用户
	 */
	logoffRole(4, "注销角色");
	
	/**
	 * ID 
	 */
	private Integer value;
	
	/**
	 * 名称
	 */
	private String name;

}
