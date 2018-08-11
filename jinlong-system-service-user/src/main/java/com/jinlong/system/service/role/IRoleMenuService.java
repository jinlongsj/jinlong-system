package com.jinlong.system.service.role;

import java.util.List;

import com.jinlong.system.model.po.role.RoleMenu;
import com.jinlong.system.model.vo.role.RoleMenuVO;
import com.jinlong.system.service.IBaseVOService;

/**
 * 角色菜单管理业务服务层Service接口
 * @author 肖学进
 */
public interface IRoleMenuService extends IBaseVOService<RoleMenu, RoleMenuVO> {
	
	/**
	 * @Description:批量插入角色菜单关系信息
	 * @param roleMenu
	 * @return
	 * @throws Exception
	 */
	public int bathAdd(List<RoleMenu> rmList) throws Exception;
	
}
