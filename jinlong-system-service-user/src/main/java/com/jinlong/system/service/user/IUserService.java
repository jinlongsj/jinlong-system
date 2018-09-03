package com.jinlong.system.service.user;

import java.util.List;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.model.po.page.JqPage;
import com.jinlong.common.service.IBaseVOService;
import com.jinlong.system.model.po.user.UserBasePO;
import com.jinlong.system.model.po.user.UserInfoPO;
import com.jinlong.system.model.vo.user.UserVO;


/**
 * @description 用户总信息VO视图类Service业务层实现类
 * @author 肖学进
 */
public interface IUserService extends IBaseVOService<UserBasePO, UserVO>{
	
	/**
	 * @description 新增一条用户信息
	 * @param ub
	 * @param ui
	 * @return
	 * @throws LogicException
	 */
	public int add(UserBasePO ub, UserInfoPO ui) throws LogicException;
	
	/**
	 * @description 删除一条用户信息
	 * @param ub
	 * @param ui
	 * @return
	 * @throws LogicException
	 */
	public int delete(UserBasePO ub, UserInfoPO ui) throws LogicException;
	
	/**
	 * @description 通过用户ID删除一条用户信息
	 * @param ub
	 * @param ui
	 * @return
	 * @throws LogicException
	 */
	public int deleteById(int userId) throws LogicException;
	
	/**
	 * @description 批量删除用户信息
	 * @param userIds
	 * @return
	 * @throws LogicException
	 */
	public int bathDelete(Integer[] userIds) throws LogicException;
	
	/**
	 * @description 编辑修改一条用户信息
	 * @param ub
	 * @param ui
	 * @return
	 * @throws LogicException
	 */
	public int update(UserBasePO ub, UserInfoPO ui) throws LogicException;
	
	/**
	 * @description 修改用户密码
	 * @param ub
	 * @return
	 * @throws LogicException
	 */
	public int updatePassword(UserBasePO ub) throws LogicException;
	
	/**
	 * JQgrid分页查询
	 * @param userVO
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	public List<UserVO> findJqPageList(UserVO userVO, JqPage pageInfo) throws LogicException;
	
	/**
	 * 
	 */
	public void importExcel();
	
}
