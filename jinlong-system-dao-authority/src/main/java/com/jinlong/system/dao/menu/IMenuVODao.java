/**
 * FileName: 	 IMenuVODao.java
 * @Description: 菜单VO视图DAO接口
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月2日 上午11:47:08 
 **/
package com.jinlong.system.dao.menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.vo.menu.MenuVO;

/**
 * 菜单VO视图DAO接口
 * @author:	肖学进
 * @date: 2018年7月2日 上午11:47:08
 */
@Mapper
public interface IMenuVODao extends IBasicDao<MenuVO> {
	
	/**
	 * @Description:查询所有的一级菜单
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> selectAllParent() throws Exception;
	
	/**
	 * @Description:通过一级菜单查询它下面的所有二级菜单，并且按顺序排列
	 * @param menuId
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> selectSon(@Param("menuId") int menuId) throws Exception;
	
	/**
	 * @Description:通过userId查询此用户下所有菜单
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> selectListByUser(@Param("userId") int userId) throws Exception;

}
