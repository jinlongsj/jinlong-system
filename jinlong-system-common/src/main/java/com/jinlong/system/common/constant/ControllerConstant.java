package com.jinlong.system.common.constant;

/**
 * @description：控制层错误码常量类
 * @author Administrator
 */
public class ControllerConstant {
	
	/**
	 * 系统端后台控制器常量
	 */
	public static final String MAIN_SHOW_MSG = "右侧菜单查询";
	
	/**
	 * 公共字典信息控制层常量
	 */
	// 查询所有的用户状态字典信息
	public static final String COMMON_USER_STATE = "用户状态信息";
	// 查询所有的用户流程状态字典信息
	public static final String COMMON_USER_PROCCESS_STATE = "用户流程状态信息";
	// 查询所有的角色类别字典信息
	public static final String COMMON_ROLE_TYPE = "角色类型信息";
	// 查询所有的角色状态字典信息
	public static final String COMMON_ROLE_STATE = "角色状态信息";
	// 查询所有的菜单类别字典信息
	public static final String COMMON_MENU_TYPE = "菜单类型信息";
	// 查询所有的菜单状态字典信息
	public static final String COMMON_MENU_STATE = "菜单状态信息";
	
	/**
	 * 文件信息控制层常量
	 */
	// 文件上传
	public static final String FILE_UPLOAD_FILE = "文件上传";
	// 上传用户图片文件
	public static final String FILE_UPLOAD_USER_PICTURE_FILE = "上传用户图片文件";
	// 通过文件ID查询展示文件信息
	public static final String FILE_SHOW = "通过文件ID查询展示文件信息";
	// 查询用户最新上传的一张图片文件信息
	public static final String FILE_SHOW_NEW_USER_PICTURE_BY_ID = "查询用户最新上传的一张图片文件信息";
	
	/**
	 * 地区信息控制层常亮
	 */
	// 查询省、自治区、直辖市列表信息
	public static final String ZONE_SHOW_MSG = "省、自治区、直辖市列表信息查询";
	// 通过本级地区ID查询下一级地区集合
	public static final String ZONE_SHOW_BY_PARENT_ID_MSG = "通过本级地区ID查询下一级地区集合";
	// 通过当前的的地区ID，查询他的父ID信息
	public static final String ZONE_SHOW_PARENT_ID_BY_ZONE_MSG = "上一级地区的ID信息查询";
	
	/**
	 * 用户信息控制器常量
	 */
	// 用户信息管理列表页面
	public static final String USER_MANAGE_MSG = "用户流程信息管理分页列表查询";
	// 查询角色列表信息
	public static final String USER_SHOW_LIST_MSG = "角色列表信息查询";
	// 添加用户信息时，验证用户名称是否存在
	public static final String USER_CHECK_ADD_MEG = "用户添加页面：用户名称验证";
	// 添加用户信息时，验证用户手机号码是否存在
	public static final String USER_CHECK_ADD_MOBILE_PHONE_MEG = "用户添加页面：手机号码验证";
	// 添加用户信息时，验证用户Email是否存在
	public static final String USER_CHECK_ADD_EMAIL_MEG = "用户添加页面：Email验证";
	// 添加用户信息
	public static final String USER_ADD_MSG = "用户信息添加";
	// 进入修改页面
	public static final String USER_SHOW_MSG = "进入用户修改页面：用户信息查询";
	// 修改用户信息时，验证用户名是否存在
	public static final String USER_CHECK_UPDATE_MEG = "用户修改页面：用户名称验证";
	// 修改用户信息时，验证用户手机号码是否存在
	public static final String USER_CHECK_UPDATE_MOBILE_PHONE_MEG = "用户修改页面：手机号码验证";
	// 修改用户信息时，验证用户Email是否存在
	public static final String USER_CHECK_UPDATE_EMAIL_MEG = "用户修改页面：Email验证";
	// 修改用户信息
	public static final String USER_UPDATE_MSG = "用户信息修改";
	// 用户重置密码
	public static final String USER_UPDATE_PWD_MSG = "用户密码修改";
	// 审核用户信息
	public static final String USER_EXAMINE_MSG = "用户信息审核";
	// 删除用户信息
	public static final String USER_DELETE_MSG = "用户信息删除";
	// 批量删除用户信息
	public static final String USER_BATH_DELETE_MSG = "用户信息批量删除";
	// 用户流程信息管理列表页面
	public static final String USER_PROCESS_MANAGE_MSG = "用户流程信息管理分页列表查询";
	
	/**
	 * 角色信息控制器常量
	 */
	// 角色信息管理列表页面
	public static final String ROLE_MANAGE_MSG = "角色信息管理分页列表：角色分页列表查询";
	// 添加角色信息
	public static final String ROLE_ADD_MSG = "角色信息添加";
	// 添加角色信息时，验证角色名称是否存在
	public static final String ROLE_CHECK_ADD_MEG = "角色添加页面：角色名称验证";
	// 进入修改角色页面，查询角色信息
	public static final String ROLE_SHOW_MSG = "角色信息查询";
	// 修改角色信息
	public static final String ROLE_UPDATE_MSG = "角色信息修改";
	// 修改角色信息时，验证角色名称是否存在
	public static final String ROLE_CHECK_UPDATE_MEG = "角色修改页面：角色名称验证";
	// 删除角色信息
	public static final String ROLE_DELETE_MSG = "角色信息删除";
	// 角色与菜单分配
	public static final String ROLE_MENU_TO_DISTRIBUTE = "通过角色ID查询此角色下面的菜单列表信息";
	// 角色与菜单分配
	public static final String ROLE_MENU_DISTRIBUTE = "角色与菜单分配";
	// 审核角色信息
	public static final String ROLE_EXAMINE_MSG = "角色信息审核";
	
	/**
	 * 菜单信息控制器常量
	 */
	// 菜单信息管理列表页面
	public static final String MENU_MANAGE_MSG = "菜单信息管理分页列表：菜单分页列表查询";
	// 查询菜单列表信息
	public static final String MENU_SHOW_LIST_MSG = "角色列表信息查询";
	// 添加菜单信息
	public static final String MENU_ADD_MSG = "角色信息添加";
	// 添加菜单信息时，验证菜单名称是否存在
	public static final String MENU_CHECK_ADD_MEG = "角色添加页面：角色名称验证";
	// 修改角色信息
	public static final String MENU_UPDATE_MSG = "角色信息修改";
	// 修改菜单信息时，验证菜单名称是否存在
	public static final String MENU_CHECK_UPDATE_MEG = "角色修改页面：角色名称验证";
	// 删除菜单信息
	public static final String MENU_DELETE_MSG = "角色信息删除";
	// 审核菜单信息
	public static final String MENU_EXAMINE = "菜单信息审核";
	
}