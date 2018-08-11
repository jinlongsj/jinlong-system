package com.jinlong.system.model.po.user;

import java.io.Serializable;

import lombok.Data;

/**
 * @description 用户详细信息实体类
 * @author 肖学进
 */
@Data
public class UserInfo implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 38027796939351640L;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 用户真实姓名
	 */
	private String realName;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 性别
	 */
	private Integer gender;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 身份证号码
	 */
	private String idNumber;
	
	/**
	 * 座机号码
	 */
	private String telephone;
	
	/**
	 * 用户所在地ID
	 */
	private Integer zoneId;
	
	/**
	 * 用户地址
	 */
	private String address;
	
	/**
	 * 用户邮编号码
	 */
	private String postCode;
	
	/**
	 * 用户个人主页网址
	 */
	private String homePage;
	
	/**
	 * 用户QQ
	 */
	private String qqNumber;
	
	/**
	 * 用户淘宝账户
	 */
	private String aliPay;
	
	/**
	 * 用户头像图片文件ID
	 */
	private Integer image;
	
	/**
	 * 用户详情信息描述
	 */
	private String description;
	
	/**
	 * 用户流程状态
	 */
	private Integer state;
	
}
