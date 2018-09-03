package com.jinlong.system.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.po.user.UserExaminePO;

/**
 * 用户审核信息DAO持久化接口
 * @author 肖学进
 */
@Mapper
public interface IUserExamineDao extends IBasicDao<UserExaminePO> {

}
