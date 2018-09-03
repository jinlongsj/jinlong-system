/**
 * FileName: 	 MenuVOForm.java
 * @Description: 菜单VO试图Form类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月5日 下午4:23:53 
 **/

package com.jinlong.system.model.form.menu;

import java.io.Serializable;

import com.jinlong.common.model.po.page.JqPage;
import com.jinlong.system.model.vo.menu.MenuVO;

import lombok.Data;

/**
 * @author:	肖学进
 * @date: 2018年7月5日 下午4:23:53
 */
@Data
public class MenuVOForm implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5961503411534837191L;

	/**
	 * 用户VO试图类
	 */
	private MenuVO menu;
	
	/**
	 * JqPage类
	 */
	private JqPage pageInfo;

}
