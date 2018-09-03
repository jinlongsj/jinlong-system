package com.jinlong.system.service.common;

import java.util.List;
import java.util.Map;

import com.jinlong.common.exception.LogicException;

/**
 * @description 公共字典表查询的Service业务层接口
 * @author 肖学进
 */
public interface ICommonService {
	
	/**
	 * @description 查询所有的用户状态字典信息
	 * @return
	 * @throws LogicException
	 */
	List<Map<Integer, String>> findUserState() throws LogicException;
	
	/**
	 * @description 查询所有的用户流程状态字典信息
	 * @return
	 * @throws LogicException
	 */
	List<Map<Integer, String>> findUserProcessState() throws LogicException;

	/**
	 * @description 查询所有的角色类别字典信息
	 * @return
	 * @throws LogicException
	 */
	List<Map<Integer, String>> findRoleType() throws LogicException;
	
	/**
	 * @description 查询所有的角色状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> findRoleState() throws LogicException;
	
	/**
	 * @description 查询所有的角色流程状态字典信息
	 * @return
	 * @throws LogicException
	 */
	List<Map<Integer, String>> findRoleProcessState() throws LogicException;
	
	/**
	 * @description 查询所有的菜单类别字典信息
	 * @return
	 * @throws LogicException
	 */
	List<Map<Integer, String>> findMenuType() throws LogicException;
	
	/**
	 * @description 查询所有的菜单级别字典信息
	 * @return
	 * @throws LogicException
	 */
	List<Map<Integer, String>> findMenuLeval() throws LogicException;
	
	/**
	 * @description 查询所有的菜单状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> findMenuState() throws LogicException;
	
	/**
	 * @description 查询所有的菜单流程状态字典信息
	 * @return
	 * @throws LogicException
	 */
	List<Map<Integer, String>> findMenuProcessState() throws LogicException;

}
