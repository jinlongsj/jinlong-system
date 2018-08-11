package com.jinlong.system.model.vo.file;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Description 文件视图类
 * @author 肖学进
 */
@Data
public class FileVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4269233840983717926L;
	
	/**
	 * 文件类别信息
	 */
	
	/**
	 * 文件类别ID
	 */
	private Integer filelTypeId;
	
	/**
	 * 父文件分类类别ID
	 */
	private Integer parentId;
	
	/**
	 * 文件分类类别名称
	 */
	private String fileTypeName;
	
	/**
	 * 文件分类类别详情
	 */
	private String fileTypeDescription;
	
	/**
	 * 文件信息
	 */
	
	/**
	 * 文件ID
	 */
	private Integer fileId;
	
	/**
	 * 上传者ID
	 */
	private Integer userId;
	
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
	 * 绝对路径
	 */
	private String absolutePath;
	
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
	private Integer state;

}
