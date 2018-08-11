/**
 * FileName: 	 IZoneDao.java
 * @Description: 地区信息Dao接口
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月6日 下午4:26:02 
 **/

package com.jinlong.system.dao.zone;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.zone.ZoneInfo;

/**
 * 地区信息Dao接口
 * @author:	肖学进
 * @date: 2018年6月6日 下午4:26:02
 */
@Mapper
public interface IZoneDao extends IBasicDao<ZoneInfo> {

}
