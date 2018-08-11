package com.jinlong.system.web.controller.role;


import java.util.Arrays;
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
import com.jinlong.system.model.form.role.RoleForm;
import com.jinlong.system.model.form.role.RoleVOForm;
import com.jinlong.system.model.po.role.RoleInfo;
import com.jinlong.system.model.vo.menu.MenuVO;
import com.jinlong.system.model.vo.role.RoleVO;
import com.jinlong.system.service.menu.IMenuService;
import com.jinlong.system.service.role.IRoleService;

/**
 * @description：角色信息控制器
 * @author 肖学进
 */
@RestController
@RequestMapping("/role")
public class RoleController {
	
	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(RoleController.class);
	
	/**
	 * Spring依赖注入的服务层
	 */
	// 角色服务层接口
	@Autowired
	private IRoleService roleService;
	// 菜单服务层接口
	@Autowired
	private IMenuService menuService;

	/**
	 * @description；查询所有角色对象
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public ResultDTO manage(@RequestBody RoleVOForm role) {
		log.info("Role manage start! Parameter role = " + role);
		ResultDTO result = new ResultDTO();
		try {
			if (null != role) {
				List<RoleVO> roleList = roleService.findJqPageList(role.getRole(), role.getPageInfo());
				if (CollectionUtils.isNotEmpty(roleList)) {
					result.setSuccess(ControllerConstant.ROLE_MANAGE_MSG, roleList, role.getPageInfo());
				} else if (0 == roleList.size()) {
					result.setResultNull(ControllerConstant.ROLE_MANAGE_MSG, roleList, role.getPageInfo());
				} else {
					result.setError(ControllerConstant.ROLE_MANAGE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.ROLE_MANAGE_MSG);
			}
		} catch (LogicException e) {
			log.error("Role manage failed! Exception = " + e);
			result.setParameterNull(ControllerConstant.ROLE_MANAGE_MSG, e.getMessage());
			return result;
		}
		log.info("Role manage end!");
		return result;
	}
	
	/**
	 * @description 查询菜单列表信息
	 * @return
	 */
	@RequestMapping(value = "/showMenuList", method = RequestMethod.POST)
	public ResultDTO showMenuList() {
		log.info("Role showMenuList start!");
		ResultDTO result = new ResultDTO();
		try {
			List<MenuVO> menuList = menuService.findAllMenu();
			if (CollectionUtils.isNotEmpty(menuList)) {
				result.setSuccess(ControllerConstant.MENU_MANAGE_MSG, menuList);
			} else if (0 == menuList.size()) {
				result.setResultNull(ControllerConstant.MENU_MANAGE_MSG);
			} else {
				result.setError(ControllerConstant.MENU_MANAGE_MSG);
			}
		} catch (LogicException e) {
			log.error("Role showMenuList failed! Exception = " + e);
			result.setException(ControllerConstant.MENU_MANAGE_MSG, e.getMessage());
			return result;
		}
		log.info("Role showMenuList end!");
		return result;
	}
	
