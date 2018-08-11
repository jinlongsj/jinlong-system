/**
 * FileName: 	 UserProcessServiceImpl.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By ZTE-ITS
 * Copyright:	Copyright(C) 2010-2011
 * Company   	ZTE-ITS WuXi LTD.
 * @author:		肖学进
 * @version		V1.0 
 * Createdate: 	2017年11月12日 下午7:59:44 
 **/

package com.jinlong.system.service.user.impl;

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
import com.jinlong.system.dao.user.IUserProcessDao;
import com.jinlong.system.dao.user.IUserProcessVODao;
import com.jinlong.system.model.po.page.JqPage;
import com.jinlong.system.model.po.user.UserProcess;
import com.jinlong.system.model.vo.user.UserProcessVO;
import com.jinlong.system.service.impl.BaseVOServiceImpl;
import com.jinlong.system.service.user.IUserProcessService;

/**
 * 用户流程信息POJO实体类、VO视图类Service业务层实现类
 * @author 肖学进
 */
@Service
public class UserProcessServiceImpl extends
		BaseVOServiceImpl<UserProcess, IUserProcessDao, UserProcessVO, IUserProcessVODao> implements
		IUserProcessService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.UserProcessServiceImpl";
	
	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 用户流程DAO流程持久层接口
	 */
	/**
	 * 注入用户流程信息DAO接口
	 */ 
	@Autowired
	private IUserProcessDao userProcessDao;
	
	/**
	 * 注入用户流程VO信息DAO接口
	 */ 
	@Autowired
	private IUserProcessVODao userProcessVODao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */

	/* 
	 * 新增一条用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserProcessService#add(com.jinlong.system.model.pojo.user.UserProcess)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(UserProcess UserProcess) throws LogicException {
		try {
			return userProcessDao.insert(UserProcess);
		} catch (Exception e) {
			log.error("********** insert UserProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", "insert UserProcess ERROR! ", e);
		}
	}

	/* 
	 * 通过条件删除一批用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserProcessService#delete(com.jinlong.system.model.pojo.user.UserProcess)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(UserProcess UserProcess) throws LogicException {
		try {
			return userProcessDao.delete(UserProcess);
		} catch (Exception e) {
			log.error("********** delete UserProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * 通过ID删除一批用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserProcessService#deleteById(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int processId) throws LogicException {
		try {
			return userProcessDao.deleteById(processId);
		} catch (Exception e) {
			log.error("********** deleteById UserProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 通过用户ID修改一条用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserProcessService#update(com.jinlong.system.model.pojo.user.UserProcess)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(UserProcess UserProcess) throws LogicException {
		try {
			return userProcessDao.update(UserProcess);
		} catch (Exception e) {
			log.error("********** update UserProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 查询方法（不操作事务的方法）
	 */
	
	/* 
	 * 通过用户ID查询一条用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#find(int)
	 */
	public UserProcessVO find(int id) throws LogicException {
		try {
			return userProcessVODao.select(id);
		} catch (Exception e) {
			log.error("********** select UserProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * 查询所有的用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findAll()
	 */
	public List<UserProcessVO> findAll() throws LogicException {
		try {
			return userProcessVODao.selectAll();
		} catch (Exception e) {
			log.error("********** selectAll UserProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAll", e);
		}
	}

	/* 
	 * 通过条件查询一批的用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findList(java.lang.Object)
	 */
	public List<UserProcessVO> findList(UserProcessVO UserProcessVO) throws LogicException {
		try {
			return userProcessVODao.selectList(UserProcessVO);
		} catch (Exception e) {
			log.error("********** selectList UserProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * 查询最新的一条用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNew()
	 */
	public UserProcessVO findNew() throws LogicException {
		try {
			return userProcessVODao.selectNew();
		} catch (Exception e) {
			log.error("********** selectNew UserProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}

	/* 
	 * 查询最新的数条用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNewList(int)
	 */
	public List<UserProcessVO> findNewList(int count) throws LogicException {
		try {
			return userProcessVODao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** selectNewList UserProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewList", e);
		}
	}
	
	
	
	/**
	 * 分页查询方法（不操作事务的方法）
	 */

	/* 
	 * 通过条件查询一批的用户的总条数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findCount(java.util.Map)
	 */
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return userProcessVODao.getCount(param);
		} catch (Exception e) {
			log.error("********** getCount UserProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}

	/* 
	 * 通过条件分页查询一批的用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	public PageList<UserProcessVO> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = userProcessVODao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<UserProcessVO>(pp, count, userProcessVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList UserProcessVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}
	
	/* 
	 * JQgrid分页查询用户流程信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.service.user.IUserProcessService#findJqPageList(com.jinlong.ssm.common.model.vo.UserProcessVO, com.jinlong.ssm.common.utils.page.JqPage)
	 */
	public List<UserProcessVO> findJqPageList(UserProcessVO userProcessVO, JqPage pageInfo) throws LogicException {
		try {
			if (null != pageInfo) {
				Integer total = userProcessVODao.getCount(this.putToMap(userProcessVO, pageInfo));
				Integer totalPage = Integer.valueOf(Integer.valueOf(total.intValue() / pageInfo.getRows().intValue()).intValue() 
						+ (total.intValue() % pageInfo.getRows().intValue() == 0 ? 0 : 1));
				pageInfo.setRecord(total);
				pageInfo.setTotalPage(totalPage);
				return userProcessVODao.getSplitList(this.putToMap(userProcessVO, pageInfo));
			}
			return null;
		} catch (Exception e) {
			log.error("********** findJqPageList UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findJqPageList", e);
		}
	}
	

	/**
	 * @HashMap转换
	 * @param userProcessVO
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String, Object> putToMap(UserProcessVO userProcessVO, JqPage pageInfo) throws LogicException {
		Map map = new HashMap();
		if (null != userProcessVO) {
			map.put("userId", userProcessVO.getUserId());
			map.put("userName", userProcessVO.getUserName());
			map.put("examineUserName", userProcessVO.getExamineUserName());
			map.put("startTime", userProcessVO.getStartTime());
			map.put("endTime", userProcessVO.getEndTime());
			map.put("pass", userProcessVO.getPass());
			map.put("state", userProcessVO.getState());
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
