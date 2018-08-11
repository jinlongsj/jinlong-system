package com.jinlong.system.model.vo.role;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 角色VO
 * @author 肖学进
 */
@Data
public class RoleVO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5905811916521416231L;
	
	/**
	 * 角色实体类信息
	 */
	
	/**
	 * 角色ID
	 */
	private Integer roleId;
	
	/**
	 * 角色类型
	 */
	private Integer typeId;
	
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
	
	/**
	 * 角色状态信息
	 */
	
	/**
	 * 角色类型名称
	 */
	private String typeName;
	
	/**
	 * 角色状态名称
	 */
	private String stateName;
	
	/**
	 * 角色流程状态名称
	 */
	private String processStateName;
	
	/**
	 * 角色下面的菜单集合
	 */
	private List<Integer> menuIds;

}