	/**
	 * @description：添加角色信息时，验证角色编码是否存在
	 * @param roleName
	 * @return
	 */
	@RequestMapping(value = "/checkCodeAdd", method = RequestMethod.POST)
	public boolean checkCodeAdd(@RequestParam(value = "roleCode") String roleCode) {
		log.info("Role checkCodeAdd start! Parameter roleCode = " + roleCode);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(roleCode)) {
				RoleVO role = new RoleVO();
				role.setRoleCode(roleCode);
				List<RoleVO> roleList = roleService.findList(role);
				if (null != roleList) {
					if (roleList.size() != 0) {
						flag = false;
					}
				}
			}
		} catch (LogicException e) {
			log.error("Role checkCodeAdd failed! Exception = " + e);
			return true;
		}
		log.info("Role checkCodeAdd end!");
		return flag;
	}
	
	/**
	 * @description：添加角色信息时，验证角色名称是否存在
	 * @param roleName
	 * @return
	 */
	@RequestMapping(value = "/checkAdd", method = RequestMethod.POST)
	public boolean checkAdd(@RequestParam(value = "roleName") String roleName) {
		log.info("Role checkAdd start! Parameter roleName = " + roleName);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(roleName)) {
				RoleVO role = new RoleVO();
				role.setRoleName(roleName);
				List<RoleVO> roleList = roleService.findList(role);
				if (null != roleList) {
					if (roleList.size() != 0) {
						flag = false;
					}
				}
			}
		} catch (LogicException e) {
			log.error("Role checkAdd failed! Exception = " + e);
			return true;
		}
		log.info("Role checkAdd end!");
		return flag;
	}
	
	/**
	 * @description；添加角色信息
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public ResultDTO add(@RequestBody RoleForm role) {
		log.info("Role add start! Parameter role = " + role);
		ResultDTO result = new ResultDTO();
		try {
			if (null != role && null != role.getRole() 
					&& ArrayUtils.isNotEmpty(role.getMenuIds())) {
				if (0 < roleService.add(role.getRole(), Arrays.asList(role.getMenuIds()))) {
					result.setSuccess(ControllerConstant.ROLE_ADD_MSG);
				} else {
					result.setError(ControllerConstant.ROLE_ADD_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.ROLE_ADD_MSG);
			}
		} catch (LogicException e) {
			log.error("Role add failed! Exception = " + e);
			result.setException(ControllerConstant.ROLE_ADD_MSG, e.getMessage());
			return result;
		}
		log.info("Role add end!");
		return result;
	}
	
	/**
	 * @description：进入修改用户的页面
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ResultDTO show(@RequestBody Integer roleId) {
		log.info("Role show start! Parameter roleId = " + roleId);
		ResultDTO result = new ResultDTO();
		try {
			RoleVO role = roleService.find(roleId);
			List<Integer> menuIds = menuService.findDistributeMenu(role);
			if (null != role && CollectionUtils.isNotEmpty(menuIds)) {
				role.setMenuIds(menuIds);
				// 显示对于添加的用户角色信息
				result.setSuccess(ControllerConstant.ROLE_SHOW_MSG, role);
			} else {
				result.setError(ControllerConstant.ROLE_SHOW_MSG);
			}
		} catch (LogicException e) {
			log.error("Role show failed! Exception = " + e);
			result.setException(ControllerConstant.ROLE_SHOW_MSG, e.getMessage());
			return result;
		}
		log.info("Role show end!");
		return result;
	}
	
	/**
	 * @description：修改角色信息时，验证角色编码是否存在
	 * @param roleName
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/checkCodeUpdate", method = RequestMethod.POST)
	public boolean checkCodeUpdate(
			@RequestParam(value = "roleCode") String roleCode, 
			@RequestParam(value = "roleId") int roleId) {
		log.info("Role checkCodeUpdate start! Parameter roleCode = " + roleCode + " roleId = " + roleId);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(roleCode)) {
				RoleVO role = new RoleVO();
				role.setRoleCode(roleCode);
				RoleVO r = roleService.find(roleId);
				if (null != r) {
					if (!r.getRoleName().equals(roleCode) 
							&& roleService.findList(role).size() != 0) {
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			log.error("Role checkCodeUpdate failed! Exception = " + e);
			return true;
		}
		log.info("Role checkCodeUpdate end!");
		return flag;
	}
	
	/**
	 * @description：修改角色信息时，验证角色名称是否存在
	 * @param roleName
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/checkUpdate", method = RequestMethod.POST)
	public boolean checkUpdate(
			@RequestParam(value = "roleName") String roleName, 
			@RequestParam(value = "roleId") int roleId) {
		log.info("Role checkUpdate start! Parameter roleName = " + roleName + " roleId = " + roleId);
		boolean flag = true;
		try {
			if (StringUtils.isNotBlank(roleName)) {
				RoleVO role = new RoleVO();
				role.setRoleName(roleName);
				RoleVO r = roleService.find(roleId);
				if (null != r) {
					if (!r.getRoleName().equals(roleName) 
							&& roleService.findList(role).size() != 0) {
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			log.error("Role checkUpdate failed! Exception = " + e);
			return true;
		}
		log.info("Role checkUpdate end!");
		return flag;
	}
	
	/**
	 * @description：修改角色信息
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultDTO update(@RequestBody RoleForm role) {
		log.info("Role update start! Parameter role = " + role);
		ResultDTO result = new ResultDTO();
		try {
			if (null != role && null != role.getRole() 
					&& ArrayUtils.isNotEmpty(role.getMenuIds())) {
				if (0 < roleService.update(role.getRole(), Arrays.asList(role.getMenuIds()))) {
					result.setSuccess(ControllerConstant.ROLE_UPDATE_MSG);
				} else {
					result.setError(ControllerConstant.ROLE_UPDATE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.ROLE_UPDATE_MSG);
			}
		} catch (Exception e) {
			log.error("Role update failed! Exception = " + e);
			result.setException(ControllerConstant.ROLE_UPDATE_MSG, e.getMessage());
			return result;
		}
		log.info("Role update end!");
		return result;
	}
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResultDTO delete(@RequestBody int roleId){
		log.info("Role delete start! Parameter roleId = " + roleId);
		ResultDTO result = new ResultDTO();
		try {
			if (0 != roleId) {
				if (0 < roleService.deleteById(roleId)) {
					result.setSuccess(ControllerConstant.ROLE_DELETE_MSG);
				} else {
					result.setError(ControllerConstant.ROLE_DELETE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.ROLE_DELETE_MSG);
			}
		} catch (Exception e) {
			log.error("Role delete failed! Exception = " + e);
			result.setException(ControllerConstant.ROLE_DELETE_MSG, e.getMessage());
			return result;
		}
		log.info("Role delete end!");
		return result;
	}
	
	/**
	 * @description：进入菜单分配页面
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/distributeShow", method = RequestMethod.POST)
	public ResultDTO distributeShow(@RequestBody int roleId) {
		log.info("Role distributeShow start! Parameter roleId = " + roleId);
		ResultDTO result = new ResultDTO();
		try {
			if (0 != roleId) {
				RoleVO role = roleService.find(roleId);
				List<Integer> menuList = menuService.findDistributeMenu(role);
				if (null != menuList) {
					if (0 < menuList.size()) {
						result.setSuccess(ControllerConstant.ROLE_MENU_TO_DISTRIBUTE, menuList);
					} else {
						result.setResultNull(ControllerConstant.ROLE_MENU_TO_DISTRIBUTE, menuList);
					}
				} else {
					result.setError(ControllerConstant.ROLE_MENU_TO_DISTRIBUTE);
				}
			} else {
				result.setParameterNull(ControllerConstant.ROLE_MENU_TO_DISTRIBUTE);
			}
		} catch (Exception e) {
			log.error("Role distributeShow failed! Exception = " + e);
			result.setException(ControllerConstant.ROLE_MENU_TO_DISTRIBUTE, e.getMessage());
			return result;
		}
		log.info("Role distributeShow end!");
		return result;
	}
	
	/**
	 * 分配菜单
	 * @param role
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/distribute", method = RequestMethod.POST)
	public ResultDTO distribute(@RequestBody RoleInfo role, @RequestBody MenuVO menu) {
		log.info("Role distribute start! Parameter role = " + role);
		ResultDTO result = new ResultDTO();
		try {
			if (role != null && menu != null) {
				if (menu.getMenuIds()!= null && menu.getMenuIds().size() != 0) {
					menuService.distributeMenu(role, menu.getMenuIds());
				} else {
					result.setError(ControllerConstant.ROLE_MENU_DISTRIBUTE);
				}
			} else {
				result.setParameterNull(ControllerConstant.ROLE_MENU_DISTRIBUTE);
			}
		} catch (Exception e) {
			log.error("Role distribute failed! Exception = " + e);
			result.setException(ControllerConstant.ROLE_MENU_DISTRIBUTE, e.getMessage());
			return result;
		}
		log.info("Role distribute end!");
		return result;
	}

}