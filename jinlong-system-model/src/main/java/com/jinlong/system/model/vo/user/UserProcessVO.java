/**
 * FileName: 	 UserProcessVO.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By ZTE-ITS
 * Copyright:	Copyright(C) 2010-2011
 * Company   	ZTE-ITS WuXi LTD.
 * @author:		肖学进
 * @version		V1.0 
 * Createdate: 	2017年11月11日 上午10:06:14 
 **/

package com.jinlong.system.model.vo.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户流程信息VOss
 * @author 肖学进
 */
@Data
public class UserProcessVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1359433121060896312L;
	
	/**
	 * 用户流程ID
	 */
	private Integer processId;
	
	/**
	 * 被审核用户ID
	 */
	private Integer userId;
	
	/**
	 * 被审核用户名称
	 */
	private String userName;
	
	/**
	 * 流程节点时间
	 */
	private Date processTime;
	
	/**
	 * 审核记录信息ID
	 */
	private Integer examineId;
	
	/**
	 * 用户流程状态
	 */
	private Integer state;
	
	/**
	 * 审核人ID	
	 */
	private Integer examineUserId;
	
	/**
	 * 审核人名称
	 */
	private String examineUserName;
	
	/**
	 * 是否通过审核
	 */
	private Integer pass;
	
	/**
	 * 是否通过审核的名称
	 */
	private String passName;
	
	/**
	 * 审核详情意见
	 */
	private String description;
	
	/**
	 * 用户流程状态名称
	 */
	private String stateName;
	
	/**
	 * 查询条件：查询的流程节点时间的开始时间
	 */
	private Date startTime;
	
	/**
	 * 查询条件：查询的流程节点时间的结束时间
	 */
	private Date endTime;
	
}
