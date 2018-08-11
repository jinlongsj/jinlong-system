package com.jinlong.system.file.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @description 文件操作器
 * @author 肖学进
 */
public class FileManipulater {

	private static final Log logger = LogFactory.getLog(FileManipulater.class);
	
	// 驾校图片文件
	private static final String SCHOOL_FILE = "school";
	// 车辆图片文件
	private static final String VELICLE_FILE = "velicle";
	// 场地图片文件
	private static final String FIELD_FILE = "field";
	// 路线图片文件
	private static final String ROUTE_FILE = "route";
	// 教练图片文件
	private static final String COACH_FILE = "coach";
	// 学员图片文件
	private static final String STUDENT_FILE = "student";
	// 广告图片文件
	private static final String ADVERT_FILE = "advert";
	// 文件路径Map
	private static final Map<Integer, String> FILE_MAP = new HashMap<Integer, String>();

	/**
	 * 静态初始化：不同模块下的文件
	 */
	static {
	    FILE_MAP.put(Integer.valueOf(1), SCHOOL_FILE);
	    FILE_MAP.put(Integer.valueOf(2), VELICLE_FILE);
	    FILE_MAP.put(Integer.valueOf(3), FIELD_FILE);
	    FILE_MAP.put(Integer.valueOf(4), ROUTE_FILE);
	    FILE_MAP.put(Integer.valueOf(5), COACH_FILE);
	    FILE_MAP.put(Integer.valueOf(6), STUDENT_FILE);
	    FILE_MAP.put(Integer.valueOf(7), ADVERT_FILE);
	}

	/**
	 * @description 保存文件
	 * @param srcFile
	 * @param testFile
	 * @return
	 */
	public boolean saveFile(File srcFile, File testFile) {
		boolean state = true;
		try {
			FileUtils.copyFile(srcFile, testFile);
			state = true;
			logger.info("文件上传成功！");
		} catch (IOException e) {
			state = false;
			logger.error("文件上传失败！" + e);
		}
		return state;
	}

