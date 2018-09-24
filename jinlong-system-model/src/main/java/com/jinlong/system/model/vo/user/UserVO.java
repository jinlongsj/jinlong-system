package com.jinlong.system.model.vo.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户信息VO
 * @author 肖学进
 */
@Data
public class UserVO implements Serializable {
	
  	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7217093652150412747L;
	
	/**
	 * 用户基础信息属性
	 */
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 角色ID
	 */
	private Integer roleId;
	
	/**
	 * 所属角色用户的扩展表ID
	 */
	private Integer affiliatedId;
	
	/**
	 * 用户注册时间
	 */
	private Date registerTime;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 用户手机号码
	 */
	private String mobilePhone;
	
	/**
	 * 用户电子邮箱
	 */
	private String email;
	
	/**
	 * 用户状态
	 */
	private Integer state;
	
	/**
	 * 用户主信息属性
	 */
	
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
	private String gender;
	
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
	 * 用户头像图片ID
	 */
	private Integer image;
	
	/**
	 * 用户详情信息描述
	 */
	private String description;
	
	/**
	 * 用户流程状态
	 */
	private Integer processState;
	
	/**
	 * 用户图片用户图片ID信息
	 */
	
	/**
	 * 用户图片ID
	 */
	private Integer fileId;
	
	/**
	 * 用户图片ID类别ID
	 */
	private Integer categoryId;
	
	/**
	 * 用户图片ID上传之前的名字
	 */
	private String initName;
	
	/**
	 * 用户图片ID上传之后的名字
	 */
	private String fileName;
	
	/**
	 * 用户图片ID上传到的路径
	 */
	private String filePath;
	
	/**
	 * 用户图片ID上传提交时间
	 */
	private Date submitTime;
	
	/**
	 * 用户图片描述
	 */
	private String imageDescription;
	
	/**
	 * 业务需求属性
	 */
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 用户状态名称
	 */
	private String stateName;
	
	/**
	 * 性别名称
	 */
	private String genderName;
	
	/**
	 * 省、自治区、直辖市级地区名称ID
	 */
	private Integer provinceId;
	
	/**
	 * 省、自治区、直辖市级地区名称
	 */
	private String province;
	
	/**
	 * 市级地区名称ID
	 */
	private Integer cityId;
	
	/**
	 * 市级地区名称
	 */
	private String city;
	
	/**
	 * 县级地区名称
	 */
	private String region;
	
	/**
	 * 用户流程状态名称
	 */
	private String processStateName;
}