package com.jinlong.system.model.po.file;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


/**
 * Description 上传和下载的文件信息类
 * @author 肖学进
 */
@Data
public class FileInfo implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8107533144313673124L;
	
	/**
	 * 文件ID
	 */
	private int fileId;
	
	/**
	 * 文件类别ID
	 */
	private int filelTypeId;
	
	/**
	 * 上传文件用户ID
	 */
	private int userId;
	
	/**
	 * 文件上传之前的名字
	 */
	private String initName;
	
	/**
	 * 文件上传之后的名字
	 */
	private String fileName;
	
	/**
	 * 文件上传到的路径
	 */
	private String filePath;
	
	/**
	 * 文件上传提交时间
	 */
	private Date submitTime;
	
	/**
	 * 文件描述
	 */
	private String description;
	
	/**
	 * 文件状态
	 */
	private int state;
	
	/**
	 * 文件是都上传成功
	 */
	private int fileFlag;
	
}