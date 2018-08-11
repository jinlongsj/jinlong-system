/**
 * FileName: 	 RoleProcessState.java
 * @Description: 角色流程状态枚举类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月8日 上午10:36:51 
 **/

package com.jinlong.system.model.enums.role;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 角色流程状态枚举类
 * @author:	肖学进
 * @date: 2018年6月8日 上午10:36:51
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RoleProcessState implements Serializable {
	
	/**
	 * 新增角色
	 */
	addRole(1, "新增角色"),
	
	/**
	 * 新增角色提交审核
	 */
	addRoleSubmitExamine(2, "新增角色提交审核"),
	
	/**
	 * 新增角色审核通过
	 */
	addRoleSubmitExaminePass(3, "新增角色审核通过"),
	
	/**
	 * 新增角色审核不通过
	 */
	addRoleSubmitExamineNoPass(4, "新增角色审核不通过"),
	
	/**
	 * 锁定角色提交审核
	 */
	lockRoleSubmitExamine(5, "锁定角色提交审核"),
	
	/**
	 * 锁定角色审核通过
	 */
	lockRoleSubmitExaminePass(6, "锁定角色审核通过"),
	
	/**
	 * 锁定角色审核不通过
	 */
	lockRoleSubmitExamineNoPass(7, "锁定角色审核不通过"),
	
	/**
	 * 注销角色提交审核
	 */
	logoffRoleSubmitExamine(8, "注销角色提交审核"),
	
	/**
	 * 注销角色审核通过
	 */
	logoffRoleSubmitExaminePass(9, "注销角色审核通过"),
	
	/**
	 * 注销角色审核不通过
	 */
	logoffRoleSubmitExamineNoPass(10, "注销角色审核不通过");
	
	private Integer value;
	
	private String name;

}
