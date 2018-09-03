/**
 * FileName: 	 RoleExamineRecordServiceImpl.java
 * @Description: 角色审核记录信息Service业务层实现类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月6日 上午11:11:18 
 **/

package com.jinlong.system.service.role.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.exception.LogicExceptionMessage;
import com.jinlong.common.page.PageList;
import com.jinlong.common.page.PageProperty;
import com.jinlong.common.page.PageUtil;
import com.jinlong.common.service.impl.BaseServiceImpl;
import com.jinlong.system.dao.role.IRoleExamineRecordDao;
import com.jinlong.system.model.po.role.RoleExamineRecordPO;
import com.jinlong.system.service.role.IRoleExamineRecordService;

/**
 * 角色审核记录信息Service业务层实现类
 * @author:	肖学进
 * @date: 2018年6月6日 上午11:11:18
 */
@Service
public class RoleExamineRecordServiceImpl extends
		BaseServiceImpl<RoleExamineRecordPO, IRoleExamineRecordDao> implements
		IRoleExamineRecordService {
	
	/**
	 * 本类所在的包名和方法名
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl";
	
	/**
	 * 日志记录器
	 */
	private static Log log = LogFactory.getLog(RoleExamineRecordServiceImpl.class);
	
	/**
	 * 注入角色审核记录信息类Dao接口
	 */
	@Autowired
	private IRoleExamineRecordDao roleExamineRecordDao;
	
	
	
	/**
	 * 增删改操作方法（操作事务的方法）
	 */
	
	/* 
	 * 新增角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#add(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int add(RoleExamineRecordPO roleExamineRecord) throws LogicException {
		try {
			return roleExamineRecordDao.insert(roleExamineRecord);
		} catch (Exception e) {
			log.error("********** add RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "add", e);
		}
	}

	/* 
	 * 删除角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#delete(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int delete(RoleExamineRecordPO roleExamineRecord) throws LogicException {
		try {
			return roleExamineRecordDao.delete(roleExamineRecord);
		} catch (Exception e) {
			log.error("********** delete RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * 通过ID删除角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#deleteById(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int deleteById(int id) throws LogicException {
		try {
			return roleExamineRecordDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	
	
	/**
	 * 查询操作方法（ 不操作实务的方法）
	 */
	
	/* 
	 * 修改角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#update(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int update(RoleExamineRecordPO roleExamineRecord) throws LogicException {
		try {
			return roleExamineRecordDao.update(roleExamineRecord);
		} catch (Exception e) {
			log.error("********** update RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}

	/* 
	 * 通过ID查询角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#find(int)
	 */
	@Override
	public RoleExamineRecordPO find(int id) throws LogicException {
		try {
			return roleExamineRecordDao.select(id);
		} catch (Exception e) {
			log.error("********** find RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "find", e);
		}
	}

	/* 
	 * 查询所有的角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findAll()
	 */
	@Override
	public List<RoleExamineRecordPO> findAll() throws LogicException {
		try {
			return roleExamineRecordDao.selectAll();
		} catch (Exception e) {
			log.error("********** findAll RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
	}

	/* 
	 * 通过条件查询角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findList(java.lang.Object)
	 */
	@Override
	public List<RoleExamineRecordPO> findList(RoleExamineRecordPO roleExamineRecord)
			throws LogicException {
		try {
			return roleExamineRecordDao.selectList(roleExamineRecord);
		} catch (Exception e) {
			log.error("********** findList RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findList", e);
		}
	}

	/* 
	 * 查询最新的一条角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findNew()
	 */
	@Override
	public RoleExamineRecordPO findNew() throws LogicException {
		try {
			return roleExamineRecordDao.selectNew();
		} catch (Exception e) {
			log.error("********** findNew RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}

	/* 
	 * 查询最新的Count条角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findNewList(int)
	 */
	@Override
	public List<RoleExamineRecordPO> findNewList(int count) throws LogicException {
		try {
			return roleExamineRecordDao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** findNewList RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNewList", e);
		}
	}
	
	
	
	/**
	 * 分页方法
	 */

	/* 
	 * 查询角色审核记录信息总条数
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return roleExamineRecordDao.getCount(param);
		} catch (Exception e) {
			log.error("********** findCount RoleExamineRecord ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNewList", e);
		}
	}
	
	/* 
	 * 分页查询角色审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findPageList(com.jinlong.ssm.common.utils.page.PageProperty)
	 */
	@Override
	public PageList<RoleExamineRecordPO> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = roleExamineRecordDao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<RoleExamineRecordPO>(pp, count, roleExamineRecordDao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}
}
