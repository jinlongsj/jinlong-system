package com.jinlong.system.web.controller.user;

import java.net.URLDecoder;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinlong.system.common.constant.ControllerConstant;
import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.model.dto.ResultDTO;
import com.jinlong.system.model.form.user.UserForm;
import com.jinlong.system.model.form.user.UserVOForm;
import com.jinlong.system.model.po.user.UserBase;
import com.jinlong.system.model.po.user.UserExamine;
import com.jinlong.system.model.vo.role.RoleVO;
import com.jinlong.system.model.vo.user.UserVO;
import com.jinlong.system.service.role.IRoleService;
import com.jinlong.system.service.user.IUserBaseService;
import com.jinlong.system.service.user.IUserExamineService;
import com.jinlong.system.service.user.IUserService;

/**
 * @description：用户信息控制器
 * @author 肖学进
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(UserController.class);
	
	/**
	 * Spring注入的Service层接口
	 */
	// 用户基础信息服务层接口
	@Autowired
	private IUserBaseService userBaseService;
	
	// 用户VO服务层接口
	@Autowired
	private IUserService userService;
	
	// 用户审核信息服务层接口
	@Autowired
	private IUserExamineService userExamineService;
	
	// 角色VO服务接口
	@Autowired
	private IRoleService roleService;
	
	/**
	 * @description：用户信息管理列表页面
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/manage", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResultDTO manage(@RequestBody UserVOForm user) {
		log.info("User manage start! Parameter userVOForm = " + user);
		ResultDTO result = new ResultDTO();
		try {
			if (null != user) {
				List<UserVO> userList = userService.findJqPageList(user.getUser(), user.getPageInfo());
				if (CollectionUtils.isNotEmpty(userList)) {
					result.setSuccess(ControllerConstant.USER_MANAGE_MSG, userList, user.getPageInfo());
				} else if (0 == userList.size()) {
					result.setResultNull(ControllerConstant.USER_MANAGE_MSG, userList, user.getPageInfo());
				} else {
					result.setError(ControllerConstant.USER_MANAGE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_MANAGE_MSG);
			}
		} catch (LogicException e) {
			log.error("User manage failed! Exception = " + e);
			result.setException(ControllerConstant.USER_MANAGE_MSG, e.getMessage());
			return result;
		}
		log.info("User manage end!");
		return result;
	}
	
	/**
	 * @description：进入添加用户的页面
	 * @return
	 */
	@RequestMapping(value = "/showRoleList", method = RequestMethod.POST)
	public ResultDTO showRoleList() {
		log.info("User showRoleList start!");
		ResultDTO result = new ResultDTO();
		try {
			List<RoleVO> roleList = roleService.findAll();
			if (null != roleList && 0 < roleList.size()) {
				// 显示对于添加的用户角色信息
				result.setSuccess(ControllerConstant.USER_SHOW_LIST_MSG, roleList);
			} else if (0 == roleList.size()) {
				// 显示对于添加的用户角色信息
				result.setResultNull(ControllerConstant.USER_SHOW_LIST_MSG, roleList);
			} else {
				result.setError(ControllerConstant.USER_SHOW_LIST_MSG);
			}
		} catch (LogicException e) {
			log.error("User showRoleList failed! Exception = ");
			result.setException(ControllerConstant.USER_SHOW_LIST_MSG, e.getMessage());
			return result;
		}
		log.info("User showRoleList end!");
		return result;
	}
	
	/**
	 * @description：添加用户信息时，验证用户名称是否存在
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/checkAdd", method = RequestMethod.POST)
	public boolean checkAdd(@RequestParam(value = "userName") String userName) {
		log.info("User checkAdd start! Parameter userName = " + userName);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(userName)) {
				UserBase user = new UserBase();
				user.setUserName(userName.trim());
				List<UserBase> userList = userBaseService.findList(user);
				if (null != userList) {
					if (0 < userList.size()) {
						flag = false;
					}
				}
			}
		} catch (LogicException e) {
			log.error("User checkAdd failed! Exception = " + e);
			e.printStackTrace();
			return false;
		}
		log.info("User checkAdd end!");
		return flag;
	}
	
	/**
	 * @description 添加用户信息时，验证用户手机是否存在
	 * @param mobilePhone
	 * @return
	 */
	@RequestMapping(value = "/checkAddMobilePhone", method = RequestMethod.POST)
	public boolean checkAddMobilePhone(@RequestParam(value = "mobilePhone") String mobilePhone) {
		log.info("User checkAddMobilePhone start! Parameter mobilePhone = " + mobilePhone);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(mobilePhone)) {
				UserBase user = new UserBase();
				user.setMobilePhone(mobilePhone.trim());
				if (0 < userBaseService.findList(user).size()) {
					flag = false;
				}
			}
		} catch (LogicException e) {
			log.error("User checkAddMobilePhone failed! Exception = " + e);
			e.printStackTrace();
			return true;
		}
		log.info("User checkAddMobilePhone end!");
		return flag;
	}
	
	/**
	 * @description 添加用户信息时，验证用户输入Email是否正确
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/checkAddEmail", method = RequestMethod.POST)
	public boolean checkAddEmail(@RequestParam(value = "email") String email) {
		log.info("User checkAddEmail start! Parameter email = " + email);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(email)) {
				UserBase user = new UserBase();
				// 强制转码成utf-8，防止@被转码成%40的问题
				user.setEmail(URLDecoder.decode(email.trim(), "utf-8"));
				if (0 < userBaseService.findList(user).size()) {
					flag = false;
				}
			}
		} catch (Exception e) {
			log.error("User checkAddEmail failed! Exception = " + e);
			e.printStackTrace();
			return true;
		}
		log.info("User checkAddEmail end!");
		return flag;
	}
	
	/**
	 * @description：添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultDTO add(@RequestBody UserForm user) {
		log.info("User add start! Parameter userForm = " + user);
		ResultDTO result = new ResultDTO();
		try {
			if (null != user && null != user.getUserBase()
					&& null != user.getUserInfo()) {
				if (3 == userService.add(user.getUserBase(), user.getUserInfo())) {
					result.setSuccess(ControllerConstant.USER_ADD_MSG);
				} else {
					result.setError(ControllerConstant.USER_ADD_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_ADD_MSG);
			}
		} catch (LogicException e) {
			log.error("User add failed! Exception = " + e);
			result.setException(ControllerConstant.USER_ADD_MSG + e);
			return result;
		}
		log.info("User add end!");
		return result;
	}
	
	/**
	 * @description：进入修改页面
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ResultDTO show(@RequestBody Integer userId) {
		log.info("User show start! Parameter userId = " + userId);
		ResultDTO result = new ResultDTO();
		try {
			if (null != userId && 0 < userId) {
				UserVO user = userService.find(userId);
				if (null != user) {
					// 用户信息查询成功
					result.setSuccess(ControllerConstant.USER_SHOW_MSG, user);
				} else {
					// 查询失败
					result.setError(ControllerConstant.USER_SHOW_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_SHOW_MSG);
			}
		} catch (LogicException e) {
			log.error("User show failed! Exception = " + e);
			result.setException(ControllerConstant.USER_SHOW_MSG, e.getMessage());
			return result;
		}
		log.info("User show end!");
		return result;
	}
	
	/**
	 * @description：修改用户信息时，验证用户名是否存在
	 * @param userId
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/checkUpdate", method = RequestMethod.POST)
	public boolean checkUpdate(
			@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "userName") String userName) {
		log.info("User checkUpdate start! Parameter userId = " + userId + " userName = " + userName);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(userName) && 0 != userId) {
				UserBase u = new UserBase();
				u.setUserName(userName.trim());
				List<UserBase> uList = userBaseService.findList(u);
				if (CollectionUtils.isNotEmpty(uList)) {
					u = uList.get(0);
					if (null != u && u.getUserId() != userId) {
						flag = false;
					}
				}
			}
		} catch (LogicException e) {
			log.error("User manage failed! Exception = " + e);
			e.printStackTrace();
			return true;
		}
		log.info("User checkUpdate end!");
		return flag;
	}
	
	/**
	 * @description 修改用户信息时，验证用户手机是否存在
	 * @param userId
	 * @param mobilePhone
	 * @return
	 */
	@RequestMapping(value = "/checkUpdateMobilePhone", method = RequestMethod.POST)
	public boolean checkUpdateMobilePhone(
			@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "mobilePhone") String mobilePhone) {
		log.info("User checkUpdateMobilePhone start! userId = " + userId + " mobilePhone = " + mobilePhone);
		boolean flag = true;
		try {
			if (0 != userId && !StringUtils.isNotBlank(mobilePhone)) {
				UserBase u = new UserBase();
				u.setMobilePhone(mobilePhone.trim());
				List<UserBase> uList = userBaseService.findList(u);
				if (CollectionUtils.isNotEmpty(uList)) {
					u = uList.get(0);
					if (null != u && userId != u.getUserId()) {
						flag = false;
					}
				}
			}
		} catch (LogicException e) {
			log.error("User checkUpdateMobilePhone failed! Exception = " + e);
			e.printStackTrace();
			return true;
		}
		log.info("User checkUpdateMobilePhone end!");
		return flag;
	}
	
	/**
	 * @description 修改用户信息时，验证用户输入Email是否正确
	 * @param userId
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/checkUpdateEmail", method = RequestMethod.POST)
	public boolean checkUpdateEmail(
			@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "email") String email) {
		log.info("User checkUpdateEmail start! userId = " + userId + " email = " + email);
		boolean flag = true;
		try {
			if (0 != userId && !StringUtils.isNotBlank(email)) {
				UserBase u = new UserBase();
				// 强制转码成utf-8，防止@被转码成%40的问题
				u.setEmail(URLDecoder.decode(email.trim(), "utf-8"));
				List<UserBase> uList = userBaseService.findList(u);
				if (CollectionUtils.isNotEmpty(uList)) {
					u = uList.get(0);
					if (null != u && userId != u.getUserId()) {
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			log.error("User checkUpdateEmail failed! Exception = " + e);
			e.printStackTrace();
			return true;
		}
		log.info("User checkUpdateEmail end!");
		return flag;
	}
	
	/**
	 * @description：修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ResultDTO update(@RequestBody UserForm user) {
		log.info("User update start! Parameter userForm = " + user);
		ResultDTO result = new ResultDTO();
		try {
			if (null != user && null != user.getUserBase()
					&& null != user.getUserInfo()) {
				if (2 == userService.update(user.getUserBase(), user.getUserInfo())) {
					result.setSuccess(ControllerConstant.USER_UPDATE_MSG);
				} else {
					result.setError(ControllerConstant.USER_UPDATE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_UPDATE_MSG);
			}
		} catch (LogicException e) {
			log.error("User update failed! Exception = " + e);
			result.setException(ControllerConstant.USER_UPDATE_MSG, e.getMessage());
			return result;
		}
		log.info("User update end!");
		return result;
	}
	
	/**
	 * @description：重置用户密码
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ResultDTO updatePassword(@RequestBody UserBase user) {
		log.info("User updatePassword start! Parameter user = " + user);
		ResultDTO result = new ResultDTO();
		try {
			if (null != user) {
				if (0 < userService.updatePassword(user)) {
					result.setSuccess(ControllerConstant.USER_UPDATE_PWD_MSG);
				} else {
					result.setError(ControllerConstant.USER_UPDATE_PWD_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_UPDATE_PWD_MSG);
			}
		} catch (LogicException e) {
			log.error("User updatePassword failed! Exception = " + e);
			result.setException(ControllerConstant.USER_UPDATE_PWD_MSG, e.getMessage());
			return result;
		}
		log.info("User updatePassword end!");
		return result;
	}
	
	/**
	 * 审核用户信息
	 * @param userExamine
	 * @return
	 */
	@RequestMapping(value = "/examine", method = RequestMethod.POST)
	public ResultDTO examine(@RequestBody UserExamine userExamine) {
		log.info("User examine start! Parameter userExamine = " + userExamine);
		ResultDTO result = new ResultDTO(); 
		try {
			if (null != userExamine && 0 < userExamine.getUserId()) {
				int index = 0;
				// 第一次审核用户的时候，新增用户审核信息
				if (null == userExamineService.find(userExamine.getUserId())) {
					index = userExamineService.add(userExamine);
				} else {
					// 其他审核用户的时候，修改用户审核信息
					index = userExamineService.update(userExamine);
				}
				if (5 == index) {
					result.setSuccess(ControllerConstant.USER_EXAMINE_MSG);
				} else {
					result.setError(ControllerConstant.USER_EXAMINE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_EXAMINE_MSG);
			}
		} catch (LogicException e) {
			log.error("User examine failed! Exception = " + e);
			result.setException(ControllerConstant.USER_EXAMINE_MSG, e.getMessage());
			return result;
		}
		log.info("User examine end!");
		return result;
	}
	
	/**
	 * @description：删除用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResultDTO delete(@RequestBody String userId) {
		log.info("User delete start! Parameter userId = " + userId);
		ResultDTO result = new ResultDTO(); 
		try {
			if (StringUtils.isNoneBlank(userId)) {
				if (1 == userService.deleteById(Integer.parseInt(userId))) {
					result.setSuccess(ControllerConstant.USER_DELETE_MSG);
				} else {
					result.setResultNull(ControllerConstant.USER_DELETE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_DELETE_MSG);
			}
		} catch (LogicException e) {
			log.error("User delete failed! Exception = " + e);
			result.setException(ControllerConstant.USER_DELETE_MSG, e.getMessage());
			return result;
		}
		log.info("User delete end!");
		return result;
	}
	
	/**
	 * @description 批量删除用户信息
	 * @param userIds
	 * @return
	 */
	@RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
	public ResultDTO batchDelete(@RequestBody Integer[] userIds) {
		log.info("User bathDelete start! Parameter userIds = " + userIds);
		ResultDTO result = new ResultDTO();
		try {
			if (ArrayUtils.isNotEmpty(userIds)) {
				if (0 < userService.bathDelete(userIds)) {
					result.setSuccess(ControllerConstant.USER_BATH_DELETE_MSG);
				} else {
					result.setResultNull(ControllerConstant.USER_BATH_DELETE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_BATH_DELETE_MSG);
			}
		} catch (LogicException e) {
			log.error("User bathDelete failed! Exception = " + e);
			result.setException(ControllerConstant.USER_BATH_DELETE_MSG, e.getMessage());
			return result;
		}
		log.info("User bathDelete end!");
		return result;
	}
	
}