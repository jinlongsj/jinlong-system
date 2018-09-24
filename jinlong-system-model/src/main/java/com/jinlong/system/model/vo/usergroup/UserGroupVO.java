/**
 * FileName: 	 UserGroupVO.java
 * @Description: 用户组信息VO视图类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年9月14日 上午9:13:00 
 **/

package com.jinlong.system.model.vo.usergroup;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * 用户组信息VO视图类
 * @author:	肖学进
 * @date: 2018年9月14日 上午9:13:00
 */
@Data
public class UserGroupVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6018356126506147090L;
	
	/**
	 * 用户组信息
	 */

	/**
	 * 用户组ID
	 */
	private int userGroupId;
	
	/**
	 * 父用户组ID
	 */
	private int parentId;
	
	/**
	 * 用户组名称
	 */
	private String userGroupName;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 用户组简介
	 */
	private String description;
	
	/**
	 * 用户组状态
	 */
	private Integer state;
	
	/**
	 * 用户组流程状态
	 */
	private Integer processState;
	
	/**
	 * 业务需求属性
	 */
	
	/**
	 * 用户状态名称
	 */
	private String stateName;
	
	/**
	 * 用户流程状态名称
	 */
	private String processStateName;

}
