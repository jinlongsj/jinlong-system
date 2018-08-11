/**
 * FileName: 	 RoleExamineState.java
 * @Description: 角色审核状态枚举类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月8日 上午10:33:27 
 **/

package com.jinlong.system.model.enums.role;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 角色审核状态枚举类
 * @author:	肖学进
 * @date: 2018年6月8日 上午10:33:27
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RoleExamineState implements Serializable {
	
	/**
	 * 通过审核
	 */
	passExamine(1, "通过审核"),
	
	/**
	 * 没有通过审核
	 */
	noPassExamine(2, "没有通过审核");
	
	private Integer value;
	
	private String name;

}
