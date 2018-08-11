/**
 * FileName: 	 UserProcessController.java
 * @Description: 用户流程Controller控制器
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2010-2011
 * Company   	Jinlong
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年5月24日 上午11:10:48 
 **/

package com.jinlong.system.web.controller.user;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jinlong.system.common.constant.ControllerConstant;
import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.model.dto.ResultDTO;
import com.jinlong.system.model.form.user.UserProcessVOForm;
import com.jinlong.system.model.vo.user.UserProcessVO;
import com.jinlong.system.service.user.IUserProcessService;

/**
 * 用户流程Controller控制器
 * @author:	肖学进
 * @date: 2018年5月31日 上午11:35:10
 */
@RestController
@RequestMapping("/userProcess")
public class UserProcessController {
	
	/**
	 * 日志记录器
	 */
	private static Log log = LogFactory.getLog(UserProcessController.class);
	
	/**
	 * Spring注入的Service层接口
	 */
	// 用户流程服务层接口
	@Autowired
	private IUserProcessService userProcessService;
	
	/**
	 * 用户流程分页列表查询
	 * @param userProcess
	 * @return
	 */
	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public ResultDTO manage(@RequestBody UserProcessVOForm userProcess) {
		log.info("UserProcess manage start! Parameter userProcess = " + userProcess);
		ResultDTO result = new ResultDTO();
		try {
			if (null != userProcess) {
				List<UserProcessVO> userList = userProcessService.findJqPageList(userProcess.getUserProcessVO(), userProcess.getPageInfo());
				if (CollectionUtils.isNotEmpty(userList)) {
					result.setSuccess(ControllerConstant.USER_PROCESS_MANAGE_MSG, userList, userProcess.getPageInfo());
				} else if (0 == userList.size()) {
					result.setResultNull(ControllerConstant.USER_PROCESS_MANAGE_MSG, userList, userProcess.getPageInfo());
				} else {
					result.setError(ControllerConstant.USER_PROCESS_MANAGE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.USER_PROCESS_MANAGE_MSG);
			}
		} catch (LogicException e) {
			log.error("User manage failed! Exception = " + e);
			result.setException(ControllerConstant.USER_PROCESS_MANAGE_MSG, e.getMessage());
			return result;
		}
		log.info("UserProcess manage end!");
		return result;
	}

}
