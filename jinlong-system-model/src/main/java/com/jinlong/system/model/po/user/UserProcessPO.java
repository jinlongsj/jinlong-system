package com.jinlong.system.model.po.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户流程信息
 * @author 肖学进
 */
@Data
public class UserProcessPO implements Serializable {

	/**
	 * serialVersionUIDs
	 */
	private static final long serialVersionUID = 7292282622631336712L;
	
	/**
	 * 用户流程ID
	 */
	private Integer processId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
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
