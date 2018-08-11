package com.jinlong.system.web.controller.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinlong.system.common.constant.ControllerConstant;
import com.jinlong.system.model.dto.ResultDTO;
import com.jinlong.system.model.vo.menu.MenuVO;
import com.jinlong.system.service.menu.IMenuService;

/**
 * @description 驾校用户后台主页面Action
 * @author 肖学进	
 */
@Controller
@RequestMapping("/main")
public class MainController {

	/**
	 * 日志记录器
	 */
	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Spring依赖注入的服务层接口
	 */
	// 菜单服务层接口
	@Autowired
	private IMenuService menuService;
	
	/**
	 * @description 进入驾校用户后台主页面的头部
	 * @return
	 */
	@RequestMapping(value = "/home")
	public String home() {
		logger.info("home statrt!");
		return "homre";
	}
	
	/**
	 * @description 进入驾校用户后台主页面的头部
	 * @return
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public @ResponseBody ResultDTO show() {
		logger.info("main show menu start");
		ResultDTO result = new ResultDTO();
		try {
			List<MenuVO> menuList = menuService.findListByUser(3).get(0).getSon();
			if (null != menuList) {
				result.setSuccess(ControllerConstant.MAIN_SHOW_MSG, menuList);
			} else {
				result.setError(ControllerConstant.MAIN_SHOW_MSG);
			}
		} catch (Exception e) {
			logger.error("Menu show ERROR! Exception = " + e);
			result.setException(ControllerConstant.MAIN_SHOW_MSG + e.getMessage());
			return result;
		}
		logger.info("main show menu end");
		return result;
	}
	
}