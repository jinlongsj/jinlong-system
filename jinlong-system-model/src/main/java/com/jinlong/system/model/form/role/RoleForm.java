package com.jinlong.system.model.form.role;

import java.io.Serializable;

import com.jinlong.system.model.po.role.RoleInfo;

import lombok.Data;

/**
 * 角色Form类
 * @author asus
 */
@Data
public class RoleForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -76494798446008564L;
	
	/**
	 * 角色信息
	 */
	private RoleInfo role;
	
	/**
	 * 角色菜单细关系细信息
	 */
	private Integer[] menuIds;

}
