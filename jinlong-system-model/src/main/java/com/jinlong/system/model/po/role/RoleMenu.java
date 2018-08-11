package com.jinlong.system.model.po.role;

import java.io.Serializable;

import lombok.Data;

/**
 * @description 角色菜单关系实体类
 * @author 肖学进
 */
@Data
public class RoleMenu implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6422243439890218472L;
	
	/**
	 * 角色菜单ID
	 */
	private Integer roleMenuId;
	
	/**
	 * 角色ID
	 */
	private Integer roleId;
	
	/**
	 * 菜单ID
	 */
	private Integer menuId;
	
}
