/**
 * FileName: 	 UserGroup.java
 * @Description: 用户组信息POJO实体类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月17日 下午5:44:58 
 **/

package com.jinlong.system.model.po.usergroup;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * 用户组信息POJO实体类
 * @author:	肖学进
 * @date: 2018年7月17日 下午5:48:49
 */
@Data
public class UserGroup implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1181406286433432945L;

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
	private String userGroupInfo;
	
}
