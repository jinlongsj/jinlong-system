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
import com.jinlong.system.dao.rolemenu.IRoleMenuDao;
import com.jinlong.system.dao.rolemenu.IRoleMenuVODao;
import com.jinlong.system.model.po.role.RoleMenu;
import com.jinlong.system.model.vo.role.RoleMenuVO;
import com.jinlong.system.service.impl.BaseVOServiceImpl;
import com.jinlong.system.service.role.IRoleMenuService;

/**
 * @description 角色菜单关系业务服务层实现类Impl
 * @author 肖学进
 */
@Service
public class RoleMenuServiceImpl extends BaseVOServiceImpl<RoleMenu, IRoleMenuDao, RoleMenuVO, IRoleMenuVODao>
		implements IRoleMenuService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.chujiaxc.system.service.impl.RoleMenuServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * Spring注入的MenuDao接口
	 */
	@Autowired
	private IRoleMenuDao roleMenuDao;
	
	/**
	 * Spring注入的MenuVODao接口
	 */
	@Autowired
	private IRoleMenuVODao roleMenuVODao;
	
	/**
	 * 操作事物，曾、删、改、查的接口
	 */

	/* 
	 * @Description:新增一条菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#add(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(RoleMenu roleMenu) throws LogicException {
		try {
			return roleMenuDao.insert(roleMenu);
		} catch (Exception e) {
			logger.error("********** insert RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/* 
	 * @description 批量新增角色菜单关系信息
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.RoleMenuService#bathAdd(java.util.List)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int bathAdd(List<RoleMenu> rmList) throws Exception {
		try {
			return roleMenuDao.bathInsert(rmList);
		} catch (Exception e) {
			logger.error("********** bathAdd RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "bathAdd", e);
		}
	}
	
	/* 
	 * @description 通过条件删除一条菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(RoleMenu roleMenu) throws LogicException {
		try {
			return roleMenuDao.delete(roleMenu);
		} catch (Exception e) {
			logger.error("********** delete RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}

	/* 
	 * @description 通过角色ID删除一个菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#deleteById(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int id) throws LogicException {
		try {
			return roleMenuDao.deleteById(id);
		} catch (Exception e) {
			logger.error("********** deleteById RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * @description 通过角色ID删除一个菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(RoleMenu roleMenu) throws LogicException {
		try {
			return roleMenuDao.update(roleMenu);
		} catch (Exception e) {
			logger.error("********** update RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 不操作事务，查询 操作的方法
	 */
	
	/* 
	 * @description 通过菜单角色关系对象的ID查询单条菜单角色关系对象信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#find(int)
	 */
	@Override
	public RoleMenuVO find(int id) throws LogicException {
		try {
			return roleMenuVODao.select(id);
		} catch (Exception e) {
			logger.error("********** select RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * @description 按顺序查询所有菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findAll()
	 */
	@Override
	public List<RoleMenuVO> findAll() throws LogicException {
		try {
			return roleMenuVODao.selectAll();
		} catch (Exception e) {
			logger.error("********** selectAll RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAll", e);
		}
	}

	/* 
	 * @description 通过菜单角色关系对象的ID查询单条菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findList(java.lang.Object)
	 */
	@Override
	public List<RoleMenuVO> findList(RoleMenuVO roleMenu) throws LogicException {
		try {
			return roleMenuVODao.selectList(roleMenu);
		} catch (Exception e) {
			logger.error("********** selectList RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * @description 查询最新的一条菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findNew()
	 */
	@Override
	public RoleMenuVO findNew() throws LogicException {
		try {
			return roleMenuVODao.selectNew();
		} catch (Exception e) {
			logger.error("********** roleMenuDao RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "roleMenuDao", e);
		}
	}

	/* 
	 * @description 查询最新的count条菜单角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findNewList(int)
	 */
	@Override
	public List<RoleMenuVO> findNewList(int count) throws LogicException {
		try {
			return roleMenuVODao.selectNewList(count);
		} catch (Exception e) {
			logger.error("********** selectNewList RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewList", e);
		}
	}
	
	
	
	/**
	 * 分页查询方法（不操作事务的方法）
	 */
	
	/* 
	 * @description 查询全部用户角色关系信息的总数
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return roleMenuVODao.getCount(param);
		} catch (Exception e) {
			logger.error("********** getCount RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}

	/* 
	 * @description 分页查询用户角色关系信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findPageList(com.jinlongshiji.common.utils.page.PageProperty)
	 */
	@Override
	public PageList<RoleMenuVO> findPageList(PageProperty pp)
			throws LogicException {
		try {
			int count = roleMenuVODao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<RoleMenuVO>(pp, count, roleMenuVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			logger.error("********** findPageList RoleMenu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}
}