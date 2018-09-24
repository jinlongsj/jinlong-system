/**
 * FileName: 	 MenuProcessVO.java
 * @Description: 菜单流程信息VO视图类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年9月6日 上午11:06:44 
 **/

package com.jinlong.system.model.vo.menu;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 菜单流程信息VO视图类
 * @author:	肖学进
 * @date: 2018年9月6日 上午11:06:44
 */
@Data
public class MenuProcessVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5733521601766586016L;
	
	/**
	 * 用户流程ID
	 */
	private Integer processId;
	
	/**
	 * 用户ID
	 */
	private Integer menuId;
	
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
	 * 菜单信息
	 */
	/**
	 * 菜单名称
	 */
	private String menuName;
	
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
