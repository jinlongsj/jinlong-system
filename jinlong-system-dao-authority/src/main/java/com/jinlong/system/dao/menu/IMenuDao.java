package com.jinlong.system.dao.menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.menu.MenuInfo;

/**
 * 菜单数据持久层接口DAO
 * @author 肖学进
 */
@Mapper
public interface IMenuDao extends IBasicDao<MenuInfo> {
	
	/**
	 * @Description:查询所有的一级菜单
	 * @return
	 * @throws Exception
	 */
	public List<MenuInfo> selectAllParent() throws Exception;
	
	/**
	 * @Description:通过一级菜单查询它下面的所有二级菜单，并且按顺序排列
	 * @param menuId
	 * @return
	 * @throws Exception
	 */
	public List<MenuInfo> selectSon(@Param("menuId") int menuId) throws Exception;
	
	/**
	 * @Description:通过userId查询此用户下所有菜单
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<MenuInfo> selectListByUser(@Param("userId") int userId) throws Exception;
	
}