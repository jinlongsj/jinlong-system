package com.jinlong.system.model.po.usergroup;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户流程信息
 * @author 肖学进
 */
@Data
public class UserGroupProcessPO implements Serializable {

	/**
	 * serialVersionUIDs
	 */
	private static final long serialVersionUID = 7292282622631336712L;
	
	/**
	 * 用户组信息流程ID
	 */
	private Integer processId;
	
	/**
	 * 用户组信息ID
	 */
	private Integer userGroupId;
	
	/**
	 * 流程节点时间
	 */
	private Date processTime;
	
	/**
	 * 审核信息ID
	 */
	private Integer examineId;
	
	/**
	 * 用户状态
	 */
	private Integer state;

}
