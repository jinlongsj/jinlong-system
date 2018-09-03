package com.jinlong.system.service.role.impl;

import java.util.ArrayList;
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

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.exception.LogicExceptionMessage;
import com.jinlong.common.model.po.page.JqPage;
import com.jinlong.common.page.PageList;
import com.jinlong.common.page.PageProperty;
import com.jinlong.common.page.PageUtil;
import com.jinlong.common.service.impl.BaseVOServiceImpl;
import com.jinlong.system.dao.role.IRoleDao;
import com.jinlong.system.dao.role.IRoleProcessDao;
import com.jinlong.system.dao.role.IRoleVODao;
import com.jinlong.system.dao.rolemenu.IRoleMenuDao;
import com.jinlong.system.model.enums.role.RoleProcessState;
import com.jinlong.system.model.enums.role.RoleState;
import com.jinlong.system.model.po.role.RoleMenuPO;
import com.jinlong.system.model.po.role.RoleInfoPO;
import com.jinlong.system.model.po.role.RoleProcessPO;
import com.jinlong.system.model.vo.role.RoleVO;
import com.jinlong.system.service.role.IRoleService;

/**
 * 角色信息Service业务层实现类
 * @author 肖学进
 */
@Service
public class RoleServiceImpl extends BaseVOServiceImpl<RoleInfoPO, IRoleDao, RoleVO, IRoleVODao> implements IRoleService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.impl.RoleServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * Spring注入的RoleDao接口
	 */
	/**
	 * 角色信息DAO
	 */ 
	@Autowired
	private IRoleDao roleDao;
	
	/**
	 * 角色信息VO DAO
	 */ 
	@Autowired
	private IRoleVODao roleVODao;
	
	/**
	 * 角色菜单信息Dao
	 */ 
	@Autowired
	private IRoleMenuDao roleMenuDao;
	
	/**
	 * 角色流程信息Dao
	 */
	@Autowired
	private IRoleProcessDao roleProcessDao;
	
	
	
	/**
	 * 增删改操作方法（操作事务的方法）
	 */
	
	/* 
     * 新增一条角色信息
     * (non-Javadoc)
	 * @see com.jinlong.system.service.role.IRoleService#add(com.jinlong.system.model.pojo.role.RoleInfo)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int add(RoleInfoPO role, List<Integer> menuIds) throws LogicException {
		try {
			// 设置角色详细信息的流程状态
			if (RoleState.notActive.getValue() == role.getState()) {
				// 当角色状态是：未激活状态的时候，则设置流程状态：新增角色
				role.setProcessState(RoleProcessState.addRole.getValue());
			} else if (RoleState.alreadyActivated.getValue() == role.getState()) {
				// 当角色状态是：已激活，则设置流程状态为：新增角色提交审核
				role.setProcessState(RoleProcessState.addRoleSubmitExamine.getValue());
			} else if (RoleState.lockRole.getValue() == role.getState()) {
				// 当角色状态是：锁定角色，则设置流程状态为：锁定角色提交审核
				role.setProcessState(RoleProcessState.lockRoleSubmitExamine.getValue());
			} else if (RoleState.logoffRole.getValue() == role.getState()) {
				// 当角色状态是：注销角色，则设置流程状态为：注销角色提交审核
				role.setProcessState(RoleProcessState.logoffRoleSubmitExamine.getValue());
			}
			// 设置用户基本信息的状态：只有审核通过，才能够更改用户的状态
			if (RoleState.alreadyActivated.getValue() == role.getState() || RoleState.lockRole.getValue() == role.getState() 
					|| RoleState.logoffRole.getValue() == role.getState()) {
				role.setState(RoleState.notActive.getValue());
			}
			// 插入角色信息
			roleDao.insert(role);
			// 角色流程信息
			RoleProcessPO rp = new RoleProcessPO();
			rp.setRoleId(role.getRoleId());
			rp.setProcessTime(new Date());
			rp.setState(role.getProcessState());
			// 查询流程信息
			roleProcessDao.insert(rp);
			// 原先分配的角色菜单关系列表
			List<RoleMenuPO> rmList = new ArrayList<RoleMenuPO>();
			// 分配菜单
			for (int menuId : menuIds) {
				RoleMenuPO rm = new RoleMenuPO();
				rm.setMenuId(menuId);
				rm.setRoleId(role.getRoleId());
				rmList.add(rm);
			}
			return roleMenuDao.bathInsert(rmList);
		} catch (Exception e) {
			log.error("********** add RoleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "add", e);
		}
	}

	/* 
	 * 通过条件删除一批角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.role.IRoleService#delete(com.jinlong.system.model.pojo.role.RoleInfo)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int delete(RoleInfoPO role) throws LogicException {
		try {
			return roleDao.delete(role);
		} catch (Exception e) {
			log.error("********** delete RoleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}
	
	/* 
	 * 通过驾校角色ID删除一条角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.role.IRoleService#deleteById(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int deleteById(int roleId) throws LogicException {
		try {
			return roleDao.deleteById(roleId);
		} catch (Exception e) {
			log.error("********** deleteById RoleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 通过角色ID修改一条角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.system.service.role.IRoleService#update(com.jinlong.system.model.pojo.role.RoleInfo)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int update(RoleInfoPO role, List<Integer> menuIds) throws LogicException {
		try {
			// 设置用户基本信息的状态：只有审核通过，才能够更改用户的状态
			if ((RoleState.alreadyActivated.getValue() == role.getState() && RoleProcessState.addRoleSubmitExamine.getValue() != role.getProcessState())
					|| (RoleState.lockRole.getValue() == role.getState() && RoleProcessState.lockRoleSubmitExamine.getValue() != role.getProcessState())
					|| (RoleState.logoffRole.getValue() == role.getState() && RoleProcessState.logoffRoleSubmitExamine.getValue() != role.getProcessState())) {
				role.setState(RoleState.notActive.getValue());
				// 角色流程信息
				RoleProcessPO rp = new RoleProcessPO();
				rp.setRoleId(role.getRoleId());
				rp.setProcessTime(new Date());
				rp.setState(role.getProcessState());
				// 查询流程信息
				roleProcessDao.insert(rp);
			}
			// 设置角色详细信息的流程状态
			if (RoleState.notActive.getValue() == role.getState()) {
				// 当角色状态是：未激活状态的时候，则设置流程状态：新增角色
				role.setProcessState(RoleProcessState.addRole.getValue());
			} else if (RoleState.alreadyActivated.getValue() == role.getState()) {
				// 当角色状态是：已激活，则设置流程状态为：新增角色提交审核
				role.setProcessState(RoleProcessState.addRoleSubmitExamine.getValue());
			} else if (RoleState.lockRole.getValue() == role.getState()) {
				// 当角色状态是：锁定角色，则设置流程状态为：锁定角色提交审核
				role.setProcessState(RoleProcessState.lockRoleSubmitExamine.getValue());
			} else if (RoleState.logoffRole.getValue() == role.getState()) {
				// 当角色状态是：注销角色，则设置流程状态为：注销角色提交审核
				role.setProcessState(RoleProcessState.logoffRoleSubmitExamine.getValue());
			}
			// 删除原来的角色菜单关系
			roleMenuDao.deleteById(role.getRoleId());
			// 原先分配的角色菜单关系列表
			List<RoleMenuPO> rmList = new ArrayList<RoleMenuPO>();
			// 分配菜单
			for (int menuId : menuIds) {
				RoleMenuPO rm = new RoleMenuPO();
				rm.setMenuId(menuId);
				rm.setRoleId(role.getRoleId());
				rmList.add(rm);
			}
			return roleDao.update(role) + roleMenuDao.bathInsert(rmList);
		} catch (Exception e) {
			log.error("********** update RoleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}

	
	
	/**
	 * 查询操作方法（ 不操作实务的方法）
	 */
	
	/* 
	 * 通过驾校ID查询一条角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#find(int)
	 */
	@Override
	public RoleVO find(int roleId) throws LogicException {
		try {
			return roleVODao.select(roleId);
		} catch (Exception e) {
			log.error("********** find RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "find", e);
		}
	}

	/* 
	 * 查询所有角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findAll()
	 */
	@Override
	public List<RoleVO> findAll() throws LogicException {
		try {
			return roleVODao.selectAll();
		} catch (Exception e) {
			log.error("********** findAll RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
	}

	/* 
	 * 通过驾校各个属性删除一组角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findList(java.lang.Object)
	 */
	@Override
	public List<RoleVO> findList(RoleVO role) throws LogicException {
		try {
			return roleVODao.selectList(role);
		} catch (Exception e) {
			log.error("********** findList RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findList", e);
		}
	}

	/* 
	 * 查询最新的一条角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNew()
	 */
	@Override
	public RoleVO findNew() throws LogicException {
		try {
			return roleVODao.selectNew();
		} catch (Exception e) {
			log.error("********** findNew RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}

	/* 
	 * 查询最新的count条角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNewList(int)
	 */
	@Override
	public List<RoleVO> findNewList(int count) throws LogicException {
		try {
			return roleVODao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** selectNewList RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewList", e);
		}
	}
	
	
	
	/**
	 * 分页方法
	 */
	
	/* 
	 * 查询角色信息的总条数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return roleVODao.getCount(param);
		} catch (Exception e) {
			log.error("********** findCount RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findCount", e);
		}
	}

	/* 
	 * 分页查询角色信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	@Override
	public PageList<RoleVO> findPageList(PageProperty pp) throws LogicException {
		try {
			int count = roleVODao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<RoleVO>(pp, count, roleVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList RoleVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}

	/* 
	 * JQgrid分页查询
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findJqPageList(com.jinlong.common.jqpage.JqPage)
	 */
	@Override
	public List<RoleVO> findJqPageList(RoleVO role, JqPage pageInfo) throws LogicException {
		try {
			if (null != pageInfo) {
				Integer total = roleVODao.getCount(this.putToMap(role, pageInfo));
				Integer totalPage = Integer.valueOf(Integer.valueOf(total.intValue() / pageInfo.getRows().intValue()).intValue() 
						+ (total.intValue() % pageInfo.getRows().intValue() == 0 ? 0 : 1));
				pageInfo.setTotalPage(totalPage);
				pageInfo.setRecord(total);
				return roleVODao.getSplitList(this.putToMap(role, pageInfo));
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
	protected Map<String, Object> putToMap(RoleVO role, JqPage pageInfo) throws LogicException {
		Map map = new HashMap();
		if (null != role) {
			map.put("userName", role.getRoleName());
			map.put("typeId", role.getTypeId());
			map.put("state", role.getState());
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