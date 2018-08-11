package com.jinlong.system.model.po.role;

import java.io.Serializable;

import lombok.Data;

/**
 * 角色实体类
 * @author 肖学进
 */
@Data
public class RoleInfo implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3447038556990729680L;

	/**
	 * 角色ID
	 */
	private Integer roleId;
	
	/**
	 * 角色类型
	 */
	private String typeId;
	
	/**
	 * 角色编码
	 */
	private String roleCode;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色详情
	 */
	private String description;
	
	/**
	 * 角色状态
	 */
	private Integer state;
	
	/**
	 * 流程状态
	 */
	private Integer processState;
	
}