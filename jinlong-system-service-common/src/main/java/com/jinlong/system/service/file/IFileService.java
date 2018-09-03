package com.jinlong.system.service.file;

import java.util.List;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.service.IBaseVOService;
import com.jinlong.system.model.po.file.FileInfoPO;
import com.jinlong.system.model.vo.file.FileVO;

/**
 * 文件信息业务层类接口
 * @author 肖学进
 */
public interface IFileService extends IBaseVOService<FileInfoPO, FileVO> {
	
	/**
	 * 根据文件ID集合批量删除一批FileInfo文件信息
	 * @param fileIds
	 * @return
	 * @throws LogicException
	 */
	public int batchDelete(Integer[] fileIds) throws LogicException;
	
	/**
	 * 通过用户ID，查询此用户最新添加的一条文件信息 
	 * @param userId
	 * @return
	 */
	public FileInfoPO findNewFileByUser(int userId) throws LogicException;
	
	/**
	 * 根据fileId集合得到FileInfo集合
	 * @param fileIdList
	 * @return
	 */
	public List<FileInfoPO> findFileInfoByFileIds(List<Integer> fileIdList) throws LogicException;


}
