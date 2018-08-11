package com.jinlong.system.file.manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.model.po.file.FileInfo;
import com.jinlong.system.model.vo.file.FileVO;
import com.jinlong.system.service.file.IFileService;

/**
 * @description 文件上传下载管理器
 * @author 肖学进
 */
@SuppressWarnings("resource")
public class FileManager {

	private static final Log logger = LogFactory.getLog(FileManager.class);
	private FileManipulater fileManipulater = new FileManipulater();
	private static IFileService fileService;
	
	/**
	 * 静态数据化文件业务层实现类
	 */
	static {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/spring.xml");
		// 实例化文件信息Servie业务层方法
		fileService = (IFileService) applicationContext.getBean("fileService");
	}

	public static FileManager getInstance() {
		return _instance;
	}

	private static FileManager _instance = new FileManager();

	public void init() {
		FileMangeConfig.getInstance().loadConfig();
		this.fileManipulater.makeDirs("picture");
	}

	public FileVO getFileInfoById(int fileId) {
		try {
			return fileService.find(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description 通过文件信息得到文件ID信息
	 * @param file
	 * @param fileInfo
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public synchronized Integer getFileIdByFileInfo(File file,
			FileVO fileVO, Integer fileId) throws Exception {
		Integer fId = Integer.valueOf(0);
		if (!this.fileManipulater.existsFileDir(String.valueOf(fileVO.getUserId()),
				fileVO.getState())) {
			return Integer.valueOf(0);
		}
		String fileRealPath = this.fileManipulater.getFilePath(
				String.valueOf(fileVO.getUserId()), fileVO.getState(),
				FileMangeConfig.getInstance().fileNameGenerater(fileVO));

		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(FileMangeConfig.getInstance().fileNameGenerater(
				fileVO));
		fileInfo.setFilePath(fileVO.getAbsolutePath());
		fileVO.setFileName(FileMangeConfig.getInstance().fileNameGenerater(
				fileVO));
		fileVO.setFilePath(fileVO.getAbsolutePath());
		try {
			fId = fileService.add(fileInfo);
			logger.info("文件持久化成功！{文件+FileId：" + fileVO.getFileId()
					+ "，文件名称：" + fileVO.getInitName() + "，文件路劲："
					+ fileVO.getFilePath() + "}");
		} catch (Exception ex) {
			logger.info("文件持久化失败！{" + ex.getMessage() + "}");
			return Integer.valueOf(0);
		}
		boolean state = this.fileManipulater.saveFile(
				file,
				new File(this.fileManipulater.getFile(String.valueOf(fileInfo.getUserId()),
						fileVO.getState()), FileMangeConfig.getInstance()
						.fileNameGenerater(fileVO)));
		if (state) {
			// 通过Hession新增的文件信息，返回不了文件信息ID，所以这块重新查询一次文件信息
			if (0 == fileVO.getFileId()) {
				fileVO = fileService.findList(fileVO).get(0);
			}
			return fileVO.getFileId();
		}
		return Integer.valueOf(0);
	}

	/**
	 * @description 通过文件信息获得文件的IO流Stream
	 * @param file
	 * @param fileInfo
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public synchronized Integer getFileIdStreamByFileInfo(File file,
			FileVO fileVO, Integer fileId) throws Exception {
		Integer fId = Integer.valueOf(0);
		if (!this.fileManipulater.existsFileDir(String.valueOf(fileVO.getUserId()),
				fileVO.getState())) {
			return Integer.valueOf(0);
		}
		if (null == file) {
			logger.info("上传文件为空！");
			return Integer.valueOf(0);
		}
		String fileRealPath = this.fileManipulater.getFilePath(
				String.valueOf(fileVO.getUserId()), fileVO.getState(),
				FileMangeConfig.getInstance().fileNameGenerater(fileVO));

		File streamFile = null;
		try {
			streamFile = new File(fileRealPath);
		} catch (Exception e) {
			streamFile = null;
		}
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(FileMangeConfig.getInstance().fileNameGenerater(
				fileVO));
		fileInfo.setFilePath(streamFile.getAbsolutePath());
		fileVO.setFileName(FileMangeConfig.getInstance().fileNameGenerater(
				fileVO));
		fileVO.setFilePath(streamFile.getAbsolutePath());
		try {
			fId = fileService.add(fileInfo);
			logger.info("文件持久化成功！{文件FileId：" + fileInfo.getFileId()
					+ "，文件名称：" + fileInfo.getInitName() + "，文件路径："
					+ fileInfo.getFilePath() + "}");
		} catch (Exception ex) {
			logger.info("文件持久化失败！{" + ex.getMessage() + "}");
			return Integer.valueOf(0);
		}
		boolean state = this.fileManipulater.saveStreamFile(file, streamFile);
		if (state) {
			// 通过Hession新增的文件信息，返回不了文件信息ID，所以这块重新查询一次文件信息
			if (0 == fileInfo.getFileId()) {
				fileVO = fileService.findList(fileVO).get(0);
			}
			return fileInfo.getFileId();
		}
		return Integer.valueOf(0);
	}

	/**
	 * @description 上传用户图片信息
	 * @param file
	 * @param fileInfo
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public synchronized Integer uploadUserPicture(File file, FileVO fileVO,
			Integer fileId) throws Exception {
		if (!this.fileManipulater.existsUserPictureFileDir("picture")) {
			return Integer.valueOf(0);
		}
		if (null == file) {
			logger.info("上传图片为空！");
			return Integer.valueOf(0);
		}
		String fileRealPath = this.fileManipulater.getUserPictureFilePath(
				"picture",
				FileMangeConfig.getInstance().fileNameGenerater(fileVO));
		File streamFile = null;
		try {
			streamFile = new File(fileRealPath);
		} catch (Exception e) {
			streamFile = null;
		}
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(FileMangeConfig.getInstance().fileNameGenerater(
				fileVO));
		fileInfo.setFilePath(streamFile.getAbsolutePath());
		fileVO.setFileName(FileMangeConfig.getInstance().fileNameGenerater(
				fileVO));
		fileVO.setFilePath(streamFile.getAbsolutePath());
		try {
			fileService.add(fileInfo);
			logger.info("图片文件持久化成功！{文件fileId：" + fileInfo.getFileId()
					+ "，图片文件名称：" + fileInfo.getInitName() + "，图片文件路径："
					+ fileInfo.getFilePath() + "}");
		} catch (Exception ex) {
			logger.info("图片文件吃救护爱失败！{" + ex.getMessage() + "}");
			return Integer.valueOf(0);
		}
		boolean state = this.fileManipulater.saveStreamFile(file, streamFile);
		if (state) {
			// 通过Hession新增的文件信息，返回不了文件信息ID，所以这块重新查询一次文件信息
			if (0 == fileInfo.getFileId()) {
				fileVO = fileService.findList(fileVO).get(0);
			}
			return fileInfo.getFileId();
		}
		return Integer.valueOf(0);
	}

	/**
	 * @description 通过文件ID获得文件IO输入流
	 * @param fileId
	 * @return
	 */
	public InputStream getFileInputStreamByFileId(int fileId) {
		InputStream inputStream = null;
		FileVO fileVO = getFileInfoById(fileId);
		if (null != fileVO) {
			try {
				File file = new File(fileVO.getFilePath());
				inputStream = new BufferedInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				inputStream = null;
				logger.error("没有发现文件！" + e.getMessage());
			}
		}
		return inputStream;
	}

	/**
	 * @description 文件下载
	 * @param fileId
	 * @param servletContext
	 * @param response
	 */
	public void downLoadFile(int fileId, ServletContext servletContext,
			HttpServletResponse response) {
		try {
			String fileName;
			InputStream fis;
			if (fileId == -1) {
				fis = servletContext
						.getResourceAsStream("download/moban.xlsx");
				fileName = "教练导入文件模板下载.xlsx";
			} else {
				FileVO fileVO = getFileInfoById(fileId);
				File file = new File(fileVO.getFilePath());
				fis = new BufferedInputStream(new FileInputStream(file));
				fileName = fileVO.getInitName();
			}
			fileName = URLDecoder.decode(fileName, "UTF-8");

			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();

			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("GBK"), "ISO-8859-1"));

			OutputStream out = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");

			out.write(buffer);
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error("你下载的文件暂时不存在！" + e.getMessage());
		}
	}

	/**
	 * @description 通过文件ID删除一条文件信息
	 * @param fileId
	 * @return
	 */
	public boolean deleteFileByFileId(int fileId) {
		FileVO fileVO = getFileInfoById(fileId);
		if (null != fileVO) {
			try {
				fileService.deleteById(fileId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this.fileManipulater.removeFile(fileVO.getFilePath());
		}
		return false;
	}

	/**
	 * @description 通过文件ID批量删除一批文件信息
	 * @param fileIds
	 */
	public void deleteFileByFileIds(Integer[] fileIds) {
		if (null != fileIds) {
			for (Integer fileId : fileIds) {
				FileVO fileVO = getFileInfoById(fileId);
				if (null != fileVO) {
					this.fileManipulater.removeFile(fileVO.getFilePath());
				}
			}
			try {
				fileService.batchDelete(fileIds);
			} catch (LogicException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @description 通过驾校ID创建一条路劲
	 * @param projectId
	 * @return
	 */
	public boolean makeDirsByUserId(Integer projectId) {
		if (null != projectId) {
			this.fileManipulater.makeSubDirs(projectId);
			return true;
		}
		return false;
	}

	/**
	 * @param projectCode
	 * @return
	 */
	public boolean makeDirsByProjectCode(String projectCode) {
		if (null != projectCode) {
			this.fileManipulater.makeSubDirsCode(projectCode);
			return true;
		}
		return false;
	}
}
