/**
 * FileName: 	 MenuState.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月17日 下午6:24:03 
 **/

package com.jinlong.system.model.enums.menu;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author:	肖学进
 * @date: 2018年7月17日 下午6:24:03
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum MenuState implements Serializable {
	
	notActive(1, "未激活"),
	
	alreadyActived(2, "已激活"),
	
	lockMenu(3, "锁定菜单");
	
	/**
	 * ID
	 */
	private Integer value;
	
	/**
	 * 名称
	 */
	private String name;

}
