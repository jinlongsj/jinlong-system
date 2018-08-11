/**
 * FileName: 	 MenuForm.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月5日 下午4:23:17 
 **/

/**
 * 
 */
package com.jinlong.system.model.form.menu;

import java.io.Serializable;

import com.jinlong.system.model.po.menu.MenuInfo;

import lombok.Data;

/**
 * @author:	肖学进
 * @date: 2018年7月5日 下午4:23:17
 */
@Data
public class MenuForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4136578698808899647L;
	
	/**
	 * 菜单实体类
	 */
	private MenuInfo menu;

}
