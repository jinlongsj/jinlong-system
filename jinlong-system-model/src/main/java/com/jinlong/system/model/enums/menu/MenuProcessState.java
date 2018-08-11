/**
 * FileName: 	 MenuProcessState.java
 * @Description: 菜单流程状态枚举类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月18日 上午9:32:34 
 **/

package com.jinlong.system.model.enums.menu;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 菜单流程状态枚举类
 * @author:	肖学进
 * @date: 2018年7月18日 上午9:32:34
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum MenuProcessState implements Serializable {
	
	/**
	 * 新增菜单
	 */
	addMenu(1, "新增菜单"),
	
	/**
	 * 新增菜单提交审核
	 */
	addMenuSubmitExamine(2, "新增菜单提交审核"),
	
	/**
	 * 新增菜单审核通过
	 */
	addMenuSubmitExaminePass(3, "新增菜单审核通过"),
	
	/**
	 * 新增菜单审核不通过
	 */
	addMenuSubmitExamineNoPass(4, "新增菜单审核不通过"),
	
	/**
	 * 锁定菜单提交审核
	 */
	lockMenuSubmitExamine(5, "锁定菜单提交审核"),
	
	/**
	 * 锁定菜单审核通过
	 */
	lockMenuSubmitExaminePass(6, "锁定菜单审核通过"),
	
	/**
	 * 锁定菜单审核不通过
	 */
	lockMenuSubmitExamineNoPass(7, "锁定菜单审核不通过"),
	
	/**
	 * 注销菜单提交审核
	 */
	logoffMenuSubmitExamine(8, "注销菜单提交审核"),
	
	/**
	 * 注销菜单审核通过
	 */
	logoffMenuSubmitExaminePass(9, "注销菜单审核通过"),
	
	/**
	 * 注销菜单审核不通过
	 */
	logoffMenuSubmitExamineNoPass(10, "注销菜单审核不通过");
	
	/**
	 * ID
	 */
	private Integer value;
	
	/**
	 * 名称
	 */
	private String name;

}
