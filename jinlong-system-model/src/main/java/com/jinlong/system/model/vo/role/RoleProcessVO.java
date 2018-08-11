/**
 * FileName: 	 RoleProcessVO.java
 * @Description: 角色流程信息VO视图类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月5日 下午3:08:16 
 **/

package com.jinlong.system.model.vo.role;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 角色流程信息VO视图类
 * @author:	肖学进
 * @date: 2018年6月5日 下午3:08:33
 */
@Data
public class RoleProcessVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4433875051171032329L;
	
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
	
	/**
	 * 审核信息
	 */
	/**
	 * 审核人ID
	 */
	private Integer examineUserId;
	
	/**
	 * 审核时间
	 */
	private Date examineTime;
	
	/**
	 * 是否通过审核
	 */
	private Integer pass;
	
	/**
	 * 审核详情
	 */
	private String description;
	
	/**
	 * 角色信息
	 */
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 审核人信息
	 */
	/**
	 * 审核人用户名称
	 */
	private String examineUserName;

	/**
	 * 是否通过审核名称
	 */
	private String passName;
	
	/**
	 * 流程信息
	 */
	/**
	 * 流程状态名称
	 */
	private String stateName;

	/**
	 * 查询条件
	 */
	/**
	 * 审核时间的开始时间
	 */
	private Date startTime;
	
	/**
	 * 审核时间的结束时间
	 */
	private Date endTime;

}
