package com.jinlong.system.model.po.menu;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 菜单审核记录信息
 * @author 肖学进
 */
@Data
public class MenuExamineRecordPO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5094174385261503161L;
	
	/**
	 * 审核记录信息ID
	 */
	private Integer examineId;
	
	/**
	 * 审核的菜单ID
	 */
	private Integer menuId;
	
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
	 * 菜单审核状态
	 */
	private Integer state;

}