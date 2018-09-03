/**
 * FileName: 	 RoleExamineRecord.java
 * @Description: 角色审核记录信息实体类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月5日 下午3:00:29 
 **/

package com.jinlong.system.model.po.role;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 角色审核记录信息实体类
 * @author:	肖学进
 * @date: 2018年6月5日 下午3:01:07
 */
@Data
public class RoleExamineRecordPO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -629980350841791370L;
	
	/**
	 * 审核记录信息ID
	 */
	private Integer examineId;
	
	/**
	 * 审核的角色ID
	 */
	private Integer roleId;
	
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
	 * 审核详情意见
	 */
	private String description;
	
	/**
	 * 角色审核状态
	 */
	private Integer state;

}
