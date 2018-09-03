package com.jinlong.system.service.user;

import java.util.List;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.service.IBaseService;
import com.jinlong.system.model.po.user.UserBasePO;

/**
 * @description 用户基础信息Service业务层接口z
 * @author 肖学进
 */
public interface IUserBaseService extends IBaseService<UserBasePO>{
	
	// 增、删、改方法
	
	/**
	 * @Description:新增一条用户基础信息
	 * @param userBase
	 * @return
	 * @throws LogicException
	 */
//	public int addUserBase(UserBase userBase) throws LogicException;
	
	/**
	 * @Description:批量新增一条用户基础信息
	 * @param userBaseList
	 * @return
	 * @throws LogicException
	 */
	public int bathAddUserBase(List<UserBasePO> userBaseList) throws LogicException;
	
	/**
	 * @Description:删除一条用户基础信息
	 * @param userId
	 * @return
	 * @throws LogicException
	 */
//	public int deleteUserBaseByUserId(int userId) throws LogicException;
	
	/**
	 * @Description:批量删除一批用户基础信息
	 * @param userIdList
	 * @return
	 * @throws LogicException
	 */
	public int bathDeleteUser(List<Integer> userIdList) throws LogicException;
	
	/**
	 * @Description:编辑修改一条用户基础信息
	 * @param userbase
	 * @return
	 * @throws LogicException
	 */
//	public int updateUserBase(UserBase userBase) throws LogicException;
	
	// 查询方法
	
	/**
	 * @Description:通过用户ID查询这一条用户基础信息
	 * @param userId
	 * @return
	 * @throws LogicException
	 */
//	public UserBase findUserBaseByUserId(int userId) throws LogicException;
	
	/**
	 * @Description:查询所有的用户基础信息
	 * @return
	 * @throws LogicException
	 */
//	public List<UserBase> findAllUserBase() throws LogicException;

}
