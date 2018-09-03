/**
 * FileName: 	 IRoleProcessVODao.java
 * @Description: 角色流程视图VO信息DAO接口
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月5日 下午3:33:22 
 **/

package com.jinlong.system.dao.role;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.vo.role.RoleProcessVO;

/**
 * 角色流程视图VO信息DAO接口
 * @author:	肖学进
 * @date: 2018年6月5日 下午3:33:22
 */
@Mapper
public interface IRoleProcessVODao extends IBasicDao<RoleProcessVO> {

}
