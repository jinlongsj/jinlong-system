package com.jinlong.system.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.user.UserExamineRecord;

/**
 * 用户审核记录信息DAO持久化接口
 * @author 肖学进
 */
@Mapper
public interface IUserExamineRecordDao extends IBasicDao<UserExamineRecord> {

}
