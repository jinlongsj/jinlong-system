package com.jinlong.system.service.menu;

import java.util.List;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.page.PageList;
import com.jinlong.common.page.PageProperty;
import com.jinlong.common.service.IBaseVOService;
import com.jinlong.system.model.po.menu.MenuInfoPO;
import com.jinlong.system.model.po.role.RoleMenuPO;
import com.jinlong.system.model.po.role.RoleInfoPO;
import com.jinlong.system.model.vo.menu.MenuVO;
import com.jinlong.system.model.vo.role.RoleVO;

/**
 * 菜单信息服务层Service接口
 * @author 肖学进
 */
public interface IMenuService extends IBaseVOService<MenuInfoPO, MenuVO> {
	
	/*
	 * 不操作事务，查询 操作的方法
	 */
	
	/**
	 * @Description:查询所有的一级菜单
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> findAllParent() throws LogicException;
	
	/**
	 * @Description:通过userId查询此用户下所有菜单
	 * @param userId
	 * @return
	 * @throws LogicException
	 */
	public List<MenuVO> findListByUser(int userId) throws LogicException;
	
	/**
	 * @Description 查询一个菜单下面所有的子菜单
	 * @param menu
	 * @return
	 * @throws LogicException
	 */
	public MenuVO findAllSon(MenuVO menu) throws LogicException;

	/**
	 * @description：查询所有的菜单信息，然后把它们组装成JSON对象
	 * @return
	 * @throws LogicException
	 */
	public List<MenuVO> findAllMenu() throws LogicException;
	
	
	
	/*
	 * 分页 
	 */
	
	/**
	 * Description:菜单信息列表树总分页方法 
	 * @param pp
	 * @return
	 * @throws LogicException
	 */
	public PageList<MenuVO> findPage(PageProperty pp) throws LogicException;
	
	
	
	/*
	 * 业务层方法
	 */
	
	/**
	 * @Description:查询此菜单下面的所有二级菜单，并且按顺序排列
	 * @param menuId
	 * @return
	 * @throws LogicException
	 */
	public List<MenuVO> findSon(int menuId) throws LogicException;
	
	/**
	 * @Description:通过菜单集合找到此菜单集合下所有菜单的所有子菜单信息
	 * @param menuList
	 * @return
	 * @throws LogicException
	 */
	public List<MenuVO> findAllSonByList(List<MenuVO> menuList) throws LogicException;
	
	/**
	 * @Desription:按顺序排列一个菜单的子菜单
	 * @param menu
	 * @param menuList
	 * @return
	 * @throws Exception
	 */
	public MenuVO orderByMenuList(MenuVO menu, List<MenuVO> menuList) throws LogicException;
	
	/**
	 * @Desription:按顺序排列一个菜单的子菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	public MenuVO orderByMenu(MenuVO menu) throws LogicException;
	
	/**
	 * @Description:查找进入菜单分页页面的菜单和角色菜单列表信息
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public List<Integer> findDistributeMenu(RoleVO role) throws LogicException;
	
	/**
	 * @Description:循环迭代菜单信息，获得给角色分了菜单的ID集合
	 * @param menuList
	 * @param rmList
	 * @param menuIds
	 * @return
	 */
	public List<Integer> iteratorMenuIds(List<MenuVO> menuList, List<RoleMenuPO> rmList, List<Integer> menuIds) throws LogicException; 
	
	/**
	 * @Description:分配菜单
	 * @param role
	 * @param menuIds
	 * @return
	 * @throws Exception
	 */
	public int distributeMenu(RoleInfoPO role, List<Integer> menuIds) throws LogicException;
	
	/**
	 * @Description:循环迭代菜单信息，将选择的角色菜单管理信息付给他的子菜单
	 * @param menuList
	 * @param rmList
	 * @param menuIds
	 * @return
	 */
	public List<RoleMenuPO> iteratorMenuList(MenuVO menu, RoleInfoPO role, List<RoleMenuPO> rmList) throws LogicException; 

}
