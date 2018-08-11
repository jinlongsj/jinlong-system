package com.jinlong.system.dao.rolemenu;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.vo.role.RoleMenuVO;

/**
 * 角色菜单VO数据持久层接口DAO
 * @author 肖学进
 */
@Mapper
public interface IRoleMenuVODao extends IBasicDao<RoleMenuVO> {
	
}
