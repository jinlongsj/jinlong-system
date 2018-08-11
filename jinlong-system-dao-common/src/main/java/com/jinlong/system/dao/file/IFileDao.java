package com.jinlong.system.dao.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinlong.system.dao.IBasicDao;
import com.jinlong.system.model.po.file.FileInfo;

/**
 * 文件信息DAO数据持久层接口
 * @author 肖学进
 */
@Mapper
public interface IFileDao extends IBasicDao<FileInfo> {
	
	/**
	 * 通过用户ID查询此用户最新添加的一条文件信息 
	 * @param userId
	 * @return
	 */
	public FileInfo selectNewFileByUser(@Param(value = "userId") int userId) throws Exception;
	
	/**
	 * 通过文件ID查询一条文件信息
	 * @param fileId
	 * @return
	 */
	public FileInfo selectFileInfoById(@Param(value = "fileId") int fileId) throws Exception;
	
	/**
	 * 通过文件ID集合查询一组文件信息集合
	 * @param fileIdList
	 * @return
	 */
	public List<FileInfo> selectFileInfoByFileIds(List<Integer> fileIdList) throws Exception;

}
