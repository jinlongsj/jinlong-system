package com.jinlong.system.service.zone.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.exception.LogicExceptionMessage;
import com.jinlong.common.service.impl.BaseVOServiceImpl;
import com.jinlong.system.dao.zone.IZoneDao;
import com.jinlong.system.dao.zone.IZoneVODao;
import com.jinlong.system.model.po.zone.ZoneInfo;
import com.jinlong.system.model.vo.zone.ZoneVO;
import com.jinlong.system.service.zone.IZoneService;

/**
 * @description 地区信息服务层实现类Impl
 * @author 肖学进
 */
@Service
public class ZoneServiceImpl extends BaseVOServiceImpl<ZoneInfo, IZoneDao, ZoneVO, IZoneVODao> implements
		IZoneService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.impl.UserWordsServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * Spring注入的服务层接口
	 */
	// 注入的ZoneDao接口
	@Autowired
	private IZoneVODao zoneVODao;

	
	
	/**
	 * 不操作事务，查询 操作的方法
	 */
	
	/* 
	 * @description 通过地区ID查询所有地区信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#find(int)
	 */
	@Override
	public ZoneVO find(int id) throws LogicException {
		try {
			return zoneVODao.select(id);
		} catch (Exception e) {
			logger.error("********** select Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * @description 通过条件查询一组地区信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findList(java.lang.Object)
	 */
	@Override
	public List<ZoneVO> findList(ZoneVO zone) throws LogicException {
		try {
			return zoneVODao.selectList(zone);
		} catch (Exception e) {
			logger.error("********** selectList Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * @description 查询最新的一条地区信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNew()
	 */
	@Override
	public ZoneVO findNew() throws LogicException {
		try {
			return zoneVODao.selectNew();
		} catch (Exception e) {
			logger.error("********** selectNew Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}

	/* 
	 * @description 查询最新的count条地区信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNewList(int)
	 */
	@Override
	public List<ZoneVO> findNewList(int count) throws LogicException {
		try {
			return zoneVODao.selectNewList(count);
		} catch (Exception e) {
			logger.error("********** selectNewList Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewList", e);
		}
	}
	
	/* 
	 * @description 查询所有的一级地区，把二级地区信息绑定在一级地区下面
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.zone.IZoneVOService#findAllParent()
	 */
	public List<ZoneVO> findAllParent() throws LogicException {
		try {
			return zoneVODao.selectAllParent();
		} catch (Exception e) {
			logger.error("********** selectAllParent Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAllParent", e);
		}
	}
	
	/* 
	 * @description 通过下一级地区信息查询上一级地区信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.zone.IZoneVOService#findParent(int)
	 */
	public ZoneVO findParent(int zoneId) throws LogicException {
		try {
			return zoneVODao.selectParent(zoneId);
		} catch (Exception e) {
			logger.error("********** selectParent Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectParent", e);
		}
	}
	
	/* 
	 * @description 查询此地区下面的所有二级地区，并且按顺序排列
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.zone.IZoneVOService#findSon(int)
	 */
	public List<ZoneVO> findSon(int zoneId) throws LogicException {
		try {
			return zoneVODao.selectSon(zoneId);
		} catch (Exception e) {
			logger.error("********** selectSon Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectSon", e);
		}
	}
	
	
	
	/**
	 * 业务层方法
	 */
	
	/* 
	 * @description 给一个地区下面查找并放入所有的子孙地区
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.zone.IZoneVOService#findAllSon(com.jinlong.common.model.vo.ZoneVO)
	 */
	public ZoneVO findAllSon(ZoneVO zone) throws LogicException {
		try {
			List<ZoneVO> sonList = this.findSon(zone.getZoneId());
			if (null != sonList && 0 < sonList.size()) {
				for (ZoneVO son : sonList) {
					this.findAllSon(son);
				}
			}
			zone.setSon(sonList);
		} catch (Exception e) {
			logger.error("********** findAllSon Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAllSon", e);
		}
		return zone;
	}
	
	/* 
	 * @description:查询所有的地区，把下一级地区信息绑定在上一级地区下面
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findAll()
	 */
	@Override
	public List<ZoneVO> findAll() throws LogicException {
		List<ZoneVO> firstZoneList = new ArrayList<ZoneVO>();
		try {
			List<ZoneVO> parentList = zoneVODao.selectAllParent();
			List<ZoneVO> zoneList = zoneVODao.selectAll();
			if (parentList != null && parentList.size() > 0) {
				for (ZoneVO zone : parentList) {
					if (zone.getParentId() == 0) {
						// 截取地址名称
						if (zone.getZoneName() != null 
								&& zone.getZoneName().length() > 7) {
							zone.setZoneName(
									zone.getZoneName().substring(0, 6) + "...");
						}
						zone = this.orderBy(zone, zoneList);
						firstZoneList.add(zone);
					}
				}
			}
		} catch (Exception e) {
			logger.error("********** findAll Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
		return firstZoneList;
	}
	
	/* 
	 * @Desription:按顺序排列一个地区（包括删除判断）
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.zone.IZoneVOService#orderByList(com.jinlong.common.model.vo.ZoneVO, java.util.List)
	 */
	public ZoneVO orderByList(ZoneVO zone, List<ZoneVO> zoneList)
			throws LogicException {
		// TODO Auto-generated method stub
		try {
			if (zoneList != null && zoneList.size() != 0) {
				List<ZoneVO> son = new ArrayList<ZoneVO>();
				if (zoneList != null && zoneList.size() > 0) {
					for (ZoneVO z : zoneList) {
						if (z != null && z.getParentId() == zone.getZoneId()) {
							z = this.orderByList(z, zoneList);
							son.add(z);
						}
					}
				}
				// 父子节点排列
				if (son.size() != 0) {
					// 将子地区放入父地区当中
					zone.setSon(son);
					// 将子地区的长度放入父地区当中
					zone.setSize(son.size());
				}
			}
		} catch (Exception e) {
			logger.error("********** orderByList Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "orderByList", e);
		}
		return zone;
	}
	
	/* 
	 * @Desription:按顺序排列一个地区
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.zone.IZoneVOService#orderBy(com.jinlong.common.model.vo.ZoneVO, java.util.List)
	 */
	public ZoneVO orderBy(ZoneVO zone, List<ZoneVO> zoneList) throws LogicException {
		// TODO Auto-generated method stub
		try {
			if (zoneList != null && zoneList.size() != 0) {
				List<ZoneVO> son = new ArrayList<ZoneVO>();
				for (ZoneVO z : zoneList) {
					if (z != null && z.getParentId() == zone.getZoneId()) {
						z = this.orderBy(z, zoneList);
						son.add(z);
					}
				}
				// 父子节点排列
				if (son.size() != 0) {
					// 将子地区放入父地区当中
					zone.setSon(son);
				}
			}
		} catch (Exception e) {
			logger.error("********** orderBy Zone ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "orderBy", e);
		}
		return zone;
	}
}