package com.jinlong.system.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.vo.user.UserVO;

/**
 * 用户数据持久层接口DAO
 * @author 肖学进
 */
@Mapper
public interface IUserVODao extends IBasicDao<UserVO> {

}
