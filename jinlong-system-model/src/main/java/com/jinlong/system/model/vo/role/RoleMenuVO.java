package com.jinlong.system.model.vo.role;

import java.io.Serializable;

import lombok.Data;

/**
 * @description 角色菜单关系实体类
 * @author 肖学进
 */
@Data
public class RoleMenuVO implements Serializable {
	
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
	
	/**
	 * 扩展字段
	 */
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色详情描述
	 */
	private String description;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 所属父菜单的ID
	 */
	private String parentId;
	
	/**
	 * 菜单地址
	 */
	private String menuUrl;
	
	/**
	 * 菜单图片
	 */
	private String image;
	
}
