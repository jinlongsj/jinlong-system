/**
 * FileName: 	 RoleProcessServiceImpl.java
 * @Description: 角色流程信息Service业务层实现类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月6日 下午1:51:27 
 **/

package com.jinlong.system.service.role.impl;

import java.util.HashMap;
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
import com.jinlong.system.dao.role.IRoleProcessDao;
import com.jinlong.system.dao.role.IRoleProcessVODao;
import com.jinlong.system.model.po.page.JqPage;
import com.jinlong.system.model.po.role.RoleProcess;
import com.jinlong.system.model.vo.role.RoleProcessVO;
import com.jinlong.system.service.impl.BaseVOServiceImpl;
import com.jinlong.system.service.role.IRoleProcessService;

/**
 * 角色流程信息Service业务层实现类
 * @author:	肖学进
 * @date: 2018年6月6日 下午1:51:27
 */
@Service
public class RoleProcessServiceImpl extends
		BaseVOServiceImpl<RoleProcess, IRoleProcessDao, RoleProcessVO, IRoleProcessVODao> implements
		IRoleProcessService {
	
	/**
	 * 本类所在的包名和类名
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl";
	
	/**
	 * 日志记录器
	 */
	private static Log log = LogFactory.getLog(RoleProcessServiceImpl.class);
	
	/**
	 * 注入角色流程信息DAO接口
	 */
	@Autowired
	private IRoleProcessDao roleProcessDao;
	
	/**
	 * 注入角色流程VO信息DAO接口
	 */
	@Autowired
	private IRoleProcessVODao roleProcessVODao;
	
	
	
	/**
	 * 增删改操作方法（操作事务的方法）
	 */
	
	/* 
	 * 新增角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#add(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int add(RoleProcess roleProcess) throws LogicException {
		try {
			return roleProcessDao.insert(roleProcess);
		} catch (Exception e) {
			log.error("********** add RoleProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "add", e);
		}
	}

	/* 
	 * 删除角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#delete(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int delete(RoleProcess roleProcess) throws LogicException {
		try {
			return roleProcessDao.delete(roleProcess);
		} catch (Exception e) {
			log.error("********** delete RoleProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * 通过ID删除角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#deleteById(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int deleteById(int id) throws LogicException {
		try {
			return roleProcessDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById RoleProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 修改角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#update(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int update(RoleProcess roleProcess) throws LogicException {
		try {
			return roleProcessDao.update(roleProcess);
		} catch (Exception e) {
			log.error("********** update RoleProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}

	
	
	/**
	 * 查询操作方法（ 不操作实务的方法）
	 */
	
	/* 
	 * 通过ID查询角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#find(int)
	 */
	@Override
	public RoleProcessVO find(int id) throws LogicException {
		try {
			return roleProcessVODao.select(id);
		} catch (Exception e) {
			log.error("********** find RoleProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "find", e);
		}
	}

	/* 
	 * 查询所有的角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findAll()
	 */
	@Override
	public List<RoleProcessVO> findAll() throws LogicException {
		try {
			return roleProcessVODao.selectAll();
		} catch (Exception e) {
			log.error("********** findAll RoleProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
	}

	/* 
	 * 通过条件查询角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findList(java.lang.Object)
	 */
	@Override
	public List<RoleProcessVO> findList(RoleProcessVO roleProcess) throws LogicException {
		try {
			return roleProcessVODao.selectList(roleProcess);
		} catch (Exception e) {
			log.error("********** findList RoleProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findList", e);
		}
	}

	/* 
	 * 查询最新的一条角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findNew()
	 */
	@Override
	public RoleProcessVO findNew() throws LogicException {
		try {
			return roleProcessVODao.selectNew();
		} catch (Exception e) {
			log.error("********** findNew RoleProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}

	/* 
	 * 查询最新的count条角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findNewList(int)
	 */
	@Override
	public List<RoleProcessVO> findNewList(int count) throws LogicException {
		try {
			return roleProcessVODao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** findNew RoleProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}
	
	
	
	/**
	 * 分页方法
	 */
	
	/* 
	 * 查询角色流程信息总条数
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return roleProcessVODao.getCount(param);
		} catch (Exception e) {
			log.error("********** findCount RoleProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}

	/* 
	 * 分页查询角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findPageList(com.jinlong.ssm.common.utils.page.PageProperty)
	 */
	@Override
	public PageList<RoleProcessVO> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = roleProcessVODao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<RoleProcessVO>(pp, count, roleProcessVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList RoleProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}

	/* 
	 * JQgrid分页查询角色流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.service.IBaseService#findJqPageList(com.jinlong.ssm.common.utils.page.JqPage)
	 */
	@Override
	public List<RoleProcessVO> findJqPageList(RoleProcessVO roleProcess, JqPage pageInfo)
			throws LogicException {
		try {
			if (null != pageInfo) {
				Integer total = roleProcessVODao.getCount(this.putToMap(roleProcess, pageInfo));
				Integer totalPage = Integer.valueOf(Integer.valueOf(total.intValue() / pageInfo.getRows().intValue()).intValue() 
						+ (total.intValue() % pageInfo.getRows().intValue() == 0 ? 0 : 1));
				pageInfo.setTotalPage(totalPage);
				pageInfo.setRecord(total);
				return roleProcessVODao.getSplitList(this.putToMap(roleProcess, pageInfo));
			}
			return null;
		} catch (Exception e) {
			log.error("********** findJqPageList RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findJqPageList", e);
		}
	}
	
	/**
	 * @HashMap转换
	 * @param roleVO
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String, Object> putToMap(RoleProcessVO roleProcess, JqPage pageInfo) throws LogicException {
		Map map = new HashMap();
		if (null != roleProcess) {
			map.put("roleName", roleProcess.getRoleName());
			map.put("examineTime", roleProcess.getExamineTime());
			map.put("startTime", roleProcess.getStartTime());
			map.put("endTime", roleProcess.getEndTime());
			map.put("state", roleProcess.getState());
		}
		if (null != pageInfo) {
			Integer curPage = pageInfo.getPage();
			Integer pageSize = pageInfo.getRows();
			Integer startRow = Integer.valueOf((curPage.intValue() - 1) * pageSize.intValue());
			map.put("startRow", startRow);
			map.put("pageSize", pageSize);
		}
		return map;
	}

}
