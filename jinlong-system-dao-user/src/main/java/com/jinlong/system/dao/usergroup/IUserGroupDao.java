/**
 * FileName: 	 UserGroupDao.java
 * @Description: 用户组DAO接口
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月17日 下午5:44:58 
 **/

package com.jinlong.system.dao.usergroup;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.usergroup.UserGroup;

/**
 * 用户组DAO接口
 * @author:	肖学进
 * @date: 2018年7月17日 下午5:44:58
 */
@Mapper
public interface IUserGroupDao extends IBasicDao<UserGroup> {

}
