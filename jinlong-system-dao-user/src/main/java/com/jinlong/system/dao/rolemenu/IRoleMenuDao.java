package com.jinlong.system.dao.rolemenu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.po.role.RoleMenuPO;

/**
 * 角色菜单管理数据持久层接口DAO
 * @author 肖学进
 */
@Mapper
public interface IRoleMenuDao extends IBasicDao<RoleMenuPO> {
	
	/**
	 * 批量插入角色菜单关系信息
	 * @param roleMenu
	 * @return
	 * @throws Exception
	 */
	public abstract int bathInsert(List<RoleMenuPO> rmList) throws Exception;
	
}
