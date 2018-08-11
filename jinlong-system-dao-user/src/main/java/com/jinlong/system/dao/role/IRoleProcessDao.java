/**
 * FileName: 	 IRoleProcessDao.java
 * @Description: 角色流程信息DAO接口
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月5日 下午3:30:58 
 **/

package com.jinlong.system.dao.role;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.role.RoleProcess;

/**
 * 角色流程信息DAO接口
 * @author:	肖学进
 * @date: 2018年6月5日 下午3:30:58
 */
@Mapper
public interface IRoleProcessDao extends IBasicDao<RoleProcess> {

}
