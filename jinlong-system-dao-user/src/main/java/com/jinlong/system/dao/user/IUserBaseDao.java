package com.jinlong.system.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.user.UserBase;

/**
 * 用户基础信息DAO持久化接口
 * @author 肖学进
 */
@Mapper
public interface IUserBaseDao extends IBasicDao<UserBase> {
	
	/**
	 * @Description:新增一条用户基础信息
	 * @param userbase
	 * @return
	 * @throws Exception
	 */
//	public int insertUserBase(UserBase userBase) throws Exception;
	
	/**
	 * @Description:批量新增一条用户基础信息
	 * @param userbaseList
	 * @return
	 * @throws Exception
	 */
	public int bathInsert(List<UserBase> userBaseList) throws Exception;
	
	/**
	 * @Description:删除一条用户基础信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
//	public int deleteUserBaseByUserId(@Param (value="userId") int userId) throws Exception;
	
	/**
	 * @Description:批量删除一批用户基础信息
	 * @param userBaseList
	 * @return
	 * @throws Exception
	 */
	public int bathDelete(List<Integer> userIdList) throws Exception;
	
	/**
	 * @Description:编辑修改一条用户基础信息
	 * @param userBase
	 * @return
	 * @throws Exception
	 */
//	public int updateUserBase(UserBase userBase) throws Exception;
	
	/**
	 * @Description:通过用户ID查询这一条用户基础信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
//	public UserBase selectUserBaseByUserId(@Param(value = "userId") int userId) throws Exception;
	
	/**
	 * @Description:查询所有的用户基础信息
	 * @return
	 * @throws Exception
	 */
//	public List<UserBase> selectAllUserBase() throws Exception;

}
