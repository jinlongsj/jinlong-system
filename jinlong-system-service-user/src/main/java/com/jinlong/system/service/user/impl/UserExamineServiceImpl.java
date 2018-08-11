package com.jinlong.system.service.user.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.common.utils.exception.LogicExceptionMessage;
import com.jinlong.system.common.utils.page.PageList;
import com.jinlong.system.common.utils.page.PageProperty;
import com.jinlong.system.common.utils.page.PageUtil;
import com.jinlong.system.dao.user.IUserBaseDao;
import com.jinlong.system.dao.user.IUserExamineDao;
import com.jinlong.system.dao.user.IUserExamineRecordDao;
import com.jinlong.system.dao.user.IUserInfoDao;
import com.jinlong.system.dao.user.IUserProcessDao;
import com.jinlong.system.model.enums.user.UserExamineState;
import com.jinlong.system.model.enums.user.UserProcessState;
import com.jinlong.system.model.enums.user.UserState;
import com.jinlong.system.model.po.user.UserBase;
import com.jinlong.system.model.po.user.UserExamine;
import com.jinlong.system.model.po.user.UserExamineRecord;
import com.jinlong.system.model.po.user.UserInfo;
import com.jinlong.system.model.po.user.UserProcess;
import com.jinlong.system.service.impl.BaseServiceImpl;
import com.jinlong.system.service.user.IUserExamineService;

/**
 * 用户审核信息Service业务层实现类
 * @author 肖学进
 */
