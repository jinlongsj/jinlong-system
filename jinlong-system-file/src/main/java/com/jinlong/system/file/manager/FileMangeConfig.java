package com.jinlong.system.file.manager;


import java.util.Properties;

import com.jinlong.system.common.utils.config.PropertiesConfig;
import com.jinlong.system.model.vo.file.FileVO;

/**
 * @文件配置管理器
 * @author Administrator
 */
public class FileMangeConfig {

	public static final String FILE_MANAGER_CFG_FILENAME = "filemanager";

	public static FileMangeConfig getInstance() {
		return _instance;
	}

	private static FileMangeConfig _instance = new FileMangeConfig();

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	private String rootPath = "";

	public String getRootPath() {
		return this.rootPath;
	}

	public void setCodeTicket(String codeTicket) {
		this.codeTicket = codeTicket;
	}

	private String codeTicket = "";

	public String getCodeTicket() {
		return this.codeTicket;
	}

	public void loadConfig() {
		Properties fileManageProp = PropertiesConfig.getInstance()
				.getProperties("filemanager");

		setRootPath(fileManageProp.getProperty("root.path"));

		setCodeTicket(fileManageProp.getProperty("code.ticket"));
	}

	public String fileNameGenerater(FileVO fileVO) {
		int pos = fileVO.getInitName().indexOf(".");
		if (pos == -1) {
			return fileVO.getInitName() + "_" + fileVO.getUserId() + "_"
					+ System.currentTimeMillis();
		}
		String prefixFileName = fileVO.getInitName().substring(0, pos);
		String suffixFileName = fileVO.getInitName().substring(pos,
				fileVO.getInitName().length());
		return prefixFileName + "_" + fileVO.getUserId() + "_"
				+ System.currentTimeMillis() + suffixFileName;
	}
}
