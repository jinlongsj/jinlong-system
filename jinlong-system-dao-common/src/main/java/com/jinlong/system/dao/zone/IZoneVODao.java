package com.jinlong.system.dao.zone;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.vo.zone.ZoneVO;

/**
 * @description 地区信息DAO数据持久层接口
 * @author 肖学进
 */
@Mapper
public interface IZoneVODao extends IBasicDao<ZoneVO> {
	
	/**
	 * @Description:查询所有的一级地区
	 * @return
	 * @throws Exception
	 */
	public List<ZoneVO> selectAllParent() throws Exception;
	
	/**
	 * @Description:通过下一级地区信息查询上一级地区信息
	 * @param zone
	 * @return
	 * @throws Exception
	 */
	public ZoneVO selectParent(@Param(value = "zoneId") int zoneId) throws Exception;
	
	/**
	 * @Description:通过一级地区查询它下面的所有二级地区，并且按顺序排列
	 * @param zone
	 * @return
	 * @throws Exception
	 */
	public List<ZoneVO> selectSon(@Param(value = "zoneId") int zoneId) throws Exception;
}
