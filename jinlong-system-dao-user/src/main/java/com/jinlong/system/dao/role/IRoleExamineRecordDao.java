/**
 * FileName: 	 RoleExamineRecordDao.java
 * @Description: 角色审核记录信息DAO接口
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月5日 下午3:25:25 
 **/

package com.jinlong.system.dao.role;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.po.role.RoleExamineRecordPO;

/**
 * 角色审核记录信息DAO接口
 * @author:	肖学进
 * @date: 2018年6月5日 下午3:25:25
 */
@Mapper
public interface IRoleExamineRecordDao extends IBasicDao<RoleExamineRecordPO> {

}
