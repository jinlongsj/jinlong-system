package com.jinlong.system.web.controller.common;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jinlong.system.common.constant.ControllerConstant;
import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.model.dto.ResultDTO;
import com.jinlong.system.service.common.ICommonService;

/**
 * @description：公共的字典表查询的Controller方法
 * @author Administrator
 */
@RestController
@RequestMapping("/common")
public class CommonController {
	
	/**
	 * 日志记录器
	 */
	private static final Log log = LogFactory.getLog(CommonController.class);
	
	/**
	 * Spring接口注入
	 */
	// 公共字典信息Service业务层接口
	@Autowired
	private ICommonService commonService;
	
	/**
	 * @description 查询所有的用户状态字典信息
	 * @return
	 */
	@RequestMapping(value = "/showUserState", method = RequestMethod.POST)
	public ResultDTO showUserState() {
		log.info("showUserState start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findUserState();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_USER_STATE, list);
			} else if (0 == list.size()) {
				result.setResultNull(ControllerConstant.COMMON_USER_STATE);
			} else {
				result.setError(ControllerConstant.COMMON_USER_STATE);
			}
		} catch (LogicException e) {
			log.error("showUserState ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_USER_STATE);
			return result;
		}
		log.info("showUserState end!");
		return result;
	}
	
	/**
	 * @description 查询所有的用户流程状态字典信息
	 * @return
	 */
	@RequestMapping(value = "/showUserProcessState", method = RequestMethod.POST)
	public ResultDTO showUserProcessState() {
		log.info("showUserProcessState start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findUserProcessState();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_USER_PROCCESS_STATE, list);
			} else if (0 == list.size()) {
				result.setResultNull(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			} else {
				result.setError(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			}
		} catch (LogicException e) {
			log.error("showUserProcessState ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			return result;
		}
		log.info("showUserProcessState end!");
		return result;
	}
	
	/**
	 * @description 查询所有的角色类别字典信息
	 * @return
	 */
	@RequestMapping(value = "/showRoleType", method = RequestMethod.POST)
	public ResultDTO showRoleType() {
		log.info("showRoleType start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findRoleType();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_ROLE_TYPE, list);
			} else if (0 == list.size()) {
				result.setResultNull(ControllerConstant.COMMON_ROLE_TYPE);
			} else {
				result.setError(ControllerConstant.COMMON_ROLE_TYPE);
			}
		} catch (LogicException e) {
			log.error("showRoleType ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_ROLE_TYPE);
			return result;
		}
		log.info("showRoleType end!");
		return result;
	}
	
	/**
	 * @description 查询所有的角色状态字典信息
	 * @return
	 */
	@RequestMapping(value = "/showRoleState", method = RequestMethod.POST)
	public ResultDTO showRoleState() {
		log.info("showRoleState start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findRoleState();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_ROLE_STATE, list);
			} else if (0 == list.size()) {
				result.setResultNull(ControllerConstant.COMMON_ROLE_STATE);
			} else {
				result.setError(ControllerConstant.COMMON_ROLE_STATE);
			}
		} catch (LogicException e) {
			log.error("showRoleState ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_ROLE_STATE);
			return result;
		}
		log.info("showRoleState end!");
		return result;
	}
	
	/**
	 * @description 查询所有的角色流程状态字典信息
	 * @return
	 */
	@RequestMapping(value = "/showRoleProcessState", method = RequestMethod.POST)
	public ResultDTO showRoleProcessState() {
		log.info("showRoleProcessState start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findRoleProcessState();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_USER_PROCCESS_STATE, list);
			} else if (0 == list.size()) {
				result.setResultNull(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			} else {
				result.setError(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			}
		} catch (LogicException e) {
			log.error("showRoleProcessState ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			return result;
		}
		log.info("showRoleProcessState end!");
		return result;
	}
	
	/**
	 * @description 查询所有的菜单类别字典信息
	 * @return
	 */
	@RequestMapping(value = "/showMenuType", method = RequestMethod.POST)
	public ResultDTO showMenuType() {
		log.info("showMenuType start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findMenuType();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_MENU_TYPE, list);
			} else if (0 == list.size()) {
				result.setParameterNull(ControllerConstant.COMMON_MENU_TYPE);
			} else {
				result.setError(ControllerConstant.COMMON_MENU_TYPE);
			}
		} catch (LogicException e) {
			log.error("showMenuType ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_MENU_TYPE);
			return result;
		}
		log.info("showMenuType end!");
		return result;
	}
	
	/**
	 * @description 查询所有的菜单级别字典信息
	 * @return
	 */
	@RequestMapping(value = "/showMenuLeval", method = RequestMethod.POST)
	public ResultDTO showMenuLeval() {
		log.info("showMenuLeval start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findMenuLeval();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_MENU_TYPE, list);
			} else if (0 == list.size()) {
				result.setParameterNull(ControllerConstant.COMMON_MENU_TYPE);
			} else {
				result.setError(ControllerConstant.COMMON_MENU_TYPE);
			}
		} catch (LogicException e) {
			log.error("showMenuLeval ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_MENU_TYPE);
			return result;
		}
		log.info("showMenuLeval end!");
		return result;
	}
	
	/**
	 * @description 查询所有的菜单状态字典信息
	 * @return
	 */
	@RequestMapping(value = "/showMenuState", method = RequestMethod.POST)
	public ResultDTO showMenuState() {
		log.info("showMenuState start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findMenuState();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_MENU_STATE, list);
			} else if (0 == list.size()) {
				result.setParameterNull(ControllerConstant.COMMON_MENU_STATE);
			} else {
				result.setError(ControllerConstant.COMMON_MENU_STATE);
			}
		} catch (LogicException e) {
			log.error("showMenuState ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_MENU_STATE);
			return result;
		}
		log.info("showMenuState end!");
		return result;
	}
	
	/**
	 * @description 查询所有的菜单流程状态字典信息
	 * @return
	 */
	@RequestMapping(value = "/showMenuProcessState", method = RequestMethod.POST)
	public ResultDTO showMenuProcessState() {
		log.info("showMenuProcessState start!");
		ResultDTO result = new ResultDTO();
		try {
			List<Map<Integer, String>> list = commonService.findMenuProcessState();
			if (CollectionUtils.isNotEmpty(list)) {
				result.setSuccess(ControllerConstant.COMMON_USER_PROCCESS_STATE, list);
			} else if (0 == list.size()) {
				result.setResultNull(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			} else {
				result.setError(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			}
		} catch (LogicException e) {
			log.error("showMenuProcessState ERROR! Exception = " + e);
			result.setException(ControllerConstant.COMMON_USER_PROCCESS_STATE);
			return result;
		}
		log.info("showMenuProcessState end!");
		return result;
	}

}
