package com.jinlong.system.service.common.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.exception.LogicExceptionMessage;
import com.jinlong.system.dao.common.ICommonDao;
import com.jinlong.system.service.common.ICommonService;

/**
 * @description 公共字典表查询的Service业务层实现类
 * @author 肖学进
 */
@Service
public class CommonServiceImpl implements ICommonService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.chujia.system.service.impl.CommonServiceImpl";
	
	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * Spring注入公共字典表查询的DAO数据持久化层接口
	 */
	@Autowired
	private ICommonDao commonDao;

	/* 
	 * @description 查询所有的用户状态字典信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.ICommonService#findUserState()
	 */
	@Override
	public List<Map<Integer, String>> findUserState() throws LogicException {
		try {
			return commonDao.selectUserState();
		} catch (Exception e) {
			log.error("********** selectUserState ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectUserState", e);
		}
	}

	/* 
	 * @description 查询所有的用户流程状态字典信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.service.common.ICommonService#findUserProccessState()
	 */
	@Override
	public List<Map<Integer, String>> findUserProcessState()
			throws LogicException {
		try {
			return commonDao.selectUserProcessState();
		} catch (Exception e) {
			log.error("********** selectUserProcessState ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectUserProcessState", e);
		}
	}

	/* 
	 * @description 查询所有的角色类别字典信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.ICommonService#findRoleType()
	 */
	@Override
	public List<Map<Integer, String>> findRoleType() throws LogicException {
		try {
			return commonDao.selectRoleType();
		} catch (Exception e) {
			log.error("********** selectRoleType ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectRoleType", e);
		}
	}

	/* 
	 * @description 查询所有的角色状态字典信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.ICommonService#findRoleState()
	 */
	@Override
	public List<Map<Integer, String>> findRoleState() throws LogicException {
		try {
			return commonDao.selectRoleState();
		} catch (Exception e) {
			log.error("********** selectRoleState ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectRoleState", e);
		}
	}

	/* 
	 * @description 查询所有的角色流程状态字典信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.common.ICommonService#findRoleProccessState()
	 */
	@Override
	public List<Map<Integer, String>> findRoleProcessState() throws LogicException {
		try {
			return commonDao.selectRoleProcessState();
		} catch (Exception e) {
			log.error("********** selectRoleProcessState ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectRoleProcessState", e);
		}
	}

	/* 
	 * @description 查询所有的菜单类别字典信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.ICommonService#findMenuType()
	 */
	@Override
	public List<Map<Integer, String>> findMenuType() throws LogicException {
		try {
			return commonDao.selectMenuType();
		} catch (Exception e) {
			log.error("********** selectMenuType ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectMenuType", e);
		}
	}

	/* 
	 * @description 查询所有的菜单级别字典信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.common.ICommonService#findMenuLeval()
	 */
	@Override
	public List<Map<Integer, String>> findMenuLeval() throws LogicException {
		try {
			return commonDao.selectMenuLeval();
		} catch (Exception e) {
			log.error("********** selectMenuLeval ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectMenuLeval", e);
		}
	}

	/*
	 * @description 查询所有的菜单状态字典信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.ICommonService#findMenuState()
	 */
	@Override
	public List<Map<Integer, String>> findMenuState() throws LogicException {
		try {
			return commonDao.selectMenuState();
		} catch (Exception e) {
			log.error("********** selectMenuState ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectMenuState", e);
		}
	}

	/* 
	 * @description 查询所有的菜单流程状态字典信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.common.ICommonService#findMenuProccessState()
	 */
	@Override
	public List<Map<Integer, String>> findMenuProcessState() throws LogicException {
		try {
			return commonDao.selectMenuProcessState();
		} catch (Exception e) {
			log.error("********** selectMenuProcessState ERROR  ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectMenuProcessState", e);
		}
	}
	
}