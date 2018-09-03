/**
 * FileName: 	 RoleProcess.java
 * @Description: 角色流程信息实体类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月5日 下午3:04:55 
 **/

package com.jinlong.system.model.po.role;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 角色流程信息实体类
 * @author:	肖学进
 * @date: 2018年6月5日 下午3:05:11
 */
@Data
public class RoleProcessPO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8527662055225008834L;
	
	/**
	 * 角色流程ID
	 */
	private Integer processId;
	
	/**
	 * 角色ID
	 */
	private Integer roleId;
	
	/**
	 * 流程节点时间
	 */
	private Date processTime;
	
	/**
	 * 审核信息ID
	 */
	private Integer examineId;
	
	/**
	 * 角色状态
	 */
	private Integer state;

}
