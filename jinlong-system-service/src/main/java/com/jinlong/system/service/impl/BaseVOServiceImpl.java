package com.jinlong.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.common.utils.exception.LogicExceptionMessage;
import com.jinlong.system.common.utils.page.PageList;
import com.jinlong.system.common.utils.page.PageProperty;
import com.jinlong.system.common.utils.page.PageUtil;
import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.page.JqPage;
import com.jinlong.system.service.IBaseVOService;

/**
 * 基础VO视图类业务层SERVICEIMPL实现类
 * @author 肖学进
 * @param <T>
 */
public class BaseVOServiceImpl<PO, IPO extends IBasicDao<PO>, VO, IVO extends IBasicDao<VO>> 
	implements IBaseVOService<PO, VO> {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.common.service.impl.BaseVOServiceImpl";
	
	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * 基础DAO
	 */
	// POJO实体类DAO数据持久层接口
	private IPO basicPODao;
	// VO实体类DAO数据持久层接口
	private IVO basicVODao;
	
	/**
	 * 操作事物，曾、删、改的接口实现方法
	 */

	/* 
	 * 创建数据对象
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseVOService#add(java.lang.Object)
	 */
	@Override
	public int add(PO obj) throws LogicException {
		try {
			return basicPODao.insert(obj);
		} catch (Exception e) {
			log.error("********** add ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "add", e);
		}
	}

	/* 
	 * 删除单条数据对象
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseVOService#delete(java.lang.Object)
	 */
	@Override
	public int delete(PO obj) throws LogicException {
		try {
			return basicPODao.delete(obj);
		} catch (Exception e) {
			log.error("********** delete ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * 删除单条数据对象 
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseVOService#deleteById(int)
	 */
	@Override
	public int deleteById(int id) throws LogicException {
		try {
			return basicPODao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 删除单条数据对象
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseVOService#update(java.lang.Object)
	 */
	@Override
	public int update(PO obj) throws LogicException {
		try {
			return basicPODao.update(obj);
		} catch (Exception e) {
			log.error("********** update ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 不操作事务，查询 操作的接口实现方法
	 */
	
	/* 
	 * 通过数据ID查询单条数据对象
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#find(int)
	 */
	@Override
	public VO find(int id) throws LogicException {
		try {
			return basicVODao.select(id);
		} catch (Exception e) {
			log.error("********** find ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "find", "find ERROR! ", e);
		}
	}

	/* 
	 * 得到所有的数据对象列表
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findAll()
	 */
	@Override
	public List<VO> findAll() throws LogicException {
		try {
			return basicVODao.selectAll();
		} catch (Exception e) {
			log.error("********** findAll ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", "findAll ERROR! ", e);
		}
	}

	/* 
	 * 得到数据对象列表
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findList(java.lang.Object)
	 */
	@Override
	public List<VO> findList(VO obj) throws LogicException {
		try {
			return basicVODao.selectList(obj);
		} catch (Exception e) {
			log.error("********** findList ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findList", "findList ERROR! ", e);
		}
	}

	/* 
     * 查找最新的一个对象
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findNew()
	 */
	@Override
	public VO findNew() throws LogicException {
		try {
			return basicVODao.selectNew();
		} catch (Exception e) {
			log.error("********** findNew ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", "findNew ERROR! ", e);
		}
	}

	/* 
     * 查找最新的count条对象
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findNewList(int)
	 */
	public List<VO> findNewList(int count) throws LogicException {
		try {
			return basicVODao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** findNewListByCount ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNewListByCount", "findNewListByCount ERROR! ", e);
		}
	}

	
	
	/**
	 * 分页操作的接口实现方法
	 */
	
	/* 
     * 得到数据对象列表按分页条数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return basicVODao.getCount(param);
		} catch (Exception e) {
			log.error("********** findCount ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findCount", "findCount ERROR! ", e);
		}
	}

	/*
     * 得到数据对象列表按分页条数，当pp.getNpageSize=0时返回所有
     * PageList 为分页的封装类 里面包含了总数集合 PageProperty分页的配置参数类 里面有页大小 总数 等等。。。
	 * PageUtil 分页的工具类 具体方法可以自己看
	 * {endrow=0, pageSize=5, startrow=0} 这三个参数 根据数据库不同用到的也不同 msql用到了
	 * pageSize=5, startrow=0这两个
	 * 这个就是分页的基础方法
	 * 问题错在这里
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findPageList(com.jinlong.common.page.PageProperty)
	 */
	@Override
	public PageList<VO> findPageList(PageProperty pp) throws LogicException {
		try {
			int count = basicVODao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());// mysql用到的参数
			return new PageList<VO>(pp, count, basicVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", "findPageList ERROR! ", e);
		}
	}

	/* 
	 * JQgrid分页查询
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseVOService#findJqPageList(java.lang.Object, com.jinlong.ssm.common.utils.page.JqPage)
	 */
	@Override
	public List<VO> findJqPageList(VO obj, JqPage pageInfo)
			throws LogicException {
		try {
			if (null != pageInfo) {
				Integer total = basicVODao.getCount(this.putToMap(pageInfo));
				Integer totalPage = Integer.valueOf(Integer.valueOf(total.intValue() / pageInfo.getRows().intValue()).intValue() 
						+ (total.intValue() % pageInfo.getRows().intValue() == 0 ? 0 : 1));
				pageInfo.setRecord(total);
				pageInfo.setTotalPage(totalPage);
				return basicVODao.getSplitList(putToMap(pageInfo));
			}
			return null;
		} catch (Exception e) {
			log.error("********** findJqPageList VehicleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findJqPageList", "findJqPageList ERROR! ", e);
		}
	}
	
	/**
	 * @HashMap转换
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String, Object> putToMap(JqPage pageInfo) throws LogicException {
		Map map = new HashMap();
		Integer curPage = pageInfo.getPage();
		Integer pageSize = pageInfo.getRows();
		Integer startRow = Integer.valueOf((curPage.intValue() - 1) * pageSize.intValue());
		map.put("startRow", startRow);
		map.put("pageSize", pageSize);
		return map;
	}
	
	/**
	 * *************************GET、SET方法**************************
	 */

	public IPO getBasicPODao() {
		return basicPODao;
	}

	public void setBasicPODao(IPO basicPODao) {
		this.basicPODao = basicPODao;
	}

	public IVO getBasicVODao() {
		return basicVODao;
	}

	public void setBasicVODao(IVO basicVODao) {
		this.basicVODao = basicVODao;
	}

}
