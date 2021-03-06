package com.jinlong.system.dao.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.po.file.FileInfoPO;

/**
 * 文件信息DAO数据持久层接口
 * @author 肖学进
 */
@Mapper
public interface IFileDao extends IBasicDao<FileInfoPO> {
	
	/**
	 * 通过用户ID查询此用户最新添加的一条文件信息 
	 * @param userId
	 * @return
	 */
	public FileInfoPO selectNewFileByUser(@Param(value = "userId") int userId) throws Exception;
	
	/**
	 * 通过文件ID查询一条文件信息
	 * @param fileId
	 * @return
	 */
	public FileInfoPO selectFileInfoById(@Param(value = "fileId") int fileId) throws Exception;
	
	/**
	 * 通过文件ID集合查询一组文件信息集合
	 * @param fileIdList
	 * @return
	 */
	public List<FileInfoPO> selectFileInfoByFileIds(List<Integer> fileIdList) throws Exception;

}
