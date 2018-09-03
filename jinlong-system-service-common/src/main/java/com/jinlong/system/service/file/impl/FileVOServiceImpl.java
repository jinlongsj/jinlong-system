package com.jinlong.system.service.file.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.exception.LogicExceptionMessage;
import com.jinlong.common.page.PageList;
import com.jinlong.common.page.PageProperty;
import com.jinlong.common.page.PageUtil;
import com.jinlong.common.service.impl.BaseVOServiceImpl;
import com.jinlong.system.dao.file.IFileDao;
import com.jinlong.system.dao.file.IFileVODao;
import com.jinlong.system.model.po.file.FileInfoPO;
import com.jinlong.system.model.vo.file.FileVO;
import com.jinlong.system.service.file.IFileVOService;

/**
 * 文件视图类业务层实现类
 * @author 肖学进
 */
@Service
public class FileVOServiceImpl extends BaseVOServiceImpl<FileInfoPO, IFileDao, FileVO, IFileVODao>
		implements IFileVOService {
	
	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlong.ssm.service.impl.file.FileVOServiceImpl";

	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(FileVOServiceImpl.class);
	
	/**
	 * 文件试图DAO
	 */
	@Autowired
	private IFileVODao fileVODao;
	
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
	
	
	
	/**
	 * 查询方法（不操作事务的方法）
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

}
