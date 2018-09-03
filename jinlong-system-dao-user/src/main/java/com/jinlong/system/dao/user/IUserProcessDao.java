/**
 * FileName: 	 IUserProcessDao.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By ZTE-ITS
 * Copyright:	Copyright(C) 2010-2011
 * Company   	ZTE-ITS WuXi LTD.
 * @author:		肖学进
 * @version		V1.0 
 * Createdate: 	2017年11月11日 上午10:13:59 
 **/

package com.jinlong.system.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.po.user.UserProcessPO;

/**
 * 用户流程信息数据持久化层DAO接口
 * @author 肖学进
 */
@Mapper
public interface IUserProcessDao extends IBasicDao<UserProcessPO> {

}
