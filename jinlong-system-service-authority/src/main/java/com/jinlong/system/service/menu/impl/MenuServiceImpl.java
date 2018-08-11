package com.jinlong.system.service.menu.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
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
import com.jinlong.system.dao.menu.IMenuDao;
import com.jinlong.system.dao.menu.IMenuVODao;
import com.jinlong.system.dao.rolemenu.IRoleMenuDao;
import com.jinlong.system.model.po.menu.MenuInfo;
import com.jinlong.system.model.po.page.JqPage;
import com.jinlong.system.model.po.role.RoleInfo;
import com.jinlong.system.model.po.role.RoleMenu;
import com.jinlong.system.model.vo.menu.MenuVO;
import com.jinlong.system.model.vo.role.RoleVO;
import com.jinlong.system.service.impl.BaseVOServiceImpl;
import com.jinlong.system.service.menu.IMenuService;

/**
 * @description 菜单信息Service业务层实现类Impl
 * @author 肖学进
 */
@Service
public class MenuServiceImpl extends BaseVOServiceImpl<MenuInfo, IMenuDao, MenuVO, IMenuVODao> implements
		IMenuService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.menu.impl.MenuServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * Spring注入的MenuDao接口
	 */
	
	// MenuDao
	@Autowired
	private IMenuDao menuDao;
	
	// MenuDao
	@Autowired
	private IMenuVODao menuVODao;
	
	// RoleMenuDao
	@Autowired
	private IRoleMenuDao roleMenuDao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */
	
	/* 
	 * @description 新增一条菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#add(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(MenuInfo menu) throws LogicException {
		try {
			return menuDao.insert(menu);
		} catch (Exception e) {
			log.error("********** insert MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}
	
	/* 
	 * @description 通过条件删除一条菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(MenuInfo menu) throws LogicException {
		try {
			return menuDao.delete(menu);
		} catch (Exception e) {
			log.error("********** delete Menu ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}
	
	/* 
	 * @description 通过菜单ID删除一个菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#deleteById(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int id) throws LogicException {
		try {
			return menuDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}
	
	/* 
	 * @description 通过菜单ID修改一条菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(MenuInfo menu) throws LogicException {
		try {
			return menuDao.update(menu);
		} catch (Exception e) {
			log.error("********** update MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 不操作事务，查询 操作的方法
	 */
	
	/* 
	 * @description 通过菜单ID查询一条菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#find(int)
	 */
	@Override
	public MenuVO find(int id) throws LogicException {
		try {
			return menuVODao.select(id);
		} catch (Exception e) {
			log.error("********** select MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "select", e);
		}
	}

	/* 
	 * @description 查询所有菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findList(java.lang.Object)
	 */
	@Override
	public List<MenuVO> findList(MenuVO menu) throws LogicException {
		try {
			return menuVODao.selectList(menu);
		} catch (Exception e) {
			log.error("********** selectList MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectList", e);
		}
	}

	/* 
	 * @description 查询最新的一条菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findNew()
	 */
	@Override
	public MenuVO findNew() throws LogicException {
		try {
			return menuVODao.selectNew();
		} catch (Exception e) {
			log.error("********** selectNew MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNew", e);
		}
	}

	/* 
	 * @description 查询最新的count条菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findNewList(int)
	 */
	@Override
	public List<MenuVO> findNewList(int count) throws LogicException {
		try {
			return menuVODao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** selectNewList MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewList", e);
		}
	}
	
	/* 
	 * @Description:查询所有的一级菜单
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#findAllParent()
	 */
	public List<MenuVO> findAllParent() throws LogicException {
		try {
			return menuVODao.selectAllParent();
		} catch (Exception e) {
			log.error("********** selectAllParent MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectAllParent", e);
		}
	}
	
	/* 
	 * @Description:查询此菜单下面的所有二级菜单，并且按顺序排列
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#findSon(com.jinlongshiji.modle.Menu)
	 */
	public List<MenuVO> findSon(int menuId) throws LogicException {
		try {
			return menuVODao.selectSon(menuId);
		} catch (Exception e) {
			log.error("********** selectSon MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectSon", e);
		}
	}
	
	/* 
	 * @Description:通过userId查询此用户下所有菜单
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#findListByUser(com.cweb.aco.system.user.entity.User)
	 */
	public List<MenuVO> findListByUser(int userId) throws LogicException {
		try {
			return this.findAllSonByList(menuVODao.selectListByUser(userId));
		} catch (Exception e) {
			log.error("********** selectListByUser MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectListByUser", e);
		}
	}

	/* 
	 * @description：查询所有的菜单信息，然后把它们组装成JSON对象
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.IMenuService#findAllMenu()
	 */
	@Override
	public List<MenuVO> findAllMenu() throws LogicException {
		try {
			return menuVODao.selectAll();
		} catch (Exception e) {
			log.error("********** findAllMenu MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAllMenu", e);
		}
	}
	
	
	
	/**
	 * 分页查询方法（不操作事务的方法）
	 */

	/* 
	 * @description
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findCount(java.util.Map)
	 */
	@Override
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return menuVODao.getCount(param);
		} catch (Exception e) {
			log.error("********** getCount MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "getCount", e);
		}
	}

	/* 
	 * @description 菜单信息列表树分页查询方法
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.impl.BaseServiceImpl#findPageList(com.jinlongshiji.common.utils.page.PageProperty)
	 */
	@Override
	public PageList<MenuVO> findPageList(PageProperty pp)
			throws LogicException {
		PageList<MenuVO> pageList = null;
		try {
			int count = menuVODao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count, pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			pageList = new PageList<MenuVO>(pp, count, menuVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
		return pageList;
	}

	/* 
	 * @description 菜单信息列表树总分页方法 
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.IMenuService#findPage(com.jinlongshiji.common.utils.page.PageProperty)
	 */
	@Override
	public PageList<MenuVO> findPage(PageProperty pp) throws LogicException {
		try {
			PageList<MenuVO> pageList = this.findPageList(pp);
			List<MenuVO> menuList = pageList.getRecords();
			if (null != menuList && 0 < menuList.size()) {
				for (MenuVO menu : menuList) {
					this.findAllSon(menu);
				}
			}
			return pageList;
		} catch (Exception e) {
			log.error("********** findPage MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPage", e);
		}
	}

	/**
	 * @param obj
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	@Override
	public List<MenuVO> findJqPageList(MenuVO menu, JqPage pageInfo)
			throws LogicException {
		try {
			if (null != pageInfo) {
				Integer total = menuVODao.getCount(this.putToMap(pageInfo));
				Integer totalPage = Integer.valueOf(Integer.valueOf(total.intValue() / pageInfo.getRows().intValue()).intValue() 
						+ (total.intValue() % pageInfo.getRows().intValue() == 0 ? 0 : 1));
				pageInfo.setRecord(total);
				pageInfo.setTotalPage(totalPage);
				return menuVODao.getSplitList(putToMap(pageInfo));
			}
			return null;
		} catch (Exception e) {
			log.error("********** findJqPageList VehicleInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findJqPageList", "findJqPageList ERROR! ", e);
		}
	}

	/**
	 * @param menu
	 * @return
	 * @throws LogicException
	 */
	public List<MenuVO> findSonPage(List<MenuVO> sortMenuList, MenuVO menu, int parentId) throws LogicException {
		try {
			List<MenuVO> sonList = this.findSon(menu.getMenuId());
			if (CollectionUtils.isNotEmpty(sonList)) {
				menu.setIsLeaf(false);
				menu.setLoaded(true);
				menu.setExpanded(false);
			} else {
				menu.setIsLeaf(true);
				menu.setLoaded(false);
				menu.setExpanded(true);
				sortMenuList.add(menu);
			}
		} catch (Exception e) {
			log.error("********** findAllSon MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAllSon", e);
		}
		return sortMenuList;
	}
	
	
	/**
	 * 业务层方法
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> putToMap(MenuVO menu, JqPage pageInfo) {
		Map map = new HashMap();
		if (null != menu) {
			map.put("userName", menu.getMenuName());
			map.put("levalId", menu.getLevelId());
			map.put("typeId", menu.getTypeId());
			map.put("state", menu.getState());
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

	/* 
	 * @Description 查询一个菜单下面所有的子菜单
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.IMenuService#findAllSon(com.chujiaxc.system.model.MenuInfo)
	 */
	@Override
	public MenuVO findAllSon(MenuVO menu) throws LogicException {
		try {
			List<MenuVO> sonList = this.findSon(menu.getMenuId());
			if (CollectionUtils.isNotEmpty(sonList)) {
				for (MenuVO son : sonList) {
					this.findAllSon(son);
				}
			}
			menu.setSon(sonList);
		} catch (Exception e) {
			log.error("********** findAllSon MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAllSon", e);
		}
		return menu;
	}
	
	/*
	 * @description 通过菜单集合找到此菜单集合下所有菜单的所有子菜单信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.system.service.IMenuService#findAllSonByList(java.util.List)
	 */
	@Override
	public List<MenuVO> findAllSonByList(List<MenuVO> menuList) throws LogicException {
		try {
			for (MenuVO menu : menuList) {
				findAllSon(menu);
				/*List<MenuInfo> sonList = this.findSon(menu.getMenuId());
				if (null != sonList && 0 < sonList.size()) {
					for (MenuInfo son : sonList) {
						this.findAllSon(son);
					}
				}
				menu.setSon(sonList);*/
			}
		} catch (Exception e) {
			log.error("********** findAllSonByList MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAllSon", e);
		}
		return menuList;
	}
	
	/* 
	 * @Description:查询所有菜单信息，把下一级菜单信息绑定在上一级菜单下面
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.impl.BaseServiceImpl#findAll()
	 */
	@Override
	public List<MenuVO> findAll() throws LogicException {
		List<MenuVO> firstMenuList = new ArrayList<MenuVO>();
		RoleMenu roleMenu = new RoleMenu();
		try {
			List<MenuVO> menuList = menuVODao.selectAll();
			for (MenuVO menu : menuList) {
				if (menu != null && menu.getParentId() == 0) {
					// 删除菜单之前，先判断此菜单是否已经分配给了角色
					// 分配给角色的菜单，不能被删除，除非先删除此菜单对应的所有角色菜单分配信息
					roleMenu.setMenuId(menu.getMenuId());
					List<RoleMenu> rmListOne = roleMenuDao.selectList(roleMenu);
					menu.setSize(rmListOne.size());
					firstMenuList.add(menu);
					this.orderByMenuList(menu, menuList);
				}
			}
		} catch (Exception e) {
			log.error("********** findAll MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
		return firstMenuList;
	}
	
	/* 
	 * @Desription:按顺序排列一个菜单的子菜单
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#orderByMenuList(com.jinlongshiji.modle.Menu)
	 */
	@Override
	public MenuVO orderByMenuList(MenuVO menu, List<MenuVO> menuList) throws LogicException {
		try {
			if (menuList != null && menuList.size() != 0) {
				List<MenuVO> son = new ArrayList<MenuVO>();
				if (menuList != null && menuList.size() > 0) {
					for (MenuVO m : menuList) {
						if (m != null && m.getParentId() == menu.getMenuId()) {
							m.setSize(menu.getSize());
							this.orderByMenuList(m, menuList);
							son.add(m);
						}
					}
				}
				// 只有子菜单有菜单元素的时候，才放入父菜单当中
				if (son.size() != 0) {
					menu.setSon(son);
				}
			}
		} catch (Exception e) {
			log.error("********** orderByMenuList MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "orderByMenuList", e);
		}
		return menu;
	}
	
	/* 
	 * @Desription:按顺序排列一个菜单的子菜单
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#orderByMenu(com.jinlongshiji.modle.Menu)
	 */
	@Override
	public MenuVO orderByMenu(MenuVO menu) throws LogicException {
		try {
			List<MenuVO> menuList = menuVODao.selectAll();
			return orderByMenuList(menu, menuList);
		} catch (Exception e) {
			log.error("********** orderByMenu MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "orderByMenu", e);
		}
	}
	
	/* 
	 * @Description:查找进入菜单分页页面的菜单和角色菜单列表信息
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#findDistributeMenu(com.jinlongshiji.modle.Role)
	 */
	@Override
	public List<Integer> findDistributeMenu(RoleVO role) throws LogicException {
		List<MenuVO> menuList = null;
		try {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(role.getRoleId());
			menuList = this.findAll();
			List<RoleMenu> rmList = roleMenuDao.selectList(roleMenu);
			List<Integer> menuIds = new ArrayList<Integer>();
			// 迭代菜单列表
			if (CollectionUtils.isNotEmpty(rmList)) {
				menuIds = iteratorMenuIds(menuList, rmList, menuIds);
			}
			return menuIds;
		} catch (Exception e) {
			log.error("********** findDistributeMenu MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findDistributeMenu", e);
		}
	}
	
	/* 
	 * @Description:循环迭代菜单信息，获得给角色分了菜单的ID集合
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#iteratorMenu(java.util.List, java.util.List, java.util.List)
	 */
	@Override
	public List<Integer> iteratorMenuIds(List<MenuVO> menuList, List<RoleMenu> rmList, List<Integer> menuIds) 
			throws LogicException{
		try {
			if (CollectionUtils.isNotEmpty(menuList) && CollectionUtils.isNotEmpty(rmList)) {
				for (MenuVO menu : menuList) {
					// 如果此角色菜单关系里面有此菜单ID，则证明此角色分配了此菜单
					for (RoleMenu rm : rmList) {
						if (menu.getMenuId() == rm.getMenuId()) {
							menuIds.add(menu.getMenuId());
							// 迭代下一级级菜单列表
							List<MenuVO> son = menu.getSon();
							if (CollectionUtils.isNotEmpty(son)) {
								menuIds = this.iteratorMenuIds(son, menuIds);
							}
						}
					}
				}
			}
			return menuIds;
		} catch (Exception e) {
			log.error("********** insert MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "iteratorMenuIds", e);
		}
	}
	
	/* 
	 * @Description:循环迭代菜单信息，获得给角色分了菜单的ID集合
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#iteratorMenu(java.util.List, java.util.List, java.util.List)
	 */
	public List<Integer> iteratorMenuIds(List<MenuVO> menuList, List<Integer> menuIds) 
			throws LogicException{
		try {
			if (CollectionUtils.isNotEmpty(menuList)) {
				for (MenuVO menu : menuList) {
					// 如果此角色菜单关系里面有此菜单ID，则证明此角色分配了此菜单
					menuIds.add(menu.getMenuId());
					// 迭代下一级级菜单列表
					List<MenuVO> son = menu.getSon();
					if (CollectionUtils.isNotEmpty(son)) {
						menuIds = iteratorMenuIds(son, menuIds);
					}
				}
			}
			return menuIds;
		} catch (Exception e) {
			log.error("********** insert MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "iteratorMenuIds", e);
		}
	}
	
	/* 
	 * @Description:分配菜单
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#distributeMenu(com.jinlongshiji.modle.Role, java.util.List)
	 */
	@Override
	public int distributeMenu(RoleInfo role, List<Integer> menuIds) throws LogicException {
		try {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(role.getRoleId());
			// 删除原来的角色菜单关系
			roleMenuDao.delete(roleMenu);
			// 原先分配的角色菜单关系列表
			List<RoleMenu> rmList = new ArrayList<RoleMenu>();
			// 分配菜单
			for (int menuId : menuIds) {
				RoleMenu rm = new RoleMenu();
				rm.setMenuId(menuId);
				rm.setRoleId(role.getRoleId());
				rmList.add(rm);
				// 获得此菜单的子菜单
				MenuVO menu = new MenuVO();
				menu.setMenuId(menuId);
				rmList = iteratorMenuList(menu, role, rmList);
			}
			return roleMenuDao.bathInsert(rmList);
		} catch (Exception e) {
			log.error("********** distributeMenu MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "distributeMenu", e);
		}
	}
	
	/* 
	 * @Description:循环迭代菜单信息，将选择的角色菜单管理信息付给他的子菜单
	 * (non-Javadoc)
	 * @see com.jinlongshiji.service.MenuService#iteratorMenuList(com.jinlongshiji.modle.Menu, com.jinlongshiji.modle.Role, java.util.List)
	 */
	@Override
	public List<RoleMenu> iteratorMenuList(MenuVO menu, RoleInfo role, List<RoleMenu> rmList) throws LogicException {
		try {
			List<MenuVO> sonList = this.findSon(menu.getMenuId());
			if (sonList != null && sonList.size() != 0) {
				for (MenuVO son : sonList) {
					RoleMenu r = new RoleMenu();
					r.setMenuId(son.getMenuId());
					r.setRoleId(role.getRoleId());
					rmList.add(r);
//					rmList = iteratorMenuList(son, role, rmList);
				}
			}
			return rmList;
		} catch (Exception e) {
			log.error("********** iteratorMenuList MenuInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "iteratorMenuList", e);
		}
	}
}