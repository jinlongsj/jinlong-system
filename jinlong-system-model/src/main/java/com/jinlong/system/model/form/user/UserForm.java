package com.jinlong.system.model.form.user;

import java.io.Serializable;

import com.jinlong.system.model.po.user.UserBasePO;
import com.jinlong.system.model.po.user.UserInfoPO;

import lombok.Data;

/**
 * 用户Form类
 * @author asus
 */
@Data
public class UserForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5999570151980628612L;
	
	/**
	 * 用户基础类
	 */
	private UserBasePO userBase;
	
	/**
	 * 用户信息类
	 */
	private UserInfoPO userInfo;

}
