/**
 * FileName: 	 RoleExamineServiceImpl.java
 * @Description: 角色审核流程信息Service业务层实现类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月5日 下午4:44:53 
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

import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.common.utils.exception.LogicExceptionMessage;
import com.jinlong.system.common.utils.page.PageList;
import com.jinlong.system.common.utils.page.PageProperty;
import com.jinlong.system.common.utils.page.PageUtil;
import com.jinlong.system.dao.role.IRoleExamineDao;
import com.jinlong.system.model.po.role.RoleExamine;
import com.jinlong.system.service.impl.BaseServiceImpl;
import com.jinlong.system.service.role.IRoleExamineService;

/**
 * 角色审核流程信息Service业务层实现类
 * @author:	肖学进
 * @date: 2018年6月5日 下午4:44:53
 */
@Service
public class RoleExamineServiceImpl extends
		BaseServiceImpl<RoleExamine, IRoleExamineDao> implements
		IRoleExamineService {
	
	/**
	 * 日志记录器
	 */
	private static final Log log = LogFactory.getLog(RoleExamineServiceImpl.class);
	
	/**
	 * 常量
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl";
	
	/**
	 * 注入角色审核信息DAO接口
	 */
	@Autowired
	private IRoleExamineDao roleExamineDao;
	
	
	
	/**
	 * 增删改操作方法（操作事务的方法）
	 */
	
	/* 
	 * 新增角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#add(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int add(RoleExamine roleExamine) throws LogicException {
		try {
			return roleExamineDao.insert(roleExamine);
		} catch (Exception e) {
			log.error("********** add RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "add", e);
		}
	}

	/* 
	 * 删除角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#delete(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int delete(RoleExamine roleExamine) throws LogicException {
		try {
			return roleExamineDao.delete(roleExamine);
		} catch (Exception e) {
			log.error("********** delete RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * 通过ID删除角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#deleteById(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int deleteById(int id) throws LogicException {
		try {
			return roleExamineDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 修改角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#update(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int update(RoleExamine roleExamine) throws LogicException {
		try {
			return roleExamineDao.update(roleExamine);
		} catch (Exception e) {
			log.error("********** update RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}

	
	
	/**
	 * 查询操作方法（ 不操作实务的方法）
	 */
	
	/* 
	 * 通过ID查询角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#find(int)
	 */
	@Override
	public RoleExamine find(int id) throws LogicException {
		try {
			return roleExamineDao.select(id);
		} catch (Exception e) {
			log.error("********** find RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "find", e);
		}
	}

	/* 
	 * 查询所有的角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findAll()
	 */
	@Override
	public List<RoleExamine> findAll() throws LogicException {
		try {
			return roleExamineDao.selectAll();
		} catch (Exception e) {
			log.error("********** findAll RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
	}

	/* 
	 * 通过条件查询角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findList(java.lang.Object)
	 */
	@Override
	public List<RoleExamine> findList(RoleExamine roleExamine) throws LogicException {
		try {
			return roleExamineDao.selectList(roleExamine);
		} catch (Exception e) {
			log.error("********** findList RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findList", e);
		}
	}

	/* 
	 * 查询最新的一条角色审核流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findNew()
	 */
	@Override
	public RoleExamine findNew() throws LogicException {
		try {
			return roleExamineDao.selectNew();
		} catch (Exception e) {
			log.error("********** findNew RoleExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}

	/* 
	 * 查询最新的Count条角色审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findNewList(int)
	 */
	@Override
	public List<RoleExamine> findNewList(int count) throws LogicException {
		try {
			return roleExamineDao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** findNewList RoleExamine ERROR ********** Exception = " + e);
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
			return roleExamineDao.getCount(param);
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
	public PageList<RoleExamine> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = roleExamineDao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<RoleExamine>(pp, count, roleExamineDao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}
}
