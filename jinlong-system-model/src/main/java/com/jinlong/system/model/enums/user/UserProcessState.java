package com.jinlong.system.model.enums.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 用户流程装后台枚举
 * @author asus
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserProcessState implements Serializable {
	
	/**
	 * 新增用户
	 */
	addUser(1, "新增用户"),
	
	/**
	 * 新增用户提交审核
	 */
	addUserSubmitExamine(2, "新增用户提交审核"),
	
	/**
	 * 新增用户审核通过
	 */
	addUserSubmitExaminePass(3, "新增用户审核通过"),
	
	/**
	 * 新增用户审核不通过
	 */
	addUserSubmitExamineNoPass(4, "新增用户审核不通过"),
	
	/**
	 * 锁定用户提交审核
	 */
	lockUserSubmitExamine(5, "锁定用户提交审核"),
	
	/**
	 * 锁定用户审核通过
	 */
	lockUserSubmitExaminePass(6, "锁定用户审核通过"),
	
	/**
	 * 锁定用户审核不通过
	 */
	lockUserSubmitExamineNoPass(7, "锁定用户审核不通过"),
	
	/**
	 * 注销用户提交审核
	 */
	logoffUserSubmitExamine(8, "注销用户提交审核"),
	
	/**
	 * 注销用户审核通过
	 */
	logoffUserSubmitExaminePass(9, "注销用户审核通过"),
	
	/**
	 * 注销用户审核不通过
	 */
	logoffUserSubmitExamineNoPass(10, "注销用户审核不通过");
	
	private Integer value;
	
	private String name;

}
