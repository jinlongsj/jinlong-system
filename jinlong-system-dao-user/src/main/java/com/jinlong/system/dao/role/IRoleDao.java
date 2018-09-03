package com.jinlong.system.dao.role;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.po.role.RoleInfoPO;

/**
 * 角色数据持久层接口DAO
 * @author 肖学进
 */
@Mapper
public interface IRoleDao extends IBasicDao<RoleInfoPO> {

}
