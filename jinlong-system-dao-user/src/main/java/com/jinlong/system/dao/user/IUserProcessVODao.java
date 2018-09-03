/**
 * FileName: 	 IUserProcessVODao.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By ZTE-ITS
 * Copyright:	Copyright(C) 2010-2011
 * Company   	ZTE-ITS WuXi LTD.
 * @author:		肖学进
 * @version		V1.0 
 * Createdate: 	2017年11月11日 上午11:08:55 
 **/

package com.jinlong.system.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.vo.user.UserProcessVO;

/**
 * 用户流程VO数据持久化曾DAO接口
 * @author 肖学进
 */
@Mapper
public interface IUserProcessVODao extends IBasicDao<UserProcessVO> {
	
}
