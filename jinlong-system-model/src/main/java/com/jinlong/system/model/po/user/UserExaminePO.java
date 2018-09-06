package com.jinlong.system.model.po.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户审核信息
 * @author 肖学进
 */
@Data
public class UserExaminePO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5094174385261503161L;
	
	/**
	 * 被审核的用户ID
	 */
	private Integer userId;
	
	/**
	 * 审核人的用户ID
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
	 * 用户审核状态
	 */
	private Integer state;

}