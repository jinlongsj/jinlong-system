/**
 * FileName: 	 MenuExamineState.java
 * @Description: 菜单审核状态枚举类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月18日 下午1:35:50 
 **/

package com.jinlong.system.model.enums.menu;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 菜单审核状态枚举类
 * @author:	肖学进
 * @date: 2018年7月18日 下午1:35:50
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum MenuExamineState implements Serializable {
	
	/**
	 * 通过审核
	 */
	passExamine(1, "通过审核"),
	
	/**
	 * 没有通过审核
	 */
	noPassExamine(2, "没有通过审核");
	
	/**
	 * ID
	 */
	private Integer value;
	
	/**
	 * 名称
	 */
	private String name;

}
