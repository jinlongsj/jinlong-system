package com.jinlong.system.service.user.impl;

import java.util.Date;
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
import com.jinlong.system.common.utils.md5.MD5;
import com.jinlong.system.common.utils.page.PageList;
import com.jinlong.system.common.utils.page.PageProperty;
import com.jinlong.system.common.utils.page.PageUtil;
import com.jinlong.system.dao.user.IUserBaseDao;
import com.jinlong.system.dao.user.IUserInfoDao;
import com.jinlong.system.dao.user.IUserProcessDao;
import com.jinlong.system.dao.user.IUserVODao;
import com.jinlong.system.model.enums.user.UserProcessState;
import com.jinlong.system.model.enums.user.UserState;
import com.jinlong.system.model.po.page.JqPage;
import com.jinlong.system.model.po.user.UserBase;
import com.jinlong.system.model.po.user.UserInfo;
import com.jinlong.system.model.po.user.UserProcess;
import com.jinlong.system.model.vo.user.UserVO;
import com.jinlong.system.service.impl.BaseVOServiceImpl;
import com.jinlong.system.service.user.IUserService;

/**
 * 用户总信息VO试图类Service业务层实现类
 * @author 肖学进
 */
@Service
public class UserServiceImpl extends BaseVOServiceImpl<UserBase, IUserBaseDao, UserVO, IUserVODao> implements IUserService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.UserBaseServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(UserServiceImpl.class);
	
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
	 * 注入用户VO类DAO
	 */
	@Autowired
	private IUserVODao userVODao;
	
	/**
	 * 注入用户流程信息DAO
	 */
	@Autowired
	private IUserProcessDao userProcessDao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */
	
	/* 
	 * @description 新增一条用户信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserService#add(com.jinlong.system.model.pojo.user.UserBase, com.jinlong.system.model.pojo.user.UserInfo)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(UserBase ub, UserInfo ui) throws LogicException {
		try {
			ub.setRegisterTime(new Date());
			// 密码加密为MDF + 时间戳
			ub.setPassword(MD5.md5crypt(ub.getPassword().trim()) + ub.getRegisterTime().toString());
			// 设置用户详细信息的流程状态
			if (UserState.notActive.getValue() == ub.getState()) {
				// 当用户状态是：新增状态，则设置甚至用户流程状态为：新增用户
				ui.setState(UserProcessState.addUser.getValue());
			} else if (UserState.alreadyActivated.getValue() == ub.getState()) {
			 	// 当用户状态是：已激活，则设置用户流程状态为：新增用户提交审核
				ui.setState(UserProcessState.addUserSubmitExamine.getValue());
			} else if (UserState.lockUser.getValue() == ub.getState()) {
				// 当用户状态是：锁定用户，则设置用户流程状态为：锁定用户提交审核
				ui.setState(UserProcessState.lockUserSubmitExamine.getValue());
			} else if (UserState.logoffUser.getValue() == ub.getState()) {
				// 当用户状态是：注销用户，则设置用户流程状态为：注销用户提交审核
				ui.setState(UserProcessState.logoffUserSubmitExamine.getValue());
			}
			// 设置用户基本信息的状态：只有审核通过，才能够更改用户的状态
			if (UserState.alreadyActivated.getValue() == ub.getState() || UserState.lockUser.getValue() == ub.getState() 
					|| UserState.logoffUser.getValue() == ub.getState()) {
				ub.setState(UserState.notActive.getValue());
			}
			int index = userBaseDao.insert(ub);
			// 给用户详细信息设置用户ID
			ui.setUserId(ub.getUserId());
			// 用户流程信息
			UserProcess up = new UserProcess();
			// 设置用户ID
			up.setUserId(ub.getUserId());
			// 设置流程时间
			up.setProcessTime(ub.getRegisterTime());
			// 设置流程状态
			up.setState(ui.getState());
			// 新增用户详细信息和用户流程信息
			return index + userInfoDao.insert(ui) + userProcessDao.insert(up);
		} catch (Exception e) {
			log.error("********** insert UserBase And UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/* 
	 * @description 通过UserBase和UserInfo对象的属性条件删除用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserService#delete(com.jinlong.system.model.pojo.user.UserBase, com.jinlong.system.model.pojo.user.UserInfo)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(UserBase ub, UserInfo ui) throws LogicException {
		try {
			return userBaseDao.delete(ub) + userInfoDao.delete(ui) - 1;
		} catch (Exception e) {
			log.error("********** delete UserBase And UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * @description 通过用户id删除一条用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserService#deleteById(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int userId) throws LogicException {
		try {
			return userBaseDao.deleteById(userId) + userInfoDao.deleteById(userId) - 1;
		} catch (Exception e) {
			log.error("********** deleteById UserBase And UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * @description 批量删除用户信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.service.user.IUserService#bathDelete(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int bathDelete(Integer[] userIds) throws LogicException {
		try {
			return userBaseDao.batchDelete(userIds);
		} catch (Exception e) {
			log.error("********** bathDelete UserBase And UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "bathDelete", e);
		}
	}

	/* 
	 * @description 编辑修改一条用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserService#update(com.jinlong.system.model.pojo.user.UserBase, com.jinlong.system.model.pojo.user.UserInfo)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(UserBase ub, UserInfo ui) throws LogicException {
		try {
			// 查询流程状态
			int processState = userInfoDao.select(ui.getUserId()).getState();
			// 设置用户详细信息的流程状态
			if (UserState.notActive.getValue() == ub.getState()) {
				// 当用户状态是：新增状态，则设置甚至用户流程状态为：新增用户
				ui.setState(UserProcessState.addUser.getValue());
			} else if (UserState.alreadyActivated.getValue() == ub.getState()) {
			 	// 当用户状态是：已激活，则设置用户流程状态为：新增用户提交审核
				ui.setState(UserProcessState.addUserSubmitExamine.getValue());
			} else if (UserState.lockUser.getValue() == ub.getState()) {
				// 当用户状态是：锁定用户，则设置用户流程状态为：锁定用户提交审核
				ui.setState(UserProcessState.lockUserSubmitExamine.getValue());
			} else if (UserState.logoffUser.getValue() == ub.getState()) {
				// 当用户状态是：注销用户，则设置用户流程状态为：注销用户提交审核
				ui.setState(UserProcessState.logoffUserSubmitExamine.getValue());
			}
			// 设置用户基本信息的状态：只有审核通过，才能够更改用户的状态
			if ((UserState.alreadyActivated.getValue() == ub.getState() && UserProcessState.addUserSubmitExamine.getValue() != processState)
					|| (UserState.lockUser.getValue() == ub.getState() && UserProcessState.lockUserSubmitExamine.getValue() != processState) 
					|| (UserState.logoffUser.getValue() == ub.getState() && UserProcessState.logoffUserSubmitExamine.getValue() != processState)) {
				ub.setState(UserState.notActive.getValue());
				// 用户流程信息
				UserProcess up = new UserProcess();
				// 设置用户ID
				up.setUserId(ub.getUserId());
				// 设置流程时间
				up.setProcessTime(new Date());
				// 设置流程状态
				up.setState(ui.getState());
				// 新增用户流程信息
				userProcessDao.insert(up);
			}
			return userBaseDao.update(ub) + userInfoDao.update(ui);
		} catch (Exception e) {
			log.error("********** update UserBase And UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}

	/* 
	 * @description 修改用户密码
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.service.user.IUserService#updatePassword(com.jinlong.ssm.common.model.pojp.UserBase)
	 */
	@Override
	public int updatePassword(UserBase ub) throws LogicException {
		try {
			// 密码加密为MDF + 时间戳
			ub.setPassword(MD5.md5crypt(ub.getPassword().trim()) + userBaseDao.select(ub.getUserId()).getRegisterTime().toString());
			// 修改用户密码
			return userBaseDao.update(ub);
		} catch (Exception e) {
			log.error("********** updatePassword UserBase ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "updatePassword", e);
		}
	}
	
	
	
	/**
	 * 查询方法（不操作事务的方法）
	 */
	
	/* 
	 * @description 通过用户ID查询这一条用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#find(int)
	 */
	@Override
	public UserVO find(int userId) throws LogicException {
		try {
			return userVODao.select(userId);
		} catch (Exception e) {
			log.error("********** select UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * @description 查询所有的用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.IUserService#findAll()
	 */
	@Override
	public List<UserVO> findAll() throws LogicException {
		try {
			return userVODao.selectAll();
		} catch (Exception e) {
			log.error("********** selectAll UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAll", e);
		}
	}

	/* 
	 * @description 通过条件查询一组用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.IUserService#findList(com.chujiaxc.system.model.vo.UserVO)
	 */
	@Override
	public List<UserVO> findList(UserVO user) throws LogicException {
		try {
			return userVODao.selectList(user);
		} catch (Exception e) {
			log.error("********** selectList UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * @description 查询最新的一条用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNew()
	 */
	@Override
	public UserVO findNew() throws LogicException {
		try {
			return userVODao.selectNew();
		} catch (Exception e) {
			log.error("********** selectNew UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}

	/* 
	 * @description 查询最新的count条用户基础信息和用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNewList(int)
	 */
	@Override
	public List<UserVO> findNewList(int count) throws LogicException {
		try {
			return userVODao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** selectNewList UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewList", e);
		}
	}
	
	
	
	/**
	 * 分页查询方法（不操作事务的方法）
	 */
	
	/* 
	 * @description 查询用户基础信息和用户主信息总数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return userVODao.getCount(param);
		} catch (Exception e) {
			log.error("********** getCount UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}

	/* 
	 * @description 分页查询用户基础信息和用户详情信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	@Override
	public PageList<UserVO> findPageList(PageProperty pp) throws LogicException {
		try {
			int count = userVODao.getCount(pp.getParamMap());
			int start = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int end = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startrow", start);
			pp.putParamMap("endrow", end);
			pp.putParamMap("pageSize", pp.getNpagesize());// mysql用到的参数
			return new PageList<UserVO>(pp, count, userVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList UserVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}

	/* 
	 * JQgrid分页查询用户基础信息和用户详情信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findJqPageList(com.jinlong.common.jqpage.JqPage)
	 */
	public List<UserVO> findJqPageList(UserVO userVO, JqPage pageInfo) throws LogicException {
		try {
			if (null != pageInfo) {
				Integer total = userVODao.getCount(this.putToMap(userVO, pageInfo));
				Integer totalPage = Integer.valueOf(Integer.valueOf(total.intValue() / pageInfo.getRows().intValue()).intValue() 
						+ (total.intValue() % pageInfo.getRows().intValue() == 0 ? 0 : 1));
				pageInfo.setRecord(total);
				pageInfo.setTotalPage(totalPage);
				return userVODao.getSplitList(this.putToMap(userVO, pageInfo));
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
	 * @param userVO
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String, Object> putToMap(UserVO userVO, JqPage pageInfo) throws LogicException {
		Map map = new HashMap();
		if (null != userVO) {
			map.put("userName", userVO.getUserName());
			map.put("roleId", userVO.getRoleId());
			map.put("mobilePhone", userVO.getMobilePhone());
			map.put("email", userVO.getEmail());
			map.put("realName", userVO.getRealName());
			map.put("nickName", userVO.getNickName());
			map.put("idNumber", userVO.getIdNumber());
			map.put("telephone", userVO.getTelephone());
			map.put("provinceId", userVO.getProvinceId());
			map.put("cityId", userVO.getCityId());
			map.put("zoneId", userVO.getZoneId());
			map.put("postCode", userVO.getPostCode());
			map.put("homePage", userVO.getHomePage());
			map.put("qqNumber", userVO.getQqNumber());
			map.put("aliPay", userVO.getAliPay());
			map.put("processState", userVO.getProcessState());
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

	@Override
	public void importExcel() {
		// TODO Auto-generated method stub
		
	}

}
