package com.jinlong.system.service.file.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.exception.LogicExceptionMessage;
import com.jinlong.common.model.po.page.JqPage;
import com.jinlong.common.page.PageList;
import com.jinlong.common.page.PageProperty;
import com.jinlong.common.page.PageUtil;
import com.jinlong.common.service.impl.BaseVOServiceImpl;
import com.jinlong.system.dao.file.IFileDao;
import com.jinlong.system.dao.file.IFileVODao;
import com.jinlong.system.model.po.file.FileInfoPO;
import com.jinlong.system.model.vo.file.FileVO;
import com.jinlong.system.service.file.IFileService;

/**
 * 文件信息类业务层实现类
 * @author 肖学进
 */
@Service
public class FileServiceImpl extends BaseVOServiceImpl<FileInfoPO, IFileDao, FileVO, IFileVODao>
		implements IFileService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.impl.file.FileServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(FileServiceImpl.class);

	/**
	 * 文件DAO
	 */
	@Autowired
	private IFileDao fileDao;
	
	/**
	 * 文件VO视图DAO
	 */
	@Autowired
	private IFileVODao fileVODao;
	
	
	
	/**
	 * 增删改方法（操作事务的方法）
	 */
	
	/*
	 * 新增一条文件信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#add(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(FileInfoPO file) throws LogicException {
		try {
			return fileDao.insert(file);
		} catch (Exception e) {
			log.error("********** insert FileInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "insert", e);
		}
	}

	/*
	 * 删除一条文件信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(FileInfoPO file) throws LogicException {
		try {
			return fileDao.delete(file);
		} catch (Exception e) {
			log.error("********** delete FileInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "delete", e);
		}
	}
	
	/* 
	 * 通过文件ID删除一条文件信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#deleteById(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteById(int id) throws LogicException {
		try {
			return fileDao.deleteById(id);
		} catch (Exception e) {
			log.error("********** deleteById FileInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "deleteById", e);
		}
	}

	/* 
	 * 根据文件ID集合批量删除一批FileInfo文件信息
	 * (non-Javadoc)
	 * @see com.chujiaxc.driverschool.service.IFileService#findFileInfoByFileId(int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int batchDelete(Integer[] fileIds) throws LogicException {
		try {
			return fileDao.batchDelete(fileIds);
		} catch (Exception e) {
			log.error("********** batchDelete FileInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "batchDelete", e);
		}
	}

	/*
	 * 修改编辑一条文件信息
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(FileInfoPO file) throws LogicException {
		try {
			return fileDao.update(file);
		} catch (Exception e) {
			log.error("********** update FileInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "update", e);
		}
	}
	
	
	
	/**
	 * 查询方法（不操作事务的方法）
	 */
	
	/* 
	 * 查找一条文件视图
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#find(int)
	 */
	public FileVO find(int id) throws LogicException {
		try {
			return fileVODao.select(id);
		} catch (Exception e) {
			log.error("********** find FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "find", e);
		}
	}

	/* 
	 * 查找所有的文件视图
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findAll()
	 */
	public List<FileVO> findAll() throws LogicException {
		try {
			return fileVODao.selectAll();
		} catch (Exception e) {
			log.error("********** findAll FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findAll", e);
		}
	}

	/* 
	 * 根据条件，查找一批文件视图
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseServiceImpl#findList(java.lang.Object)
	 */
	public List<FileVO> findList(FileVO fileVO) throws LogicException {
		try {
			return fileVODao.selectList(fileVO);
		} catch (Exception e) {
			log.error("********** findList FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findList", e);
		}
	}

	/* 
	 * 查找最新的一条文件视图
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNew()
	 */
	public FileVO findNew() throws LogicException {
		try {
			return fileVODao.selectNew();
		} catch (Exception e) {
			log.error("********** findNew FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNew", e);
		}
	}

	/* 
	 * 查找最新的count条文件视图
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findNewList(int)
	 */
	public List<FileVO> findNewList(int count) throws LogicException {
		try {
			return fileVODao.selectNewList(count);
		} catch (Exception e) {
			log.error("********** findNewList FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNewList", e);
		}
	}

	/*
	 * 通过用户ID，查询此用户最新添加的一条文件信息 
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.file.IFileService#findNewFileByUser(int)
	 */
	public FileInfoPO findNewFileByUser(int userId) throws LogicException{
		try {
			return fileDao.selectNewFileByUser(userId);
		} catch (Exception e) {
			log.error("********** selectNewFileByUser FileInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectNewFileByUser", e);
		}
	}
	
	/* 
	 * 通过条件，查询文件信息总数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.file.IFileService#findFileInfoByFileIds(java.util.List)
	 */
	public List<FileInfoPO> findFileInfoByFileIds(List<Integer> fileIdList) throws LogicException{
		try {
			return fileDao.selectFileInfoByFileIds(fileIdList);
		} catch (Exception e) {
			log.error("********** selectFileInfoByFileIds FileInfo ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "selectFileInfoByFileIds", e);
		}
	}
	
	
	
	/**
	 * 分页查询方法（不操作事务的方法）
	 */
	
	/* 
	 * 通过用户ID，查询此用户最新添加的一条文件视图 
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findCount(java.util.Map)
	 */
	public int findCount(Map<String, Object> param) throws LogicException {
		try {
			return fileVODao.getCount(param);
		} catch (Exception e) {
			log.error("********** findNewList FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findNewList", e);
		}
	}

	/* 
	 * 通过条件，查询文件视图总数
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.impl.BaseVOServiceImpl#findPageList(com.jinlong.common.page.PageProperty)
	 */
	public PageList<FileVO> findPageList(PageProperty pp) throws LogicException {
		try {
			int count = fileVODao.getCount(pp.getParamMap());
			int startRow = PageUtil.getStart(pp.getNpage(), count,
					pp.getNpagesize());
			int endRow = PageUtil.getEnd(pp.getNpage(), count,
					pp.getNpagesize());
			pp.putParamMap("startRow", startRow - 1);
			pp.putParamMap("endRow", endRow);
			pp.putParamMap("pageSize", pp.getNpagesize());
			return new PageList<FileVO>(pp.getNpage(), pp.getNpagesize(), count,
					fileVODao.getSplitList(pp.getParamMap()));
		} catch (Exception e) {
			log.error("********** findPageList FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findPageList", e);
		}
	}

	/* 
	 * JQgrid分页查询
	 * (non-Javadoc)
	 * @see com.jinlong.common.service.IBaseVOService#findJqPageList(com.jinlong.common.jqpage.JqPage)
	 */
	@Override
	public List<FileVO> findJqPageList(FileVO file, JqPage pageInfo) throws LogicException {
		try {
			if (null != pageInfo) {
				Integer total = fileVODao.getCount(this.putToMap(file, pageInfo));
				Integer totalPage = Integer.valueOf(Integer.valueOf(total.intValue() / pageInfo.getRows().intValue()).intValue() 
						+ (total.intValue() % pageInfo.getRows().intValue() == 0 ? 0 : 1));
				pageInfo.setTotalPage(totalPage);
				pageInfo.setRecord(total);
				return fileVODao.getSplitList(this.putToMap(file, pageInfo));
			}
			return null;
		} catch (Exception e) {
			log.error("********** findJqPageList FileVO ERROR ********** Exception = " + e);
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "findJqPageList", e);
		}
	}
	
	/**
	 * @HashMap转换
	 * @param fileVO
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String, Object> putToMap(FileVO file, JqPage pageInfo) throws LogicException {
		Map map = new HashMap();
		if (null != file) {
			map.put("fileName", file.getFileName());
			map.put("fileTypeId", file.getFilelTypeId());
			map.put("state", file.getState());
		}
		if (null != pageInfo) {
			Integer curPage = pageInfo.getPage();
			Integer pageSize = pageInfo.getRows();
			Integer startRow = Integer.valueOf((curPage.intValue() - 1) * pageSize.intValue());
			map.put("startRow", startRow);
			map.put("pageSize", pageSize);
		}
		return map;
	}
}