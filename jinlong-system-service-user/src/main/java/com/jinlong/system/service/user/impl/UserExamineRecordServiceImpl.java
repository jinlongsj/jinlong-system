package com.jinlong.system.service.user.impl;

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
import com.jinlong.system.dao.user.IUserExamineRecordDao;
import com.jinlong.system.model.po.user.UserExamineRecordPO;
import com.jinlong.system.service.user.IUserExamineRecordService;

/**
 * 用户审核记录信息Service业务层实现类
 * @author 肖学进
 */
@Service
public class UserExamineRecordServiceImpl extends BaseServiceImpl<UserExamineRecordPO, IUserExamineRecordDao> implements
	IUserExamineRecordService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.UserExamineProcessServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 用户审核记录记录信息DAO接口
	 */
	@Autowired
	private IUserExamineRecordDao userExamineProcessDao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */
	
	/* 
	 * 新增一条用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#add(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(UserExamineRecordPO userExamineProcess) throws LogicException {
		try {
			return userExamineProcessDao.insert(userExamineProcess);
		} catch (Exception e) {
			log.error("********** insert UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/* 
	 * 通过条件删除一批用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(UserExamineRecordPO userExamineProcess) throws LogicException {
		try {
			return userExamineProcessDao.delete(userExamineProcess);
		} catch (Exception e) {
			log.error("********** delete UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * 通过ID删除一批用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#deleteById(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int id) throws LogicException {
		try {
			return userExamineProcessDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 通过用户ID修改一条用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(UserExamineRecordPO userExamineProcess) throws LogicException {
		try {
			return userExamineProcessDao.update(userExamineProcess);
		} catch (Exception e) {
			log.error("********** update UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 查询方法（不操作事务的方法）
	 */
	
	/* 
	 * 通过用户ID查询一条用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#find(int)
	 */
	public UserExamineRecordPO find(int id) throws LogicException {
		try {
			return userExamineProcessDao.select(id);
		} catch (Exception e) {
			log.error("********** select UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * 查询所有的用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findAll()
	 */
	public List<UserExamineRecordPO> findAll() throws LogicException {
		try {
			return userExamineProcessDao.selectAll();
		} catch (Exception e) {
			log.error("********** selectAll UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAll", e);
		}
	}

	/* 
	 * 通过条件查询一批的用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findList(java.lang.Object)
	 */
	public List<UserExamineRecordPO> findList(UserExamineRecordPO userExamineProcess) throws LogicException {
		try {
			return userExamineProcessDao.selectList(userExamineProcess);
		} catch (Exception e) {
			log.error("********** selectList UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * 查询最新的一条用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNew()
	 */
	public UserExamineRecordPO findNew() throws LogicException {
		try {
			return userExamineProcessDao.selectNew();
		} catch (Exception e) {
			log.error("********** selectNew UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}

	/* 
	 * 查询最新的数条用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNewList(int)
	 */
	public List<UserExamineRecordPO> findNewList(int count) throws LogicException {
		try {
			return userExamineProcessDao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** selectNewList UserExamineProcess ERROR ********** Exception = " + e);
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
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findCount(java.util.Map)
	 */
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return userExamineProcessDao.getCount(param);
		} catch (Exception e) {
			log.error("********** getCount UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}

	/* 
	 * 通过条件分页查询一批的用户审核记录信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	public PageList<UserExamineRecordPO> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = userExamineProcessDao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<UserExamineRecordPO>(pp, count, userExamineProcessDao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList UserExamineProcess ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}

}
