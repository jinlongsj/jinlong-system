package com.jinlong.system.service.zone;

import java.util.List;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.service.IBaseVOService;
import com.jinlong.system.model.po.zone.ZoneInfo;
import com.jinlong.system.model.vo.zone.ZoneVO;

/**
 * 地区信息Service业务层接口
 * @author 肖学进
 */
public interface IZoneService extends IBaseVOService<ZoneInfo, ZoneVO> {
	
	/*
	 * 不操作事务，查询 操作的方法
	 */
	/**
	 * 查询所有的一级地区
	 * @return
	 * @throws LogicException
	 */
	public List<ZoneVO> findAllParent() throws LogicException;
	
	/**
	 * 通过下一级地区信息查询上一级地区信息
	 * @param zone
	 * @return
	 * @throws LogicException
	 */
	public ZoneVO findParent(int zoneId) throws LogicException;
	
	/**
	 * 查询此地区下面的所有二级地区，并且按顺序排列
	 * @param zone
	 * @return
	 * @throws LogicException
	 */
	public List<ZoneVO> findSon(int zoneId) throws LogicException;
	
	
	
	/*
	 * 业务层方法
	 */
	
	/**
	 * 给一个地区下面查找并放入所有的子孙地区
	 * @param zone
	 * @return
	 * @throws LogicException
	 */
	public ZoneVO findAllSon(ZoneVO zone) throws LogicException;
	
	/**
	 * 按顺序排列一个地区的子菜单
	 * @param zone
	 * @param zoneList
	 * @return
	 * @throws LogicException
	 */
	public ZoneVO orderByList(ZoneVO zone, List<ZoneVO> zoneList) throws LogicException;
	
	/**
	 * 按顺序排列一个地区的子菜单
	 * @param zone
	 * @return
	 * @throws LogicException
	 */
	public ZoneVO orderBy(ZoneVO zone, List<ZoneVO> zoneList) throws LogicException;
	
}