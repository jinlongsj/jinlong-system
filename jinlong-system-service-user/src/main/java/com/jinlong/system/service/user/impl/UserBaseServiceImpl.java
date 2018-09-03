package com.jinlong.system.service.user.impl;

import java.util.Date;
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
import com.jinlong.system.common.utils.md5.MD5;
import com.jinlong.system.dao.user.IUserBaseDao;
import com.jinlong.system.model.po.user.UserBasePO;
import com.jinlong.system.service.user.IUserBaseService;

/**
 * @description 用户基础信息业务层实现类
 * @author 肖学进
 */
@Service
public class UserBaseServiceImpl extends BaseServiceImpl<UserBasePO, IUserBaseDao> implements IUserBaseService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.UserBaseServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 注入用户基础信息DAO持久化接口
	 */
	@Autowired
	private IUserBaseDao userBaseDao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */
	
	/* 
	 * @description 新增一条用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#add(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(UserBasePO userBase) throws LogicException {
		try {
			return userBaseDao.insert(setRegisterTimeAndPassword(userBase));
		} catch (Exception e) {
			log.error("********** insert UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/* 
	 * @description 批量新增一条用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserBaseService#bathAddUserBase(java.util.List)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int bathAddUserBase(List<UserBasePO> userBaseList)
			throws LogicException {
		try {
			return userBaseDao.bathInsert(userBaseList);
		} catch (Exception e) {
			log.error("********** bathAdd UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "bathAdd", e);
		}
	}
	
	/* 
	 * @description 根据条件删除一组用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(UserBasePO userBase) throws LogicException {
		try {
			return userBaseDao.delete(userBase);
		} catch (Exception e) {
			log.error("********** delete UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * @description 删除一条用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#deleteById(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int id) throws LogicException {
		try {
			return userBaseDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * @description 批量删除一批用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.user.IUserBaseService#bathDeleteUser(java.util.List)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int bathDeleteUser(List<Integer> userIdList) throws LogicException {
		try {
			return userBaseDao.bathDelete(userIdList);
		} catch (Exception e) {
			log.error("********** bathDelete UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "bathDelete", e);
		}
	}

	/* 
	 * @description 编辑修改一条用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(UserBasePO userBase) throws LogicException {
		try {
			return userBaseDao.update(userBase);
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
	 * @description 通过用户ID查询这一条用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#find(int)
	 */
	@Override
	public UserBasePO find(int id) throws LogicException {
		try {
			return userBaseDao.select(id);
		} catch (Exception e) {
			log.error("********** select UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * @description 查询所有的用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findAll()
	 */
	@Override
	public List<UserBasePO> findAll() throws LogicException {
		try {
			return userBaseDao.selectAll();
		} catch (Exception e) {
			log.error("********** selectAll UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAll", e);
		}
	}
	
	/* 
	 * @description 通过条件查询一组用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findList(java.lang.Object)
	 */
	public List<UserBasePO> findList(UserBasePO userBase) throws LogicException {
		try {
			return userBaseDao.selectList(userBase);
		} catch (Exception e) {
			log.error("********** selectList UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}
	
	/* 
	 * @description 查询最新的一条用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNew()
	 */
	public UserBasePO findNew() throws LogicException {
		try {
			return userBaseDao.selectNew();
		} catch (Exception e) {
			log.error("********** selectNew UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}
	
	/* 
	 * @description 查询最新的count条用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findNewList(int)
	 */
	public List<UserBasePO> findNewList(int count) throws LogicException {
		try {
			return userBaseDao.selectNewList(count);
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
	 * @description 查询用户基础信息总数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findCount(java.util.Map)
	 */
	public int findCount(Map<String, Object> param) throws LogicException{
		try {
			return userBaseDao.getCount(param);
		} catch (Exception e) {
			log.error("********** getCount UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}
	
	/* 
	 * @description 分页查询用户基础信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	public PageList<UserBasePO> findPageList(PageProperty pp) throws LogicException {
		try {
			int count = userBaseDao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<UserBasePO>(pp, count, userBaseDao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList UserInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}
	
	
	
	/**
	 * 业务方法
	 */
	
	/**
	 * @description 给用户寄出信息设置时间和密码加密
	 * @param userBase
	 * @return
	 * @throws LogicException
	 */
	public UserBasePO setRegisterTimeAndPassword(UserBasePO userBase) throws Exception{
		userBase.setRegisterTime(new Date());
		userBase.setPassword(MD5.md5crypt(userBase.getPassword()) + userBase.getRegisterTime().getTime());
		return userBase;
	}
	
}
