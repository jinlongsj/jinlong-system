package com.system.excel.model.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.system.excel.constant.ParseFileError;
import com.system.excel.model.singletion.FileContentError;

import lombok.Data;

/**
 * @description 文件解析结果类
 * @author xiaoxj
 */
@Data
public class FileParseResult implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6036973028142945189L;
	
	/**
	 * Excel表头
	 */
	private ArrayList<Object> head = new ArrayList<Object>();

	/**
	 * Excel数据
	 */
	private List <ArrayList<Object>> datas = new ArrayList<ArrayList<Object>>();

	/**
	 * 行号
	 */
	private Integer row = Integer.valueOf(0);

	/**
	 * 列号
	 */
	private Integer column = Integer.valueOf(0);

	/**
	 * 错误行号
	 */
	private Integer errorRowNumber = Integer.valueOf(0);

	/**
	 * 错误列号
	 */
	private Integer errorCellNumber = Integer.valueOf(0);

	/**
	 * 错误文件
	 */
	private Integer errorFile = ParseFileError.ERROR_SUCCESS;

	/**
	 * 接卸信息
	 */
	private String parserMessage = "";

	private List<FileContentError> contentErrors = new ArrayList<FileContentError>();

}
