package com.jinlong.system.service.role;


import java.util.List;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.model.po.page.JqPage;
import com.jinlong.common.service.IBaseVOService;
import com.jinlong.system.model.po.role.RoleInfoPO;
import com.jinlong.system.model.vo.role.RoleVO;

/**
 * 角色信息Service业务层接口
 * @author 肖学进
 */
public interface IRoleService extends IBaseVOService<RoleInfoPO, RoleVO> {
	
	/*
	 * 操作事物，曾、删、改、查的接口
	 */
	/**
     * 新增一条角色信息，并分配菜单
     * @author Administrator
     * @param role 角色信息
	 * @param menuIds
     * @return 所影响的行数
     * @throws LogicException
     */
    public int add(RoleInfoPO role, List<Integer> menuIds) throws LogicException;
    
    /**
     * 通过条件删除一批角色信息，并删除下面所分配的菜单
     * @author Administrator
     * @param role 角色信息
     * @return 所影响的行数
     * @throws LogicException
     */
    public int delete(RoleInfoPO role) throws LogicException;
    
    /**
     * 通过驾校角色ID删除一条角色信息，并删除下面所分配的菜单
     * @author Administrator
     * @param roleId 角色ID
     * @return 所影响的行数
     * @throws LogicException
     */
    public int deleteById(int roleId) throws LogicException;
    
    /**
     * 通过角色ID修改一条角色信息，并分配菜单
     * @author Administrator
     * @param role 角色信息
	 * @param menuIds
     * @return 所影响的行数
     * @throws LogicException
     */
    public int update(RoleInfoPO role, List<Integer> menuIds) throws LogicException;
    
	/**
	 * JQgrid分页查询
	 * @param role
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	public List<RoleVO> findJqPageList(RoleVO role, JqPage pageInfo) throws LogicException;

}