@Service
public class UserExamineServiceImpl extends BaseServiceImpl<UserExamine, IUserExamineDao> implements IUserExamineService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.UserExamineImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 用户审核信息DAO接口
	 */
	@Autowired
	private IUserExamineDao userExamineDao;
	
	/**
	 * 用户审核历史记录信息DAO
	 */ 
	@Autowired
	private IUserExamineRecordDao userExamineRecordDao;
	
	/**
	 * 注入用户基础信息和用户主信息DAO
	 */
	@Autowired
	private IUserBaseDao userBaseDao;
	
	/**
	 * 注入用户详情信息DAO
	 */
	@Autowired
	private IUserInfoDao userInfoDao;
	
	/**
	 * 注入用户流程信息DAO
	 */
	@Autowired
	private IUserProcessDao userProcessDao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */
	
	/* 
	 * 新增一条用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#add(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(UserExamine userExamine) throws LogicException {
		try {
			// 设置审核时间
			userExamine.setExamineTime(new Date());
			// 审核是否通过
			userExamine.setState(userExamine.getPass());
			// 新增审核信息
			int ueIndex = userExamineDao.insert(userExamine);
			// 复制属性
			UserExamineRecord uer = new UserExamineRecord();
			BeanUtils.copyProperties(userExamine, uer);
			// 新增用户审核记录信息
			int uerIndex = userExamineRecordDao.insert(uer);
			// 修改用户基础信息和用户详细信息的状态
			UserBase ub = userBaseDao.select(userExamine.getUserId());
			UserInfo ui = userInfoDao.select(userExamine.getUserId());
			// 用户流程信息
			UserProcess up = new UserProcess();
			up.setUserId(userExamine.getUserId());
			up.setProcessTime(userExamine.getExamineTime());
			if (UserProcessState.addUserSubmitExamine.getValue() == ui.getState()) {
				// 当用户流程状态是：新增用户提交审核
				if (UserExamineState.passExamine.getValue() == userExamine.getState()) {
					ub.setState(UserState.alreadyActivated.getValue());
					ui.setState(UserProcessState.addUserSubmitExaminePass.getValue());
				} else {
					ub.setState(UserState.notActive.getValue());
					ui.setState(UserProcessState.addUserSubmitExamineNoPass.getValue());
				}
			} else if (UserProcessState.lockUserSubmitExamine.getValue() == ui.getState()) {
				// 当用户流程状态是：锁定用户提交审核
				if (UserExamineState.passExamine.getValue() == userExamine.getState()) {
					ub.setState(UserProcessState.lockUserSubmitExamine.getValue());
					ui.setState(UserProcessState.lockUserSubmitExaminePass.getValue());
				} else {
					ub.setState(UserState.notActive.getValue());
					ui.setState(UserProcessState.lockUserSubmitExamineNoPass.getValue());
				}
			} else if (UserProcessState.logoffUserSubmitExamine.getValue() == ui.getState()) {
				// 当用户流程状态是：注销用户提交审核
				if (UserExamineState.passExamine.getValue() == userExamine.getState()) {
					ub.setState(UserProcessState.logoffUserSubmitExamine.getValue());
					ui.setState(UserProcessState.lockUserSubmitExaminePass.getValue());
				} else {
					ub.setState(UserState.notActive.getValue());
					ui.setState(UserProcessState.lockUserSubmitExamineNoPass.getValue());
				}
			}
			// 设置用户流程状态
			up.setState(ui.getState());
			return ueIndex + uerIndex + userBaseDao.update(ub) + userInfoDao.update(ui) + userProcessDao.insert(up);
		} catch (Exception e) {
			log.error("********** insert UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/* 
	 * 通过条件删除一批用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(UserExamine userExamine) throws LogicException {
		try {
			return userExamineDao.delete(userExamine);
		} catch (Exception e) {
			log.error("********** delete UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * 通过ID删除一批用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#deleteById(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int id) throws LogicException {
		try {
			return userExamineDao.deleteById(id) + userExamineRecordDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 通过用户ID修改一条用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(UserExamine userExamine) throws LogicException {
		try {
			// 设置审核时间
			userExamine.setExamineTime(new Date());
			// 审核是否通过
			userExamine.setState(userExamine.getPass());
			// 复制属性
			UserExamineRecord uer = new UserExamineRecord();
			BeanUtils.copyProperties(userExamine, uer);
			int ueIndex = userExamineDao.update(userExamine);
			int uerIndex = userExamineRecordDao.insert(uer);
			// 修改用户基础信息和用户详细信息的状态
			UserBase ub = userBaseDao.select(userExamine.getUserId());
			UserInfo ui = userInfoDao.select(userExamine.getUserId());
			// 用户流程信息
			UserProcess up = new UserProcess();
			up.setUserId(userExamine.getUserId());
			up.setProcessTime(userExamine.getExamineTime());
			if (UserProcessState.addUserSubmitExamine.getValue() == ui.getState()) {
				// 当用户流程状态是：新增用户提交审核
				if (UserExamineState.passExamine.getValue() == userExamine.getState()) {
					ub.setState(UserState.alreadyActivated.getValue());
					ui.setState(UserProcessState.addUserSubmitExaminePass.getValue());
				} else {
					ub.setState(UserState.notActive.getValue());
					ui.setState(UserProcessState.addUserSubmitExamineNoPass.getValue());
				}
			} else if (UserProcessState.lockUserSubmitExamine.getValue() == ui.getState()) {
				// 当用户流程状态是：锁定用户提交审核
				if (UserExamineState.passExamine.getValue() == userExamine.getState()) {
					ub.setState(UserProcessState.lockUserSubmitExamine.getValue());
					ui.setState(UserProcessState.lockUserSubmitExaminePass.getValue());
				} else {
					ub.setState(UserState.notActive.getValue());
					ui.setState(UserProcessState.lockUserSubmitExamineNoPass.getValue());
				}
			} else if (UserProcessState.logoffUserSubmitExamine.getValue() == ui.getState()) {
				// 当用户流程状态是：注销用户提交审核
				if (UserExamineState.passExamine.getValue() == userExamine.getState()) {
					ub.setState(UserProcessState.logoffUserSubmitExamine.getValue());
					ui.setState(UserProcessState.lockUserSubmitExaminePass.getValue());
				} else {
					ub.setState(UserState.notActive.getValue());
					ui.setState(UserProcessState.lockUserSubmitExamineNoPass.getValue());
				}
			}
			// 设置用户流程状态
			up.setState(ui.getState());
			return ueIndex + uerIndex + userBaseDao.update(ub) + userInfoDao.update(ui) + userProcessDao.insert(up);
		} catch (Exception e) {
			log.error("********** update UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 查询方法（不操作事务的方法）
	 */
	
	/* 
	 * 通过用户ID查询一条用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#find(int)
	 */
	public UserExamine find(int id) throws LogicException {
		try {
			return userExamineDao.select(id);
		} catch (Exception e) {
			log.error("********** select UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * 查询所有的用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findAll()
	 */
	public List<UserExamine> findAll() throws LogicException {
		try {
			return userExamineDao.selectAll();
		} catch (Exception e) {
			log.error("********** selectAll UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAll", e);
		}
	}

	/* 
	 * 通过条件查询一批的用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findList(java.lang.Object)
	 */
	public List<UserExamine> findList(UserExamine userExamine) throws LogicException {
		try {
			return userExamineDao.selectList(userExamine);
		} catch (Exception e) {
			log.error("********** selectList UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * 查询最新的一条用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNew()
	 */
	public UserExamine findNew() throws LogicException {
		try {
			return userExamineDao.selectNew();
		} catch (Exception e) {
			log.error("********** selectNew UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}

	/* 
	 * 查询最新的数条用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNewList(int)
	 */
	public List<UserExamine> findNewList(int count) throws LogicException {
		try {
			return userExamineDao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** selectNewList UserExamine ERROR ********** Exception = " + e);
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
			return userExamineDao.getCount(param);
		} catch (Exception e) {
			log.error("********** getCount UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}

	/* 
	 * 通过条件分页查询一批的用户审核信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	public PageList<UserExamine> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = userExamineDao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<UserExamine>(pp, count, userExamineDao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList UserExamine ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}

}
