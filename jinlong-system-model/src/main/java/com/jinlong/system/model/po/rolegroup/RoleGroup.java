package com.jinlong.system.model.po.rolegroup;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * 角色组POJO实体类
 * @author Administrator
 */
@Data
public class RoleGroup implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2129573018234960661L;

	/**
	 * 角色组ID
	 */
	private int roleGroupId;
	
	/**
	 * 角色组名称
	 */
	private String roleGroupName;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 角色组详情
	 */
	private String roleGroupInfo;
	
}
