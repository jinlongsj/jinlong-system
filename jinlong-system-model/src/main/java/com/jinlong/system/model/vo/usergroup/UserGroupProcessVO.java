/**
 * FileName: 	 UserGroupProcessVO.java
 * @Description: 用户组流程信息VO视图类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年9月14日 下午2:58:35 
 **/

package com.jinlong.system.model.vo.usergroup;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户组流程信息VO视图类
 * @author:	肖学进
 * @date: 2018年9月14日 下午2:58:35
 */
@Data
public class UserGroupProcessVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8010699532984494820L;
	
	/**
	 * 用户组流程信息
	 */
	
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
