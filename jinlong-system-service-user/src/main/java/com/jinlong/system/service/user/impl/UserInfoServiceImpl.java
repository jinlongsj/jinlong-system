package com.jinlong.system.service.user.impl;

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
import com.jinlong.system.dao.user.IUserInfoDao;
import com.jinlong.system.model.po.user.UserInfo;
import com.jinlong.system.service.impl.BaseServiceImpl;
import com.jinlong.system.service.user.IUserInfoService;

/**
 * @description 用户主信息Service层实现类
 * @author 肖学进
 */
@Service
public class UserInfoServiceImpl extends
		BaseServiceImpl<UserInfo, IUserInfoDao> implements IUserInfoService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.userServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 注入用户主信息DAO持久化接口
	 */
	@Autowired
	private IUserInfoDao userInfoDao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */
	
	/* 
	 * @description 新增一条用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#add(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(UserInfo user) throws LogicException {
		try {
			return userInfoDao.insert(user);
		} catch (Exception e) {
			log.error("********** insert UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/* 
	 * @description 根据条件删除一组用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(UserInfo user) throws LogicException {
		try {
			return userInfoDao.delete(user);
		} catch (Exception e) {
			log.error("********** delete UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * @description 删除一条用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#deleteById(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int id) throws LogicException {
		try {
			return userInfoDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * @description 编辑修改一条用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(UserInfo user) throws LogicException {
		try {
			return userInfoDao.update(user);
		} catch (Exception e) {
			log.error("********** update UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 查询方法（不操作事务的方法）
	 */
	
	/* 
	 * @description 通过用户ID查询这一条用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#find(int)
	 */
	@Override
	public UserInfo find(int id) throws LogicException {
		try {
			return userInfoDao.select(id);
		} catch (Exception e) {
			log.error("********** update UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}

	/* 
	 * @description 查询所有的用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findAll()
	 */
	@Override
	public List<UserInfo> findAll() throws LogicException {
		try {
			return userInfoDao.selectAll();
		} catch (Exception e) {
			log.error("********** selectAll UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAll", e);
		}
	}

	/* 
	 * @description 通过条件查询一组用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findList(java.lang.Object)
	 */
	@Override
	public List<UserInfo> findList(UserInfo user) throws LogicException {
		try {
			return userInfoDao.selectList(user);
		} catch (Exception e) {
			log.error("********** selectList UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * @description 查询最新的一条用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNew()
	 */
	@Override
	public UserInfo findNew() throws LogicException {
		try {
			return userInfoDao.selectNew();
		} catch (Exception e) {
			log.error("********** selectNew UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}

	/* 
	 * @description 查询最新的count条用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNewList(int)
	 */
	@Override
	public List<UserInfo> findNewList(int count) throws LogicException {
		try {
			return userInfoDao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** selectNewList UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewList", e);
		}
	}
	
	
	
	/**
	 * 分页查询方法（不操作事务的方法）
	 */
	
	/* 
	 * @description 查询用户主信息总数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return userInfoDao.getCount(param);
		} catch (Exception e) {
			log.error("********** getCount UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}

	/* 
	 * @description 分页查询用户主信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	@Override
	public PageList<UserInfo> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = userInfoDao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<UserInfo>(pp, count, userInfoDao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}

}
