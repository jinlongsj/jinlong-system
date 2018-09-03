package com.jinlong.system.dao.role;

import org.apache.ibatis.annotations.Mapper;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.vo.role.RoleVO;

/**
 * 角色视图VO类DAO持久化接口
 * @author 肖学进
 */
@Mapper
public interface IRoleVODao extends IBasicDao<RoleVO> {

}
