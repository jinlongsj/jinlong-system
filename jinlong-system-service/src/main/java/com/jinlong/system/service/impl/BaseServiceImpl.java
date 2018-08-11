package com.jinlong.system.service.impl	;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.common.utils.exception.LogicExceptionMessage;
import com.jinlong.system.common.utils.page.PageList;
import com.jinlong.system.common.utils.page.PageProperty;
import com.jinlong.system.common.utils.page.PageUtil;
import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.page.JqPage;
import com.jinlong.system.service.IBaseService;

/**
 * 基础POJO实体类业务层SERVICEIMPL实现类
 * @author 肖学进
 * @param <T>
 */
public class BaseServiceImpl<T, I extends IBasicDao<T>> implements
		IBaseService<T> {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.common.service.impl.BaseServiceImpl";
	
	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * 基础DAO
	 */
	private I basicDao;
	
	
	
	/**
	 * 操作事物，曾、删、改的接口实现方法
	 */
	
	/*
	 * 创建数据对象
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#add(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = LogicException.class)
	public int add(T obj) throws LogicException {
		try {
			return basicDao.insert(obj);
		} catch (Exception e) {
			log.error("********** insert ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/*
	 * 删除单条数据对象 
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#delete(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = LogicException.class)
	public int delete(T obj) throws LogicException {
		try {
			return basicDao.delete(obj);
		} catch (Exception e) {
			log.error("********** delete ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}
	
	/*
	 * 删除单条数据对象
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#deleteById(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = LogicException.class)
	public int deleteById(int id) throws LogicException {
		try {
			return basicDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/*
	 * 修改单条据对象
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#update(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = LogicException.class)
	public int update(T obj) throws LogicException {
		try {
			return basicDao.update(obj);
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
	 * @see com.jinlong.common.service.IBaseService#find(int)
	 */
	public T find(int id) throws LogicException {
		try {
			return basicDao.select(id);
		} catch (Exception e) {
			log.error("********** find ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "find", e);
		}
	}

	/*
	 * 得到所有的数据对象列表
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#findAll()
	 */
	public List<T> findAll() throws LogicException {
		try {
			return basicDao.selectAll();
		} catch (Exception e) {
			log.error("********** findAll ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
	}
	
	/*
	 * 得到数据对象列表
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#findList(java.lang.Object)
	 */
	public List<T> findList(T obj) throws LogicException{
		try {
			return basicDao.selectList(obj);
		} catch (Exception e) {
			log.error("********** findList ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findList", e);
		}
	}
	
	/* 
     * 查找最新的一个对象
     * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#findNew()
	 */
	public T findNew() throws LogicException {
		try {
			return basicDao.selectNew();
		} catch (Exception e) {
			log.error("********** findNew ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}

	/* 
     * 查找最新的count条对象
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#findNewList(int)
	 */
	public List<T> findNewList(int count) throws LogicException {
		try {
			return basicDao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** findNewListByCount ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNewListByCount", e);
		}
	}

	
	
	/**
	 * 分页操作的接口实现方法
	 */
	
	/*
     * 得到数据对象列表按分页条数
     * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#findCount(java.util.Map)
	 */
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return basicDao.getCount(param);
		} catch (Exception e) {
			log.error("********** findCount ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findCount", e);
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
	 * @see com.jinlong.common.service.IBaseService#findPageList(com.jinlong.common.page.PageProperty)
	 */
	public PageList<T> findPageList(PageProperty pp) throws LogicException {
		try {
			int count = basicDao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());// mysql用到的参数
			return new PageList<T>(pp, count, basicDao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}
	
	/* 
	 * JQgrid查询总条数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#findJqPageCount(com.jinlong.common.jqpage.JqPage)
	 */
	public int findJqPageCount(JqPage pageInfo) throws LogicException {
		try {
			return basicDao.getCount(putToMap(pageInfo));
		} catch (Exception e) {
			log.error("********** findJqPageCount VehicleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findJqPageCount", e);
		}
	}

	/* 
	 * JQgrid分页查询
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseService#findJqPageList(com.jinlong.common.jqpage.JqPage)
	 */
	public List<T> findJqPageList(JqPage pageInfo) throws LogicException {
		try {
			return basicDao.getSplitList(putToMap(pageInfo));
		} catch (Exception e) {
			log.error("********** findJqPageList VehicleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findJqPageList", e);
		}
	}
	
	/**
	 * @HashMap转换
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<String, Object> putToMap(JqPage pageInfo) throws LogicException {
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
	public I getBasicDao() {
		return basicDao;
	}

	public void setBasicDao(I basicDao) {
		this.basicDao = basicDao;
	}
}
