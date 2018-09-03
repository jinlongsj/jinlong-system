/**
 * FileName: 	 UserProcessVOForm.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年5月31日 下午4:20:08 
 **/

package com.jinlong.system.model.form.user;

import java.io.Serializable;

import com.jinlong.common.model.po.page.JqPage;
import com.jinlong.system.model.vo.user.UserProcessVO;

import lombok.Data;

/**
 * 用户流程Form类
 * @author:	肖学进
 * @date: 2018年5月31日 下午4:28:36
 */
@Data
public class UserProcessVOForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6328486241580328109L;
	
	/**
	 * 用户流程VO
	 */
	private UserProcessVO userProcessVO;
	
	/**
	 * 分页配置
	 */
	private JqPage pageInfo;

}
