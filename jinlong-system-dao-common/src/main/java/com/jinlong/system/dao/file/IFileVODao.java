package com.jinlong.system.dao.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinlong.common.dao.IBasicDao;
import com.jinlong.system.model.vo.file.FileVO;

/**
 * 文件视图类数据持久化层DAO接口
 * @author Administrator
 */
@Mapper
public interface IFileVODao extends IBasicDao<FileVO> {
	
	/**
	 * 通过用户ID查询此用户最新添加的一条文件视图
	 * @param userId
	 * @return
	 */
	public FileVO selectNewFileByUser(@Param(value = "userId") int userId) throws Exception;
	
	/**
	 * 根据文件ID查询一条文件视图
	 * @param fileId
	 * @return
	 */
	public FileVO selectFileInfoById(@Param(value = "fileId") int fileId) throws Exception;
	
	/**
	 * 根据文件ID集合查询一组文件视图集合
	 * @param fileIdList
	 * @return
	 */
	public List<FileVO> selectFileInfoByFileIds(List<Integer> fileIdList) throws Exception;

}
