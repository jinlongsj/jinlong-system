package com.jinlong.system.service.role;

import java.util.List;

import com.jinlong.common.service.IBaseVOService;
import com.jinlong.system.model.po.role.RoleMenuPO;
import com.jinlong.system.model.vo.role.RoleMenuVO;

/**
 * 角色菜单管理业务服务层Service接口
 * @author 肖学进
 */
public interface IRoleMenuService extends IBaseVOService<RoleMenuPO, RoleMenuVO> {
	
	/**
	 * @Description:批量插入角色菜单关系信息
	 * @param roleMenu
	 * @return
	 * @throws Exception
	 */
	public int bathAdd(List<RoleMenuPO> rmList) throws Exception;
	
}