	/**
	 * @description 保存IO流Stream
	 * @param srcFile
	 * @param testFile
	 * @return
	 */
	public boolean saveStreamFile(File srcFile, File testFile) {
		boolean uploadFileState = true;

		FileOutputStream fos = null;

		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(testFile);

			fis = new FileInputStream(srcFile);
			byte[] buffer = new byte['?'];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			logger.info("文件上传成功！");

			return uploadFileState;
		} catch (Exception e) {
			uploadFileState = false;
			logger.error("文件上传失败！" + e);
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (Exception e) {
					logger.error("关闭输入流错误！" + e);
				}
			}
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					logger.error("关闭输出流错误！" + e);
				}
			}
		}
		return uploadFileState;
	}

	/**
	 * @description 创建一批路径
	 * @param userId
	 */
	public void makeSubDirs(Integer userId) {
		try {
			String basePath = FileMangeConfig.getInstance().getRootPath();
			String fileWhole = FilenameUtils.concat(basePath,
					userId.toString());

			Iterator<Integer> iterator = FILE_MAP.keySet().iterator();
			while (iterator.hasNext()) {
				Integer key = (Integer) iterator.next();
				String subFile = (String) FILE_MAP.get(key);
				String mkSubFile = FilenameUtils.concat(fileWhole, subFile);
				createDirs(mkSubFile);
				logger.info("创建目录成功！目录为：" + mkSubFile);
			}
		} catch (Exception e) {
			logger.error("创建目录失败" + e);
		}
	}

	/**
	 * @description 创建一批路径编号
	 * @param projectCode
	 */
	public void makeSubDirsCode(String projectCode) {
		try {
			String basePath = FileMangeConfig.getInstance().getRootPath();
			String fileWhole = FilenameUtils.concat(basePath, projectCode);

			Iterator<Integer> iterator = FILE_MAP.keySet().iterator();
			while (iterator.hasNext()) {
				Integer key = (Integer) iterator.next();
				String subFile = (String) FILE_MAP.get(key);
				String mkSubFile = FilenameUtils.concat(fileWhole, subFile);
				createDirs(mkSubFile);
				logger.info("创建目录成为！目录为：" + mkSubFile);
			}
		} catch (Exception e) {
			logger.error("创建目录失败！" + e);
		}
	}

	/**
	 * @description 创建一批路劲
	 * @param filePath
	 */
	public void makeDirs(String filePath) {
		try {
			String basePath = FileMangeConfig.getInstance().getRootPath();
			String fileWhole = FilenameUtils.concat(basePath, filePath);
			createDirs(fileWhole);
			logger.info("创建目录成功！目录为：" + fileWhole);
		} catch (Exception e) {
			logger.error("创建目录失败！" + e);
		}
	}

	/**
	 * @description 获得用户图片文件
	 * @param userId
	 * @param fileFlag
	 * @return
	 */
	public File getFile(String userId, Integer fileFlag) {
		String basePath = FileMangeConfig.getInstance().getRootPath();
		String projectPath = FilenameUtils.concat(basePath, (userId != "")
				&& (userId != null) ? userId.toString() : null);
		String modulePath = FilenameUtils
				.concat(projectPath,
						(userId != "") && (userId != null) ? (String) FILE_MAP
								.get(fileFlag) : null);
		File file = null;
		try {
			file = new File(modulePath);
			if (!file.exists()) {
			}
			return file;
		} catch (Exception e) {
			logger.error("获取文件上传目录失败！" + modulePath + e);
			file = null;
		}
		return file;
	}

	/**
	 * @description 获得用户文件的全路径
	 * @param userId
	 * @param fileFlag
	 * @param fileName
	 * @return
	 */
	public String getFilePath(String userId, Integer fileFlag,
			String fileName) {
		String basePath = FileMangeConfig.getInstance().getRootPath();
		String projectPath = FilenameUtils.concat(basePath, (userId != "")
				&& (userId != null) ? userId.toString() : null);
		String modulePath = FilenameUtils
				.concat(projectPath,
						(userId != "") && (userId != null) ? (String) FILE_MAP
								.get(fileFlag) : null);
		String filePath = FilenameUtils.concat(modulePath, fileName);
		return filePath;
	}

	/**
	 * @description 获得用户图片文件的全路径
	 * @param dir
	 * @param fileName
	 * @return
	 */
	public String getUserPictureFilePath(String dir, String fileName) {
		String basePath = FileMangeConfig.getInstance().getRootPath();
		String dirPath = FilenameUtils.concat(basePath, (dir != "")
				&& (dir != null) ? dir : null);
		String filePath = FilenameUtils.concat(dirPath, fileName);
		return filePath;
	}

	/**
	 * @description 判断文件是否存在
	 * @param userId
	 * @param fileFlag
	 * @return
	 */
	public boolean existsFileDir(String userId, Integer fileFlag) {
		boolean exist = true;
		String basePath = FileMangeConfig.getInstance().getRootPath();
		String projectPath = FilenameUtils.concat(basePath, (userId != "")
				&& (userId != null) ? userId : null);
		String modulePath = FilenameUtils
				.concat(projectPath,
						(userId != "") && (userId != null) ? (String) FILE_MAP
								.get(fileFlag) : null);
		try {
			File file = new File(modulePath);
			if (file.exists()) {
				logger.info("存在上传目录！目录为：" + modulePath);
				exist = true;
			} else {
				logger.info("不存在上传目录！目录为：" + modulePath);
				makeSubDirsCode(userId);
				logger.info("创建上传目录为：" + modulePath);
				exist = true;
			}
		} catch (Exception e) {
			logger.info("目录错误！目录为：" + modulePath + e.getMessage());
			exist = false;
		}
		return exist;
	}

	/**
	 * @description 判断用户图片文件是否存在
	 * @param dir
	 * @return
	 */
	public boolean existsUserPictureFileDir(String dir) {
		boolean exist = true;
		String basePath = FileMangeConfig.getInstance().getRootPath();
		String pictureDir = FilenameUtils.concat(basePath, (dir != "")
				&& (dir != null) ? dir : null);
		try {
			File file = new File(pictureDir);
			if (file.exists()) {
				logger.info("已存在上传目录！目录为" + pictureDir);
				exist = true;
			} else {
				logger.info("不存在上传目录" + pictureDir);

				makeDirs(dir);
				logger.info("创建上传目录成功！目录为：" + pictureDir);
				exist = true;
			}
		} catch (Exception e) {
			logger.info("目录错误！目录为：" + pictureDir + e.getMessage());
			exist = false;
		}
		return exist;
	}

	/**
	 * @description 删除文件目录，或者文件
	 * @param filePath
	 * @return
	 */
	public boolean removeFile(String filePath) {
		boolean delFlag = true;
		try {
			File file = new File(filePath);
			if (file.isDirectory()) {
				delFlag = false;
				logger.info("此文件是一个目录，不能进行文件删除！目录："
						+ filePath);
			} else if (file.isFile()) {
				delFlag = file.delete();
				logger.info("物理磁盘上的文件：" + filePath + " 删除成功！");
			} else {
				delFlag = false;
				logger.info("此文件不是一个文件，不能进行文件删除！文件：" + filePath);
			}
		} catch (Exception e) {
			delFlag = false;
			logger.error("文件目录不存在，删除错误！文件：" + filePath
					+ e.getMessage());
		}
		return delFlag;
	}

	/**
	 * @description 创建一个文件路劲
	 * @param path
	 */
	private void createDirs(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
