package com.jinlong.system.dao.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;

/**
 * @description 公共字典表查询的DAO数据持久化层接口
 * @author 肖学进
 */
@SuppressWarnings("rawtypes")
@Mapper
public interface ICommonDao extends IBasicDao{
	
	/**
	 * @description 查询所有的用户状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectUserState() throws Exception; 
	
	/**
	 * @description 查询所有的用户流程状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectUserProcessState() throws Exception;

	/**
	 * @description 查询所有的角色类别字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectRoleType() throws Exception; 
	
	/**
	 * @description 查询所有的角色状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectRoleState() throws Exception;
	
	/**
	 * @description 查询所有的角色流程状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectRoleProcessState() throws Exception;
	
	/**
	 * @description 查询所有的菜单类别字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectMenuType() throws Exception;
	
	/**
	 * @description 查询所有的菜单级别字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectMenuLeval() throws Exception;
	
	/**
	 * @description 查询所有的菜单状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectMenuState() throws Exception;
	
	/**
	 * @description 查询所有的菜单流程状态字典信息
	 * @return
	 * @throws Exception
	 */
	List<Map<Integer, String>> selectMenuProcessState() throws Exception;

}
