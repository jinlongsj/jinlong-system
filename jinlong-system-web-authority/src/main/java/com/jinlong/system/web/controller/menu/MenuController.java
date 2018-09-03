package com.jinlong.system.web.controller.menu;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinlong.common.exception.LogicException;
import com.jinlong.system.common.constant.ControllerConstant;
import com.jinlong.system.model.dto.ResultDTO;
import com.jinlong.system.model.form.menu.MenuVOForm;
import com.jinlong.system.model.po.menu.MenuInfoPO;
import com.jinlong.system.model.vo.menu.MenuVO;
import com.jinlong.system.service.menu.IMenuService;

/**
 * @description：菜单信息控制器
 * @author Administrator
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	/**
	 * 日志记录器
	 */
	private static final Log log = LogFactory.getLog(MenuController.class);
	
	/**
	 * Spring接口注入
	 */
	// 菜单信息Service业务层接口
	@Autowired
	private IMenuService menuService;
	
	/**
	 * @description 查询菜单列表信息
	 * @return
	 */
	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public ResultDTO manage(@RequestBody MenuVOForm menu) {
		log.info("Menu manage start!");
		ResultDTO result = new ResultDTO();
		try {
			List<MenuVO> menuList = menuService.findJqPageList(menu.getMenu(), menu.getPageInfo());
			if (CollectionUtils.isNotEmpty(menuList)) {
				result.setSuccess(ControllerConstant.MENU_MANAGE_MSG, menuList);
			} else if (0 == menuList.size()) {
				result.setResultNull(ControllerConstant.MENU_MANAGE_MSG);
			} else {
				result.setError(ControllerConstant.MENU_MANAGE_MSG);
			}
		} catch (LogicException e) {
			log.error("Menu manage ERROR! Exception = " + e);
			result.setException(ControllerConstant.MENU_MANAGE_MSG, e.getMessage());
			return result;
		}
		log.info("Menu manage end!");
		return result;
	}

	/**
	 * @description：添加菜单信息时，验证菜单名称是否存在
	 * @param menuName
	 * @return
	 */
	@RequestMapping(value = "/checkAdd", method = RequestMethod.POST)
	public boolean checkAdd(@RequestParam(value = "menuName") String menuName) {
		log.info("Menu checkAdd start! Parameter menuName = " + menuName);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(menuName)) {
				MenuVO menu = new MenuVO();
				menu.setMenuName(menuName.trim());
				List<MenuVO> userList = menuService.findList(menu);
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
		log.info("Menu checkAdd end!");
		return flag;
	}
	
	/**
	 * @description 新增菜单信息
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultDTO add(@RequestBody MenuInfoPO menu) {
		log.info("add Menu start! Parameter menu = " + menu);
		ResultDTO result = new ResultDTO();
		try {
			if (1 != menuService.add(menu)) {
				result.setSuccess(ControllerConstant.MENU_ADD_MSG);
			} else {
				result.setError(ControllerConstant.MENU_ADD_MSG);
			}
		} catch (LogicException e) {
			log.error("add Menu ERROR! Exception = " + e);
			result.setException(ControllerConstant.MENU_ADD_MSG);
			return result;
		}
		log.info("add Menu end!");
		return result;
	}
	
	/**
	 * @description：修改用户信息时，验证用户名是否存在
	 * @param menuId
	 * @param menuName
	 * @return
	 */
	@RequestMapping(value = "/checkUpdate", method = RequestMethod.POST)
	public boolean checkUpdate(
			@RequestParam(value = "menuId") Integer menuId,
			@RequestParam(value = "menuName") String menuName) {
		log.info("User checkUpdate start! Parameter menuId = " + menuId + " menuName = " + menuName);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(menuName) && 0 != menuId) {
				MenuVO m = new MenuVO();
				m.setMenuName(menuName.trim());
				List<MenuVO> mList = menuService.findList(m);
				if (CollectionUtils.isNotEmpty(mList)) {
					m = mList.get(0);
					if (null != m && m.getMenuId() != menuId) {
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
	 * @description 修改菜单信息
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResultDTO update(@RequestBody MenuInfoPO menu) {
		log.info("update Menu start! Parameter menu = " + menu);
		ResultDTO result = new ResultDTO();
		try {
			if (1 != menuService.update(menu)) {
				result.setSuccess(ControllerConstant.MENU_UPDATE_MSG);
			} else {
				result.setError(ControllerConstant.MENU_UPDATE_MSG);
			}
		} catch (LogicException e) {
			log.error("update Menu ERROR! Exception = " + e);
			result.setException(ControllerConstant.MENU_UPDATE_MSG);
			return result;
		}
		log.info("update Menu end!");
		return result;
	}
	
	/**
	 * 删除菜单信息
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ResultDTO delete(@RequestParam(value = "menuId") Integer menuId) {
		log.info("delete Menu start! Parameter menuId = " + menuId);
		ResultDTO result = new ResultDTO();
		try {
			if (1 != menuService.deleteById(menuId)) {
				result.setSuccess(ControllerConstant.MENU_DELETE_MSG);
			} else {
				result.setError(ControllerConstant.MENU_DELETE_MSG);
			}
		} catch (LogicException e) {
			log.error("delete Menu ERROR! Exception = " + e);
			result.setException(ControllerConstant.MENU_DELETE_MSG);
			return result;
		}
		log.info("delete Menu end!");
		return result;
	}
	
	

}