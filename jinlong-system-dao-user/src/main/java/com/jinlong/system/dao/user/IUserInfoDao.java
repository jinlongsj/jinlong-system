package com.jinlong.system.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.user.UserInfo;

/**
 * @description 用户主信息DAO持久化接口
 * @author 肖学进
 */
@Mapper
public interface IUserInfoDao extends IBasicDao<UserInfo> {

}
